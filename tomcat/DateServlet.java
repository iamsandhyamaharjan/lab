import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the HttpSession object.
        HttpSession session = request.getSession(true);

        // Get writer.
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Display date/time of last access.
        Date date = (Date) session.getAttribute("date");
        if (date != null) {
            pw.print("Last access: " + date + "<br>");
        } else {
            pw.print("No previous access time recorded.<br>");
        }

        // Display current date/time.
        date = new Date();
        session.setAttribute("date", date);
        pw.println("Current date: " + date);

        pw.close();
    }
}
