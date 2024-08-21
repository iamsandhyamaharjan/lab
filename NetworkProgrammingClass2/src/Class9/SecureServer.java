import javax.net.ssl.*; // Import SSL classes for secure communication
import java.io.*; // Import I/O classes for handling input and output streams
import java.security.KeyStore; // Import KeyStore class for handling the keystore
public class SecureServer {
public static void main(String[] args) {
// Set up SSL properties
System.setProperty("javax.net.ssl.keyStore", "C:\\Users\\Dell\\Documents\\NetBeansProjects\\NetworkProgrammingClass2\\src\\Class9\\keystore.jks"); // Set the keystore file path
System.setProperty("javax.net.ssl.keyStorePassword", "sandhya1"); // Set the keystore password
try {
// Create SSL context and initialize it with key managers
SSLContext sslContext = SSLContext.getInstance("TLS"); // Create an SSLContext for TLS
KeyManagerFactory kmf =KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
// Get thedefault KeyManagerFactory
KeyStore keyStore = KeyStore.getInstance("JKS"); // Create a KeyStore instance for the JKS type
// Load the keystore from file
try (FileInputStream keyStoreStream = new FileInputStream("C:\\Users\\Dell\\Documents\\NetBeansProjects\\NetworkProgrammingClass2\\src\\Class9\\keystore.jks")) {
keyStore.load(keyStoreStream, "sandhya1".toCharArray()); // Load the keystore with thepassword
}
kmf.init(keyStore, "password".toCharArray());
// Initialize the KeyManagerFactory with then keystore
sslContext.init(kmf.getKeyManagers(), null, null); 
// Initialize the SSLContext with the key managers
// Create SSL server socket factory from the SSL context
SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory(); 
//Create an SSLServerSocketFactory from the SSLContext
// Create SSL server socket
try (SSLServerSocket sslServerSocket = (SSLServerSocket)
sslServerSocketFactory.createServerSocket(8888)) { // Create an SSLServerSocket on port 8888
System.out.println("Server started. Waiting for client connection..."); 
// Print a message indicating the server has started
// Accept client connection
try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) { 
// Wait for and accept a client connection
System.out.println("Client connected."); // Print a message indicating a client has connected
// Create input and output streams for secure communication
try (BufferedReader reader = new BufferedReader(new
InputStreamReader(sslSocket.getInputStream())); // Create a Buf eredReader to read input from the client
PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true)) { 
// Create a PrintWriter to send output to the client
// Read data from client
String message = reader.readLine(); // Read a message from the client
System.out.println("Received message from client: " + message); 
// Print the received message
// Send response to client
writer.println("Hello from server!"); // Send a response message to the client
}
}
}
} catch (Exception e) {
e.printStackTrace();// Send a response message to the client
}
}
}
