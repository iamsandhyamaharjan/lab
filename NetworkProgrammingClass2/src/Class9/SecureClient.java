import javax.net.ssl.*; // Import SSL classes for secure communication
import java.io.*; // Import I/O classes for handling input and output streams
import java.security.KeyStore; // Import KeyStore class for handling the keystore
public class SecureClient {
public static void main(String[] args) {
// Set up SSL properties for the trust store (could be the same keystore as the server for simplicity)
System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Dell\\Documents\\NetBeansProjects\\NetworkProgrammingClass2\\src\\Class9\\keystore.jks"); // Set the truststore file path
System.setProperty("javax.net.ssl.trustStorePassword", "sandhya1"); // Set the truststore password
try {
// Create SSL context and initialize it with trust managers
SSLContext sslContext = SSLContext.getInstance("TLS"); // Create an SSLContext for TLS
TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()); 
// Get the default TrustManagerFactory
KeyStore trustStore = KeyStore.getInstance("JKS"); // Create a KeyStore instance for the JKS type
// Load the truststore from file
try (FileInputStream trustStoreStream = new FileInputStream("C:\\Users\\Dell\\Documents\\NetBeansProjects\\NetworkProgrammingClass2\\src\\Class9\\keystore.jks")) {
trustStore.load(trustStoreStream, "sandhya1".toCharArray()); 
// Load the truststore with the password
}
tmf.init(trustStore); // Initialize the TrustManagerFactory with the truststore
sslContext.init(null, tmf.getTrustManagers(), null);
// Initialize the SSLContext with the trust managers
// Create SSL socket factory from the SSL context
SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory(); 
// Create an SSLSocketFactory from the SSLContext
// Create SSL socket and connect to server
try (SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 8888))
{ // Create an SSLSocket and connect to the server on port 8888
System.out.println("Connected to server"); // Print a message indicating the client has connected
// Create input and output streams for secure communication
try (BufferedReader reader = new BufferedReader(new
InputStreamReader(sslSocket.getInputStream())); // Create a Buf eredReader to read input from the server
PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true); 
// Create a PrintWriter to send output to the server
BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
// Create a Buf eredReader to read input from the console
// Send a message to the server
writer.println("Hello from client!"); // Send a message to the server
// Read response from the server
String response = reader.readLine(); // Read a response from the server
System.out.println("Server: " + response); // Print the server's response
}
}
} catch (Exception e) {
e.printStackTrace(); // Print stack trace if an exception occurs
}
}
}
