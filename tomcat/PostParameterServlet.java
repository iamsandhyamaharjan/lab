import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
// import jakarta.servlet;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
public class PostParameterServlet extends GenericServlet{
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
        PrintWriter pw = response.getWriter();
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements()){
            String pName =(String) e.nextElement();
            pw.print(pName+"=");
            String pValue = request.getParameter(pName);
            pw.println(pValue);
        }
        pw.close();
    }
} 