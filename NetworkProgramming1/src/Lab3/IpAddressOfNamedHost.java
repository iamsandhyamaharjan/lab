import java.net.*;
public class IpAddressOfNamedHost {
    public static void main(String[] args) {
        String[] hostNames = {"scst.edu.np", "www.google.com", "www.facebook.com"};
        for (String hostName : hostNames) {
            try {
                InetAddress[] addresses = InetAddress.getAllByName(hostName);
                System.out.println("Host: " + hostName);           
                for (InetAddress address : addresses) {
                    System.out.println("IP Address: " + address.getHostAddress());
                }        
                System.out.println(); // Add a blank line for separation
            } catch (UnknownHostException e) {
                // Print the stack trace if the host name cannot be resolved
                System.out.println("Unable to resolve host: " + hostName);
                e.printStackTrace();
            }
        }
    }
}
