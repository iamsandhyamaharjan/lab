package Lab14;
import java.io.*;
import java.net.*;
public class SimpleServer {
  public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 65432
            ServerSocket serverSocket = new ServerSocket(65432);
            System.out.println("Server is listening on port 65432");

            // Wait for a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams from the socket
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Read message from the client
            String message = reader.readLine();
            System.out.println("Received from client: " + message);

            // Send the same message back to the client (echo)
            writer.println("Server received: " + message);

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}
