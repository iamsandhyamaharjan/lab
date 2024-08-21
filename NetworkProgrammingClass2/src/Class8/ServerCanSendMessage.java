import java.io.*; // Importing necessary classes for input and output
import java.net.*; // Importing necessary classes for networking
import java.util.*; // Importing necessary classes for collections

public class ServerCanSendMessage {
    // Synchronized list to hold PrintWriter objects for all connected clients
    private static List<PrintWriter> clientWriters = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try {
            // Create a server socket on port 54321
            ServerSocket serverSocket = new ServerSocket(54321);
            System.out.println("Server started. Waiting for clients...");

            // Create a thread to read messages from the server console
            new Thread(() -> {
                try {
                    // Read input from the server console
                    BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
                    String serverMessage;
                    // Continuously read messages from the console
                    while ((serverMessage = serverInput.readLine()) != null) {
                        // Broadcast the message to all connected clients
                        synchronized (clientWriters) {
                            for (PrintWriter writer : clientWriters) {
                                writer.println("Server: " + serverMessage);
                            }
                        }
                    }
                } catch (IOException e) {
                    // Handle potential IOExceptions
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
            // Handle potential IOExceptions
            e.printStackTrace();
        }
    }

    // Define a ClientHandler class that implements Runnable
    static class ClientHandler implements Runnable {
        private Socket clientSocket;

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
                
                // Add this client's writer to the list of client writers
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }
                
                String message;
                // Continuously read messages from the client and respond
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
                    // Echo the message back to the client
                    out.println("Server: " + message); 
                }

                // Close the input and output streams and the socket
                in.close();
                out.close();
                clientSocket.close();
                
                // Remove this client's writer from the list of client writers
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            } catch (IOException e) {
                // Handle potential IOExceptions
                e.printStackTrace();
            }
        }
    }
}
