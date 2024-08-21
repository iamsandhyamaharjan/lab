package Lab15;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class DayTimeClient {
  public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a UDP socket
            socket = new DatagramSocket();

            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Replace with server address if needed
            int port = 13;

            // Send an empty request packet to the server
            byte[] buffer = new byte[1];
            DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverAddress, port);
            socket.send(request);

            // Prepare a buffer to receive the response
            byte[] responseBuffer = new byte[256];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);

            // Receive the response from the server
            socket.receive(response);

            // Convert the response to a string and print it
            String receivedTime = new String(response.getData(), 0, response.getLength());
            System.out.println("Current Date and Time from Server: " + receivedTime);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }   
}
