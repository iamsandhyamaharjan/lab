/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.net.MalformedURLException;
import java.rmi.*;
/**
 *
 * @author Dell
 */
public class MyServer {
    public static void main(String[] args) {
        try{
        Adder stub = new AdderRemote();
        Naming.rebind("rmi://localhost:5000/ram",stub);
        }catch(MalformedURLException | RemoteException e){ System.out.println(e);}
    }
}
