package com.mycompany.webproyect;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URL;
import java.io.InputStream;

public class FileController {
    public static String getFileContent(String filePath) {
        try {
            if (filePath.equals("/")) {
                filePath = "/index.html";
            }
            URL resourceUrl = FileController.class.getResource(filePath);
            if (resourceUrl == null) {
                return "<h1>Error 404 - Archivo no encontrado</h1>";
            }
            try (InputStream inputStream = resourceUrl.openStream()) {
                byte[] fileContent = inputStream.readAllBytes();
                if (getMimeType(filePath).startsWith("image")) {
                    return new String(fileContent);
                } else {
                    return new String(fileContent);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return "<h1>Error 404 - Archivo no encontrado</h1>";
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
