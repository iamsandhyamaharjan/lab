package Lab1; // Declares the package name
import java.net.*; // Imports classes from the java.net package for networking operations
public class IpAddress { // Defines a public class named IpAddress
    public static void main(String[] args) throws Exception { // Main method declaration with exception handling
       // Retrieve the local IP address
        InetAddress ipAddress = InetAddress.getLocalHost();
        System.out.println("Ip Address : " + ipAddress); // Print the IP address
        // Retrieve the network interface associated with the local IP address
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
        byte[] mac = networkInterface.getHardwareAddress(); // Get the MAC address as a byte array
        System.out.println("MAC address :");
        // Format and print the MAC address
        StringBuilder stringBuilder = new StringBuilder(); // Create a StringBuilder for formatting
        for (int i = 0; i < mac.length; i++) { // Iterate over the byte array of the MAC address
            stringBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "")); // Format each byte to a two-digit hex string and append to StringBuilder
        }
        System.out.println(stringBuilder.toString()); // Print the formatted MAC address
    }
}
//    NetworkInterface network = NetworkInterface.getByInetAddress(addr);
