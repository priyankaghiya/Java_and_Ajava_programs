

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReverseServlet")
public class ReverseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String st=request.getParameter("t1");
		
		StringBuffer sb=new StringBuffer(st);
		
		st=sb.reverse().toString();
		
		PrintWriter out=response.getWriter();
		
		out.println("<br> <h1> REVERSE = "+st+"</h1>");
	}

}
