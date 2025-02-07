package com.mycompany.webproyect;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileController {
    public static byte[] getFileContent(String filePath) {
        try {
            URL resourceUrl = FileController.class.getResource(filePath);
            if (resourceUrl == null) {
                System.err.println("Archivo no encontrado: " + filePath);
                return null;
            }
            try (InputStream inputStream = resourceUrl.openStream()) {
                return inputStream.readAllBytes();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }
    public static String getMimeType(String filePath) {
        if (filePath.endsWith(".html")) {
            return "text/html";
        } else if (filePath.endsWith(".css")) {
            return "text/css";
        } else if (filePath.endsWith(".js")) {
            return "application/javascript";
        } else if (filePath.endsWith(".png")) {
            return "image/png";
        } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
            return "image/jpeg";
        }
        return "application/octet-stream";
    }
}
