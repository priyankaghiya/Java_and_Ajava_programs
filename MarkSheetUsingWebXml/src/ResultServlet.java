
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int m1=Integer.parseInt(request.getParameter("t1"));
		int m2=Integer.parseInt(request.getParameter("t2"));
		int m3=Integer.parseInt(request.getParameter("t3"));
		
		int total=m1+m2+m3;
		float per=(float)total/3;
		
		ServletContext sc=getServletContext();
		ServletConfig gc=getServletConfig();
		
		String cont=sc.getInitParameter("country");
		String state=gc.getInitParameter("state");
		
			
		PrintWriter out=response.getWriter();
					
		out.println("<br> COUNTRY : "+cont);
		out.println("<br>  STATE : "+state);
		
		out.println("<br> TOTAL = "+total);
		out.println("<br> PER = "+per);
		
		request.getRequestDispatcher("/power.jsp").include(request,response);
		
	}

}
