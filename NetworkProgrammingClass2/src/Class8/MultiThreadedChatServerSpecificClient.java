import java.io.*;
import java.net.*;
import java.util.*;

public class MultiThreadedChatServerSpecificClient {
    // Map to hold client identifiers and their PrintWriter objects
    private static Map<String, PrintWriter> clientWriters = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        try {
            // Create a server socket on port 54321
            ServerSocket serverSocket = new ServerSocket(54321);
            System.out.println("Server started. Waiting for clients...");

            // Create a thread to read messages from the server console
            new Thread(() -> {
                try {
                    BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
                    String serverMessage;
                    while ((serverMessage = serverInput.readLine()) != null) {
                        // Broadcast message to all clients
                        synchronized (clientWriters) {
                            for (PrintWriter writer : clientWriters.values()) {
                                writer.println("Server: " + serverMessage);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Continuously listen for client connections
            while (true) {
                // Accept a new client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Create a new ClientHandler object for the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                
                // Create a new Thread with the ClientHandler
                Thread thread = new Thread(clientHandler);
                
                // Start the thread
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Define a ClientHandler class that implements Runnable
    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private String clientId;

        // Constructor to initialize the client socket
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input stream to read from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                // Create output stream to write to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read client ID (e.g., username)
                out.println("Enter your ID:");
                clientId = in.readLine();
                System.out.println("Client ID: " + clientId);

                // Add this client's writer to the map of client writers
                synchronized (clientWriters) {
                    clientWriters.put(clientId, out);
                }

                String message;
                // Continuously read messages from the client and respond
                while ((message = in.readLine()) != null) {
                    System.out.println("Client (" + clientId + "): " + message);

                    // Handle targeted message
                    if (message.startsWith("@")) {
                        // Extract target client ID and the actual message
                        int spaceIndex = message.indexOf(' ');
                        if (spaceIndex != -1) {
                            String targetClientId = message.substring(1, spaceIndex);
                            String targetMessage = message.substring(spaceIndex + 1);
                            
                            PrintWriter targetWriter = clientWriters.get(targetClientId);
                            if (targetWriter != null) {
                                targetWriter.println(clientId + ": " + targetMessage);
                            } else {
                                out.println("User " + targetClientId + " not found.");
                            }
                        }
                    } else {
                        // Echo the message back to the client
                        out.println("Server: " + message);
                    }
                }

                // Close the input and output streams and the socket
                in.close();
                out.close();
                clientSocket.close();
                
                // Remove this client's writer from the map of client writers
                synchronized (clientWriters) {
                    clientWriters.remove(clientId);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
