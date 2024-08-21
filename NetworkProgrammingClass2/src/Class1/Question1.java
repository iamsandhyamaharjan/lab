//Wap to find the IP address of the local machine by using getHostAddress() method
package Class1;
import java.net.*; 
/**
 *
 * @author Dell
 */
public class Question1 {
    public static void main(String[] args)throws UnknownHostException{
        InetAddress myaddr = InetAddress.getLocalHost();
        String dottedQuad = myaddr.getHostAddress();
        System.out.println("My address is"+dottedQuad);
    }
}
