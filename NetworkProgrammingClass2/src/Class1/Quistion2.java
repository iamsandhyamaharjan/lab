//Wap to find the hostname fo the given IP address('127.0.0.1')
package Class1;

import java.net.*;

public class Quistion2 {

    public static void main(String[] args) throws UnknownHostException {
        
        //string declaration
        String IpAdress = "127.0.0.1";
        
        //name get
        InetAddress inetAddress = InetAddress.getByName(IpAdress);
        System.out.println(inetAddress);
        
        //hostname
        String hostname = inetAddress.getCanonicalHostName();
        System.out.println(hostname);

    }

}
