package Lab121;
import java.io.*;
import java.net.*;
import java.util.Date;
public class DayTimeServer {
    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 1313
            ServerSocket serverSocket = new ServerSocket(1913);
            System.out.println("Daytime server is running on port 1313...");

            while (true) {
                // Accept an incoming connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Get the output stream to send the daytime information
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Send the current date and time to the client
                out.println(new Date().toString());

                // Close the client connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
