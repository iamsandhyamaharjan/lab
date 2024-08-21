package Lab121;
import java.net.*;
public class SocketInfo {
  public static void main(String[] args) {
        try {
            // Creating a socket to connect to a server
            Socket socket = new Socket("example.com", 80);

            // Get the remote address and port
            InetAddress remoteAddress = socket.getInetAddress();
            int remotePort = socket.getPort();

            // Get the local address and port
            InetAddress localAddress = socket.getLocalAddress();
            int localPort = socket.getLocalPort();

            // Display the information
            System.out.println("Remote Address: " + remoteAddress);
            System.out.println("Remote Port: " + remotePort);
            System.out.println("Local Address: " + localAddress);
            System.out.println("Local Port: " + localPort);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
