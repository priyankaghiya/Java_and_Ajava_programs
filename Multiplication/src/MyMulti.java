
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyMulti")
public class MyMulti extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int no=Integer.parseInt(request.getParameter("b1"));
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> WELCOME </title>");
		out.println("</head>");
		out.println("<table style='border:solid;' cellspacing=5 cellpadding=5>");
		for(int i=1;i<=10;i++)
		{
			out.println("<tr>");
			out.println("<td>"+no+" * "+i+" = "+no*i+"</td>");
			out.println("<tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
