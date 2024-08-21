import jakarta.servlet.*;  // Importing necessary servlet classes
import java.io.*;       // Importing necessary IO classes

/**
 * A simple servlet that extends GenericServlet
 * to respond with "Hello" in an HTML format.
 */
public class HelloServlet extends GenericServlet {
  
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<b>Hello</b>"); // Corrected to include closing HTML tag
        pw.close();
    }
}
