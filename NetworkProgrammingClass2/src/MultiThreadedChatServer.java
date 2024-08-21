import java.net.*;
import java.io.*;

public class SimpleClientChat(){

public static void main(String[] args) {
        
    try{
    
    Socket socket = new Socket("localhost",12345);
        System.out.println("Server Connected");
        
        BufferedReader in = neew BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out =  new printWriter(socket.getOutputStream(),true);
        InputReader userinput = inputReaderStream(new InputStreamReader(System.in));
        
        Thread thread = new thread(()->{
        
        String message;
        
        while((message=in.readLine() )!= null){
            System.out.println("message");
        }
        }catch(IOException e )
    }catch(IOException e){e.printStackTrace()}
    }
}