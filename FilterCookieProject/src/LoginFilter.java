
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LoginServlet")
public class LoginFilter implements Filter 
{
    public LoginFilter() 
    {

    }
	public void destroy() 
	{
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String us=request.getParameter("tus");
		String pa=request.getParameter("tpa");
		
		if(us.equals("COMPACT") && pa.equals("JAVA"))
		{
			chain.doFilter(request, response);
			
		}
		else
		{
			PrintWriter pw=response.getWriter();
			pw.write("UNAUTHORIZED USER--  TRY AGAIN");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{

	}

}
