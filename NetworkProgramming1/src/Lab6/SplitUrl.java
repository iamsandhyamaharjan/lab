import java.net.*;

public class SplitUrl {

    public static void parseURL(String urlString) {
        try {
            URL url = new URL(urlString);

            // Protocol
            String protocol = url.getProtocol();
            System.out.println("Protocol: " + protocol);

            // Host (Domain name or IP)
            String host = url.getHost();
            System.out.println("Host: " + host);

            // Port
            int port = url.getPort();
            System.out.println("Port: " + (port == -1 ? "Default" : port));

            // Path
            String path = url.getPath();
            System.out.println("Path: " + path);

            // User Info (for FTP URLs)
            String userInfo = url.getUserInfo();
            if (userInfo != null) {
                System.out.println("User Info: " + userInfo);
            }

            // Query parameters
            String query = url.getQuery();
            if (query != null) {
                System.out.println("Query: " + query);
            }

            // Fragment (anchor)
            String fragment = url.getRef();
            if (fragment != null) {
                System.out.println("Fragment: " + fragment);
            }

            System.out.println(); // Blank line for readability
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + urlString);
        }
    }

    public static void main(String[] args) {
        String url1 = "http://www.example.com:80/index.html";
        String url2 = "ftp://mp3:mp3@138.247.121.61:21000/c%3a/";

        parseURL(url1);
        parseURL(url2);
    }
}
