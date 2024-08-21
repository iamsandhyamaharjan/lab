/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab18;

import java.rmi.RemoteException; 
// RemoteException is thrown when a remote method invocation fails.
import java.rmi.server.UnicastRemoteObject;       
// UnicastRemoteObject is used to export the remote object so it can receive incoming remote method calls.

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {  
//MyRemoteImpl that extends UnicastRemoteObject and implements the MyRemote interface.
    protected MyRemoteImpl() throws RemoteException {  
        // Define a protected constructor for MyRemoteImpl, which throws a RemoteException.
        // The constructor calls the superclass constructor (UnicastRemoteObject) to export the object.
        super();
    }

    @Override
    public String sayHello() throws RemoteException {  
        // Override the sayHello method from the MyRemote interface, which throws a RemoteException.
        // This method returns the string "Hello, World!" when invoked remotely.
        return "Hello, World!";
    }

    public static void main(String[] args) {  
        // Main method to start the server and bind the remote object to the RMI registry.
        try {
            MyRemoteImpl obj = new MyRemoteImpl();  
            // Create an instance of MyRemoteImpl, which automatically exports the object.

            java.rmi.Naming.rebind("rmi://localhost:2000/MyRemote", obj);
 
            // Bind the remote object to the RMI registry with the name "MyRemote" at the specified URL.
            // This allows clients to look up and invoke methods on the remote object.

            System.out.println("Server is ready.");  
            // Print a message to indicate that the server is ready to accept remote method calls.
        } catch (Exception e) {
            System.out.println("Server failed: " + e);  
            // If an exception occurs, print an error message with the exception details.
        }
    }
}

