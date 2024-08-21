import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get cookies from header of HTTP request
        Cookie[] cookies = request.getCookies();
        
        // Display these cookies
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                pw.println("<p>Name = " + name + "; Value = " + value + "</p>");
            }
        } else {
            pw.println("<p>No cookies found</p>");
        }
        
        pw.println("</body></html>");
        pw.close();
    }
}
