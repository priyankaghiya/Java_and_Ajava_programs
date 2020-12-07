import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          try
          {
              int enr = Integer.parseInt(request.getParameter("enroll"));
              String name = request.getParameter("name");  
              String dept1 = request.getParameter("dept");
              int semester = Integer.parseInt(request.getParameter("sem"));
              String email = request.getParameter("email");
              double contact = Double.parseDouble(request.getParameter("contact"));

Class.forName("com.mysql.jdbc.Driver");  
               //create connection object
               Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/student","root","");  
               // create the prepared statement object
PreparedStatement ps=con.prepareStatement("insert into std1 values(?,?,?,?,?,?)");  
ps.setInt(1,enr); 
ps.setString(2,name);  
ps.setString(3,dept1);  
ps.setInt(4,semester); 
ps.setString(5,email);  
ps.setDouble(6, contact);
ps.executeUpdate(); 
out.print("You are successfully registered..."); 
          }
          catch (Exception ex)
          {
ex.printStackTrace();
}
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet MyServlet</title>");            
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
out.println("</body>");
out.println("</html>");
out.close();  
        }
    }
}

