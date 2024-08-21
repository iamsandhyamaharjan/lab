import java.io.*;
import java.net.*;

public class SimpleChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 54321);
            System.out.println("Connected to the server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received from server: " + message); // Debug print
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();

            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                System.out.println("Sending to server: " + userMessage); // Debug print
                out.println(userMessage); // Send user input to the server
                out.flush(); // Ensure the message is sent immediately
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
