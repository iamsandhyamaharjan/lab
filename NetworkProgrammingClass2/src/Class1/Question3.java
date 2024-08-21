

package Class1;
import java.net.*;

public class Question3 {
    public static void main(String[] args) throws UnknownHostException {
         InetAddress url2= InetAddress.getByName("https://sstest2.tinker.com.np/");
        InetAddress url1= InetAddress.getByName("https://ssapp-ss127.tinker.com.np/");
        
         
        
       
        if(url1.equals(url2)){
            System.out.println("Equals");

    }
      
}}
