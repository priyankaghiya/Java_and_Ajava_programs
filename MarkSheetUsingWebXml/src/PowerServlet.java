
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PowerServlet")
public class PowerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int x=Integer.parseInt(request.getParameter("tx"));
		int n=Integer.parseInt(request.getParameter("tn"));
		
		int p=1,i=1;
		
		while(i<=n)
		{
			p=p*x;
			i++;
		}
		
		ServletContext sc=getServletContext();
		ServletConfig gc=getServletConfig();
		
		String cont=sc.getInitParameter("country");
		String state=gc.getInitParameter("state");
		
			
		PrintWriter out=response.getWriter();
		
		
		out.println("<br> COUNTRY : "+cont);
		out.println("<br>  STATE : "+state);
		
		
		out.println("<br> POWER = "+p);
	}

}
