
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String keep=request.getParameter("keep");
		
		HttpSession hs=request.getSession();  // to create session
		//HttpSession hs=request.getSession(false); // to retrieve existing session
		
		hs.setAttribute("username", request.getParameter("tus")); //here username is key it can be anything
		
		if(keep!=null)
		{
			//Cookie c1=new Cookie("directme","allow"); //here directme is the key and allow is the value of the cookie
			Cookie c1=new Cookie("college","svit");
			response.addCookie(c1);// directme will be stored on the client web browser
		}
		
		request.getRequestDispatcher("/fact.jsp").forward(request, response);
	}

}
