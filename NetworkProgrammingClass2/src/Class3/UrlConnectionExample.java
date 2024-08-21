package Class3;

import java.net.*;
import java.io.*;

public class UrlConnectionExample {
    public static void main(String[] args) {
        URL url;
        URLConnection connection = null;

        try {
            url = new URL("https://www.example.com");
            connection = url.openConnection();

            try (InputStream stream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                String line;
                   int lineCount = 0;
                while ((line = reader.readLine()) != null && lineCount<8)//printing only eight lines
                {
                    System.out.println(line);
                     lineCount++;
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("The URL is malformed: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
