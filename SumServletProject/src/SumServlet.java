

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String sno[]=request.getParameterValues("t1");
		
		int s=0;
		
		for(int i=0;i<sno.length;i++)
		{
			s=s+Integer.parseInt(sno[i]);
		}
		
		PrintWriter pw=response.getWriter();
		pw.write("<br> SUM : "+s);
	}

}
