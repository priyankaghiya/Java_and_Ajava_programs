package practical4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class jdbc {

	public static void main(String[] args) 
	{
		try
        {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/college","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from student2");
           
        
	   while(rs.next())
	   		{
	   			int a=rs.getInt("sid");
	   			String b=rs.getString("sna");
	   			String c=rs.getString("dept");
               int d=rs.getInt("sem");
               String e=rs.getString("email");
               int f=rs.getInt("contact");
	   		   System.out.println(""+a+" , "+b+" , "+c+" , "+d+" , "+e+" , "+f);
	   		}
           		rs.close();
			st.close();
			con.close();
        }

        
        catch(Exception e)
        {
            System.out.println("ERROR MESSAGE : "+e.getMessage());
        }
    }
	

}
