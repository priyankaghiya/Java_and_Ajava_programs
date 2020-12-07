import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Updatable
{
	public static void main(String[] args)  
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/college","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   		
	   		ResultSet rs=st.executeQuery("select * from student3");
	   		
	   		System.out.println("BEFORE UPDATATION ");
	   	 while(rs.next())
	   		{
	   			int a=rs.getInt("sid");
	   			String b=rs.getString("sna");
	   			String c=rs.getString("dept");
            int d=rs.getInt("sem");
            String e=rs.getString("email");
            Long f=rs.getLong("contact");
	   		   System.out.println(""+a+" , "+b+" , "+c+" , "+d+" , "+e+" , "+f);
	   		}
        			   		
	   		rs.moveToInsertRow();
	   		rs.updateInt("sid", 4);
	   		rs.updateString("sna", "Amit");
	   		rs.updateString("dept", "Mech");
	   		rs.updateInt("sem", 7);
	   		rs.updateString("email", "pqr@gmail.com");
	   		rs.updateString("contact", "6789543334");
	   		rs.insertRow();
	   		
	   		rs.absolute(3); 
	   		rs.updateString("sna","Rupal");
	   		rs.updateInt("sem",7);
	   		rs.updateRow();
	   		
	   		rs.absolute(2);
	   		rs.deleteRow();
	   		
	   		System.out.println("AFTER UPDATATION ");
		   	 while(rs.next())
		   		{
		   			int a=rs.getInt("sid");
		   			String b=rs.getString("sna");
		   			String c=rs.getString("dept");
	            int d=rs.getInt("sem");
	            String e=rs.getString("email");
	            Long f=rs.getLong("contact");
		   		   System.out.println(""+a+" , "+b+" , "+c+" , "+d+" , "+e+" , "+f);
		   		}
	   		
	   		rs.close();
	   		st.close();
	   		con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}

	}
}
