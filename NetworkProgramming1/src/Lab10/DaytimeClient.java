import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

public class DaytimeClient {

    public static void main(String[] args) {
        String hostname = "time.nist.gov"; // Example public Daytime server
        int port = 13; // Daytime service port

        try (Socket socket = new Socket(hostname, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received from server: " + line);
            }

        } catch (IOException e) {
            System.err.println("Error connecting to daytime server: " + e.getMessage());
        }
    }
}
