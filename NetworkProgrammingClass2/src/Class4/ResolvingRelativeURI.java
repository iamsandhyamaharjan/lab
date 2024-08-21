
package Class4;
import java.net.*;

public class ResolvingRelativeURI {
    public static void main(String[] args) throws Exception {
    
     
        URI abs = new URI("http://www.exmple.com");
        URI rel = new URI("images/logo.png");
        
        URI resolved =abs.resolve(rel);
        System.out.println("Resolved  "+ resolved);
        
        
    }
}
