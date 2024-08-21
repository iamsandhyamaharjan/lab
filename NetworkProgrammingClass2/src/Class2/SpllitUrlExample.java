package Class2;
import java.net.*;

public class SpllitUrlExample {
    public static void main(String[] args) {
        try {
            // Provide a valid URL string
            String urlString = "https://www.example.com:443/anything/this.page.htmk?param1=value##here";
            URL url = new URL(urlString);

            // Get the protocol
            String protocol = url.getProtocol();
            System.out.println("Protocol: " + protocol);
            
            
            String File = url.getFile();
            System.out.println("File: " + File);
            
                int Port = url.getPort();
            System.out.println("Port: " + Port);
            
                 int DefaultPort = url.getDefaultPort();
            System.out.println("Port: " + DefaultPort);
                String Path = url.getPath();
            System.out.println("Path: " + Path);
            
            
                String Ref = url.getRef();
            System.out.println("Ref: " + Ref);
            
                String Query = url.getQuery();
            System.out.println("Queue: " + Query);
            
                String UserInfo = url.getUserInfo();
            System.out.println("UserInfo: " + UserInfo);
            
            
          
                String Authority = url.getAuthority();
            System.out.println("Authority: " + Authority);
            
            
            
                String Protocol = url.getProtocol();
            System.out.println("Protocol: " + Protocol);
            
        } catch (MalformedURLException e) {
            // Handle the malformed URL exception
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }
}
