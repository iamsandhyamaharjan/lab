 import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class PortScanner {

    public static void main(String[] args) {
        int startPort = 1;
        int endPort = 65535;

        System.out.println("Scanning for TCP ports...");
        scanTCPPorts(startPort, endPort);

        System.out.println("Scanning for UDP ports...");
        scanUDPPorts(startPort, endPort);
    }

    private static void scanTCPPorts(int startPort, int endPort) {
        for (int port = startPort; port <= endPort; port++) {
            try (ServerSocket serverSocket = new ServerSocket()) {
                serverSocket.bind(new InetSocketAddress(port));
            } catch (IOException e) {
                System.out.println("TCP port " + port + " is open.");
            }
        }
    }

    private static void scanUDPPorts(int startPort, int endPort) {
        for (int port = startPort; port <= endPort; port++) {
            try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
                datagramSocket.setSoTimeout(1000);
            } catch (IOException e) {
                System.out.println("UDP port " + port + " is open.");
            }
        }
    }
}
