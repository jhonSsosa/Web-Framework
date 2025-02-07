/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.webproyect;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.mycompany.webproyect.HTTPServer.staticfiles;
import static com.mycompany.webproyect.HTTPServer.get;

public class Webproyect {
    public static void main(String[] args) throws IOException, URISyntaxException {
        staticfiles("/webroot");
        get("/app/hello", (req, resp) -> "Hello World");
        get("/app/pi", (req, res) -> {
            return String.valueOf(Math.PI);
        });
        get("/app/e", (req, res) -> {
            return String.valueOf(Math.E);
        });
    }
}