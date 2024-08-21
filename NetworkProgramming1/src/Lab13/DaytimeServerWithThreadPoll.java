package Lab13;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class DaytimeServerWithThreadPoll { 
public static void main(String[] args) {
        final int PORT = 1913;
        final int THREAD_POOL_SIZE = 10;

        // Create a thread pool with a fixed number of threads
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Daytime server is running on port " + PORT + "...");

            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Submit the task to the thread pool
                threadPool.submit(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Shut down the thread pool gracefully when done
            threadPool.shutdown();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Get the output stream to send the daytime information
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send the current date and time to the client
            out.println(new Date().toString());

            // Close the client connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
