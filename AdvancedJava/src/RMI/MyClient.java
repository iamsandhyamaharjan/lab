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
public class MyClient {
    public static void main(String[] args) {
        try{
        Adder stub=(Adder)Naming.lookup("rmi://localhost:5000/ram");
        System.out.println("Printing");
        System.out.println(stub.add(34, 4));
        
        }catch(MalformedURLException | NotBoundException | RemoteException e){}
    }
}
