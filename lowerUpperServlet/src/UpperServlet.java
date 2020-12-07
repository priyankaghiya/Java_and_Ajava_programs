

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpperServlet")
public class UpperServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String st=request.getParameter("b1");
		
		String s=st.toUpperCase();
		
		PrintWriter out=response.getWriter();
		
		out.println("<h1>  UPPER CASE : "+s+"</h1>");
	}

}
