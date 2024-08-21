/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class5;

import java.net.
,*;
import java.net.URLConnection;

/**
 *
 * @author Dell
 */
public class MIMEType {

    public static void main(String[] args) {
        String contentType1 = URLConnection.guessContentTypeFromName("C:\\Users\\Dell\\Downloads\\gi7ojrzvkfqykr16\\blue-ball.gif");
        System.out.println("First Content type:" + contentType1);
        String contentType2 = URLConnection.guessContentTypeFromName("example.mp4");
        System.out.println("Second Content type:" + contentType2);
        String contentType3 = URLConnection.guessContentTypeFromName("example.txt");
        System.out.println("Third Content type:" + contentType3);
         String contentType4 = URLConnection.guessContentTypeFromName("example.png");
        System.out.println("Fourth Content type:" + contentType4);
         String contentType5 = URLConnection.guessContentTypeFromName("example.jp");
        System.out.println("Fifth Content type:" + contentType5);
    }

}
