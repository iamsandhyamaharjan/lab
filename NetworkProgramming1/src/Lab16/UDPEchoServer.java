package Lab16;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDPEchoServer {
public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a UDP socket that listens on port 9876
            socket = new DatagramSocket(9876);
            System.out.println("UDP Echo Server is running...");

            while (true) {
                // Buffer to receive incoming data
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                // Receive data from the client
                socket.receive(receivePacket);
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedData);

                // Send the received data back to the client (echo it)
                DatagramPacket sendPacket = new DatagramPacket(
                        receivePacket.getData(),
                        receivePacket.getLength(),
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );
                socket.send(sendPacket);
                System.out.println("Echoed back to client: " + receivedData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
