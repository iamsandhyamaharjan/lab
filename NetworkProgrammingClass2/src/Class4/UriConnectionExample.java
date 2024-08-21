
package Class4;

import java.net.MalformedURLException;
import java.net.URI;


public class UriConnectionExample {
   public static void main(String[] args) {
        try {
            // Provide a valid URL string
            String urlString = "https://www.example.com:443";
            URI uri = new URI(urlString);

            // Get the Authority
            
            
         
        
            
            
          
            
            
            
                String Authority = uri.getAuthority();
            System.out.println("Authority: " + Authority);
            
               String Fragment = uri.getFragment();
            System.out.println("Fragment: " + Fragment);
            
              String Host = uri.getHost();
            System.out.println("Host: " + Host);
            
              String Path = uri.getPath();
            System.out.println("Path: " + Path);
            
            
              int Port = uri.getPort();
            System.out.println("Port: " + Port);
            
            
              String Query = uri.getQuery();
            System.out.println("Query: " + Query);
            
            
              String Userinfo = uri.getUserInfo();
            System.out.println("Userinfo: " + Userinfo);
            
            
            
            
        } catch (Exception e) {
            // Handle the malformed URL exception
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }
    
}
