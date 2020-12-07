

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String st[]=new String[10];
		//int a[]=new int[10];
		for(int i=1;i<=st.length;i++)
		{
			st[i]=request.getParameter("b[i]");
			
		}
		
		
		
		
		
	}

}
