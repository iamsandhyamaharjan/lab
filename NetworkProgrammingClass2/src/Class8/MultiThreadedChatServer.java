import java.io.*;
import java.net.*;

public class MultiThreadedChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(54321);
            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;

            System.out.println("Server: Ready to send messages.");

            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                out.println("Server: " + message); // Echo message with prefix
                out.flush(); // Explicitly flush the PrintWriter
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
