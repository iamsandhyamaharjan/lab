import java.net.*;
import java.util.Scanner;
import java.io.IOException;
public class TestIP {

    public static String determineIPType(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            if (address instanceof Inet4Address) {
                return "IPv4";
            } else if (address instanceof Inet6Address) {
                return "IPv6";
            }
        } catch (UnknownHostException e) {
            return "Invalid IP address";
        }
        return "Invalid IP address";
    }

    public static void testIPCharacteristics(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);

            // Check if the IP address is reachable
            boolean isReachable = address.isReachable(1000); // Timeout in milliseconds
            System.out.println("Reachable: " + isReachable);

            // Check if the IP address is a loopback address
            boolean isLoopback = address.isLoopbackAddress();
            System.out.println("Loopback Address: " + isLoopback);

            // Check if the IP address is a multicast address
            boolean isMulticast = address.isMulticastAddress();
            System.out.println("Multicast Address: " + isMulticast);

            // Check if the IP address is any local address (for IPv6)
            boolean isAnyLocal = address.isAnyLocalAddress();
            System.out.println("Any Local Address: " + isAnyLocal);

            // Check if the IP address is a link-local address (for IPv6)
            boolean isLinkLocal = address.isLinkLocalAddress();
            System.out.println("Link Local Address: " + isLinkLocal);

            // Check if the IP address is a site-local address (for IPv6)
            boolean isSiteLocal = address.isSiteLocalAddress();
            System.out.println("Site Local Address: " + isSiteLocal);

            // Check if the IP address is a global unicast address (for IPv6)
            boolean isGlobalUnicast = !isMulticast && !isAnyLocal && !isLinkLocal && !isSiteLocal;
            System.out.println("Global Unicast Address: " + isGlobalUnicast);

        } catch (UnknownHostException e) {
            System.out.println(ip + " is not a valid IP address.");
        } catch (IOException e) {
            System.out.println("Unable to check reachability of " + ip);
        }
    }

    public static void main(String[] args) {
        String ipAddress1 = "127.0.0.1";
        String result1 = determineIPType(ipAddress1);
        System.out.println("The IP address " + ipAddress1 + " is " + result1 + ".");
        if (!result1.equals("Invalid IP address")) {
            testIPCharacteristics(ipAddress1);
        }

        String ipAddress2 = "0::1";
        String result2 = determineIPType(ipAddress2);
        System.out.println("The IP address " + ipAddress2 + " is " + result2 + ".");
        if (!result2.equals("Invalid IP address")) {
            testIPCharacteristics(ipAddress2);
        }
    }
}
