import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MyDatabase 
{
	public static void main(String[] args) 
	{
	   	try
	   	{
	   		Class.forName("com.mysql.jdbc.Driver");  //class Class is used to register and forName is the method name
	   		System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		Statement st=con.createStatement();
	   		
	       //st.executeUpdate("insert into mytab values(9,'xyz',90)");
	   		int a=10;
	   		String b="SVIT";
	   		int c=100;
	   		int d=10,e=9;
	   		//st.executeUpdate("insert into mytab values("+a+",'"+b+"',"+c+")");
	   		
	   		//st.executeUpdate("delete from mytab where sid = "+a);
	   		//executeUpdate() is use to update the database 
	   		//executeQuery() is use to ask the query
	   		
	   		//st.executeUpdate("update mytab set sid="+d+" where sid="+e);
	   		/*ResultSet rs=st.executeQuery("select * from mytab");
	   		
	   		
	   		while(rs.next())
	   		{
	   			int id=rs.getInt("sid");
	   			String na=rs.getString(2);
	   			int ag=rs.getInt(3);
	   			System.out.println("\n "+id+" , "+na+" , "+ag);
	   		}
	   		
	   		rs.close();*/
	   		st.close();
	   		con.close();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println("\n DATABASE ERROR :"+e.getMessage());
	   	}

	}

}
