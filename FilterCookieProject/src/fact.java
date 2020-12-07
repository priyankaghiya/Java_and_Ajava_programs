
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fact")
public class fact extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int no=Integer.parseInt(request.getParameter("tno"));
		int f=1;
		while(no>=1)
		{
			f=f*no;
			no--;
		}
		
		PrintWriter pw=response.getWriter();
		pw.write("<br> factorial = "+f);
		
		request.getRequestDispatcher("/final.jsp").include(request, response);
	}

}
