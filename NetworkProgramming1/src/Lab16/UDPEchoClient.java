
package Lab16;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPEchoClient {
  public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a UDP socket
            socket = new DatagramSocket();

            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            // Message to be sent to the server
            String message = "Hello, UDP Echo Server!";
            byte[] sendBuffer = message.getBytes();

            // Send the message to the server
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
            socket.send(sendPacket);
            System.out.println("Sent to server: " + message);

            // Buffer to receive the echoed message
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            // Receive the echoed message from the server
            socket.receive(receivePacket);
            String echoedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + echoedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}