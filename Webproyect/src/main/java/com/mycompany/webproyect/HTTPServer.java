package com.mycompany.webproyect;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Servidor iniciado en el puerto 35000...");
        } catch (IOException e) {
            System.err.println("No se pudo escuchar en el puerto 35000.");
            System.exit(1);
        }
        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Cliente conectado...");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String requestLine = in.readLine();
                if (requestLine != null) {
                    System.out.println("Solicitud recibida: " + requestLine);
                    String[] requestParts = requestLine.split(" ");
                    String requestMethod = requestParts[0];
                    String requestUri = requestParts[1];
                    if (requestMethod.equals("GET")) {
                        String filePath = requestUri.split("\\?")[0];
                        if (filePath.equals("/")) {
                            filePath = "/index.html";
                        }
                        String outputLine = FileController.getFileContent(filePath);
                        out.println("HTTP/1.1 200 OK\r\n"
                                + "Content-Type: " + FileController.getMimeType(filePath) + "\r\n"
                                + "Content-Length: " + outputLine.getBytes(StandardCharsets.UTF_8).length + "\r\n"
                                + "\r\n"
                                + outputLine);
                    }
                }
                in.close();
                out.close();
            } catch (IOException e) {
                System.err.println("Error al manejar la solicitud: " + e.getMessage());
            }
        }
    }
}
