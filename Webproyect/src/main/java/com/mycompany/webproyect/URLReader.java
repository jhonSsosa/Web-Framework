package com.mycompany.webproyect;

import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {

    public static void main(String[] args) {
        try {
            URL myurl = new URL("http://idbn.is.escuelaing.edu.co:8080/path/to/resource?name=John&age=30#section1");

            System.out.println("Protocol: " + myurl.getProtocol());
            System.out.println("Authority: " + myurl.getAuthority());
            System.out.println("Host: " + myurl.getHost());
            System.out.println("Port: " + myurl.getPort());
            System.out.println("Path: " + myurl.getPath());
            System.out.println("Query: " + myurl.getQuery());
            System.out.println("File: " + myurl.getFile());
            System.out.println("Ref: " + myurl.getRef());
        } catch (MalformedURLException e) {
            System.err.println("URL mal formada: " + e.getMessage());
        }
    }
}
