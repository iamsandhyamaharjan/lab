package Lab1; // Declares the package name

import java.net.*; // Imports classes from the java.net package for networking operations

// NetworkInfo class to hold the IP and MAC address details
public class NetworkInfo {
    private InetAddress ipAddress; // Declares a private field to store the IP address
    private byte[] macAddress; // Declares a private field to store the MAC address as a byte array

    // Private constructor to prevent direct instantiation
    private NetworkInfo(InetAddress ipAddress, byte[] macAddress) {
        this.ipAddress = ipAddress; // Assigns the IP address to the field
        this.macAddress = macAddress; // Assigns the MAC address to the field
    }

    // Getter method for the IP address
    public String getIpAddress() {
        return ipAddress.getHostAddress(); // Returns the IP address as a string
    }

    // Getter method for the MAC address
    public String getMacAddress() {
        StringBuilder stringBuilder = new StringBuilder(); // Creates a new StringBuilder for formatting the MAC address
        if (macAddress != null) { // Check if macAddress is not null
            for (int i = 0; i < macAddress.length; i++) { // Iterates over the byte array of the MAC address
                stringBuilder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : "")); // Formats each byte to a two-digit hex string and appends it to the StringBuilder
            }
            return stringBuilder.toString(); // Returns the formatted MAC address as a string
        } else {
            return "MAC Address not available"; // Return a message if macAddress is null
        }
    }

    // Factory class to create instances of NetworkInfo
    public static class NetworkInfoFactory {
        // Factory method to create and return a NetworkInfo instance
        public static NetworkInfo createNetworkInfo() throws Exception {
            InetAddress ipAddress = InetAddress.getLocalHost(); // Retrieves the local IP address
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress); // Retrieves the network interface associated with the IP address
            byte[] macAddress = null; // Initialize macAddress to null
            if (networkInterface != null) { // Check if networkInterface is not null
                macAddress = networkInterface.getHardwareAddress(); // Retrieves the MAC address
            }
            return new NetworkInfo(ipAddress, macAddress); // Creates and returns a new NetworkInfo instance
        }
    }

    public static void main(String[] args) { // Main method of the program
        try { // Starts a try block to catch potential exceptions
            NetworkInfo networkInfo = NetworkInfoFactory.createNetworkInfo(); // Uses the factory method to create a NetworkInfo instance
            System.out.println("IP Address: " + networkInfo.getIpAddress()); // Prints the IP address using the getIpAddress() method
            System.out.println("MAC Address: " + networkInfo.getMacAddress()); // Prints the MAC address using the getMacAddress() method
        } catch (UnknownHostException e) { // Catches specific exception for unknown host
            System.err.println("Unknown Host Exception: " + e.getMessage()); // Prints the exception message
            e.printStackTrace(); // Prints the stack trace of the exception
        } catch (SocketException e) { // Catches specific exception for socket issues
            System.err.println("Socket Exception: " + e.getMessage()); // Prints the exception message
            e.printStackTrace(); // Prints the stack trace of the exception
        } catch (Exception e) { // Catches any other exceptions
            System.err.println("Exception: " + e.getMessage()); // Prints the exception message
            e.printStackTrace(); // Prints the stack trace of the exception
        }
    }
}
