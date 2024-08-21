package Class5;

import java.io.*;
import java.net.*;
import java.util.*;

public class LastModified {
    public static void main(String[] args) throws UnknownHostException, IOException {
        URL u = new URL("http://scst.edu.np/wp-content/uploads/2022/07/s-1-e1716269987777.jpg");
        HttpURLConnection http = (HttpURLConnection) u.openConnection();
        http.setRequestMethod("HEAD");
        System.out.println(u + " was modified at " + new Date(http.getLastModified()));
    }
}
