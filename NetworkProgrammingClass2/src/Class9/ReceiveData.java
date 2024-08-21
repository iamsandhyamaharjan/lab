import java.io.*;
import java.net.*;
public class ReceiveData {
 public static void main(String[] args) throws Exception {
 DatagramSocket dsocket = new DatagramSocket(3000);
 byte[] buf = new byte[1024];
/* Created a byte array buf of length 1024 that will be used to store the received data. */

 DatagramPacket dpacket = new DatagramPacket(buf, 1024);
/* Next, a new DatagramPacket object is created with the buf byte array and a length of 1024. This object 
will be used to receive the incoming datagram. */
 dsocket.receive(dpacket);
 String str = new String(dpacket.getData(), 0, dpacket.getLength());
/* receive method is called on the DatagramSocket object to wait for an incoming datagram. When a 
datagram is received, its data is stored in the buf byte array. * /

* getData method is called on the DatagramPacket object to get the data from the received datagram as a 
byte array. This byte array is then converted to a string using the String constructor that takes a byte array, an 
offset, and a length as arguments. The offset and length are used to specify which portion of the byte array to convert
to a string. */
 System.out.println(str);
 dsocket.close();
 }
}