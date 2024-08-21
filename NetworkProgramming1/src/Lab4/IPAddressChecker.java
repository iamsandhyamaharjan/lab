
import java.net.*;
import java.util.Scanner;

public class IPAddressChecker {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first IP address: ");
        String ipAddress1 = scanner.nextLine();
        String result1 = determineIPType(ipAddress1);
        System.out.println("The IP address " + ipAddress1 + " is " + result1 + ".");
        System.out.print("Enter the second IP address: ");
        String ipAddress2 = scanner.nextLine();
        String result2 = determineIPType(ipAddress2);
        System.out.println("The IP address " + ipAddress2 + " is " + result2 + ".");
        scanner.close();
    }
}
