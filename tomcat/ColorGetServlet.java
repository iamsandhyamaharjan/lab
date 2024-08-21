import java.io.IOException;
import java.io.PrintWriter;

// import jakarta.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class ColorGetServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String color = request.getParameter("color");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<b>The selected color:");
        pw.println(color);
        pw.close();
    }
}