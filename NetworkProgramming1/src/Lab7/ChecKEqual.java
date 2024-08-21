import java.net.*;

public class CheckEqual {
    public static void main(String[] args) {
        // Case a: www.example.com and example.com
        String urlStr1a = "www.example.com";
        String urlStr2a = "example.com";
        
        boolean equalA = compareHostnames(urlStr1a, urlStr2a);
        System.out.println("a) Equals: " + equalA);
        
        // Case b: www.google.com and www.google.com
        String urlStr1b = "www.google.com";
        String urlStr2b = "www.google.com";
        
        boolean equalB = compareHostnames(urlStr1b, urlStr2b);
        System.out.println("b) Equals: " + equalB);
    }
    
    public static boolean compareHostnames(String urlString1, String urlString2) {
        try {
            URL url1 = new URL("http://" + urlString1); // Create URL object for urlString1
            URL url2 = new URL("http://" + urlString2); // Create URL object for urlString2
            
            String host1 = url1.getHost(); // Get hostname from URL object
            String host2 = url2.getHost(); // Get hostname from URL object
            
            return host1.equals(host2); // Compare hostnames ignoring case
            
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
            return false;
        }
    }
}
