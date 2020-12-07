

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyServ")
public class MyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet MyServ</title>");            
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet MyServ at " + request.getContextPath() + "</h1>");
out.println("HTTP Header Information<br><br>");
            Enumeration e1 = request.getHeaderNames();
            while(e1.hasMoreElements())
            {
            String HName = (String)e1.nextElement();
            String HValue = request.getHeader(HName);
out.println("Header Name : "+HName+"<br>");
out.println("Header Value : "+HValue+"<br>");
            }
out.println("</body>");
out.println("</html>");
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}


