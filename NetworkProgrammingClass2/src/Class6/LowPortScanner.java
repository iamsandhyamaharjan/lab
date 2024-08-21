package Class6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
//Wap to find the running port  in your machine 
import java.net.*;
import java.io.*;

public class LowPortScanner {
    public static void main(String[] args) {
        try {
            String host = "127.0.0.1";
            for(int i = 0; i < 1024; i++) { // Initialize i to 0
                Socket s = new Socket(host, i);
                System.out.println("There is a service running on port " + s.getPort() + " of my host " + host);
                s.close();
            }
        }
        catch(UnknownHostException ex) {
                System.out.println(ex);
            }
        catch(IOException ex) {
                System.out.println(ex);
            }
        }
    }