import java.net.*; // Importing the InetAddress class to work with IP addresses
import java.util.*; // Importing the Enumeration class to iterate over collections
public class NetworkInterfaces1 {
    public static void main(String[] args) {
        try {        
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();    
                System.out.println("Interface Name: " + networkInterface.getName());     
                System.out.println("Display Name: " + networkInterface.getDisplayName());  
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
