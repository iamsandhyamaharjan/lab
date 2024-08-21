/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Dell
 */
public class AdderRemote extends UnicastRemoteObject implements Adder {
    AdderRemote() throws RemoteException{
    super();
    }
    public int add(int x, int y){
    return x+y;
    }
    
}
