/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class5;

import java.io.*;
import java.net.*;
import java.util.Date;

public class HttpHeader {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            System.out.println("Request Method " + connection.getRequestMethod());
            System.out.println("Response Code" + connection.getResponseCode());
            System.out.println("Response Message" + connection.getResponseMessage());
            System.out.println("Content Type" + connection.getContentType());
            System.out.println("Content Length" + connection.getContentLength());
            System.out.println("Date" + new java.util.Date(connection.getDate()));
            System.out.println("Last Modiified" + new java.util.Date(connection.getLastModified()));

        } catch (Exception e) {
            // Handle the malformed URL exception
            System.out.println("Malformed URL: " + e.getMessage());
        }

    }
}
