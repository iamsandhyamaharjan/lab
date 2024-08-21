/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class7;

/**
 *
 * @author Dell
 */import java.net.*;
import java.io.*;

public class SocketInfo {
    public static void main(String[] args) {
        
        try{
        Socket soc=new Socket("www.example.com",80);
            System.out.println("Connect to" + soc.getInetAddress()+ "on Port" + soc.getPort() + "from my " + soc.getLocalAddress()+"of"
            + soc.getLocalPort()
            );
        
        }catch(IOException ex){System.out.println("ex");}
    }
    
}
