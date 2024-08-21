package Lab14;
import java.io.*;
import java.net.*;

public class SimpleClient {
 public static void main(String[] args) {
        try {
            // Connect to the server running on localhost at port 65432
            Socket socket = new Socket("localhost", 65432);
            System.out.println("Connected to the server");

            // Get input and output streams from the socket
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send a message to the server
            String message = "Hello, Server!";
            writer.println(message);
            System.out.println("Sent to server: " + message);

            // Read the response from the server
            String response = reader.readLine();
            System.out.println("Received from server: " + response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
