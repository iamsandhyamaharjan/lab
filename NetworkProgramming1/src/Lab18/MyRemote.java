/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Lab18;

import java.rmi.Remote; 
/* Import the Remote interface from the java.rmi package that is  being accessible remotely via RMI */
import java.rmi.RemoteException; /*RemoteException is thrown when a remote method invocation fails*/

public interface MyRemote extends Remote {
/*This interface will be used to declare methods that can be invoked from a remote client.*/
    String sayHello() throws RemoteException; 
/*The method must throw a RemoteException to handle exceptions during the remote call. */
}


