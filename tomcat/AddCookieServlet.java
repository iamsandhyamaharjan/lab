import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameter from HTTP request
        String data = request.getParameter("data");

        // Create cookie
        Cookie cookie = new Cookie("MyCookie", data);

        // Add cookie to HTTP response
        response.addCookie(cookie);

        // Write output to browser
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        pw.println("<b>MyCookie has been set to: " + data + "</b>");
        pw.println("</body></html>");
        pw.close();
    }
}
