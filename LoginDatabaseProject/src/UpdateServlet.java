

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			PrintWriter out=response.getWriter();
			
			Statement st=con.createStatement();
			out.println("<html>");
			out.println("<body>");
			out.println("<form name=f1 action='UpdateServlet'>");
			out.println("<h3> ENTER THE USERNAME OF WHICH PASSWORD HAS TO BE UPDATED </td></h3>");
			out.println("<input type='text' name=t1>");
			out.println("<h3> ENTER THE NEW PASSWORD </h3>");
			out.println("<input type='password' name=t2> <br><br>");
			out.println("<input type='submit' name='sub' value='SUBMIT'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
			String t1=request.getParameter("t1");
			String t2=request.getParameter("t2");
			String sub=request.getParameter("sub");
				
			if(sub.equals("SUBMIT"))
			{
			st.executeUpdate("update login set pass='"+t2+"' where user='"+t1+"'");
			out.println("<h1>PASSWORD UPDATED SUCCESSFULLY......</h1>");
			}
		st.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR MESSAGE : "+e.getMessage());
		}
	}

}
