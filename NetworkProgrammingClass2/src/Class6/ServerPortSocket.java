package Class6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
// Wap to find the running port in your machine 
import java.net.*;
import java.io.*;

public class ServerPortSocket {
    public static void main(String[] args) {
        for (int port = 1024; port <= 65235; port++) {
            try {
                ServerSocket server = new ServerSocket(port);
                // Successfully created a server socket, so the port is free
                server.close();
            } catch (IOException ex) {
                // If an IOException is thrown, it means the port is in use
                System.out.println("There is a service running on port " + port);
            }
        }
    }
}
