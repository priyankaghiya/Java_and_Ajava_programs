package p3c;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;
public class CallStat 
{
	public static void main(String args[]) 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/college","root","");
		CallableStatement cst = con.prepareCall("{call svit1(?,?)}");

		Scanner scan=new Scanner(System.in);
		System.out.print("\n ENTER ID : ");
   		int a=scan.nextInt();
   		
   		cst.setInt(1,a);
   		cst.registerOutParameter(2, Types.VARCHAR); 		
   		cst.execute();  
   			   		
   		System.out.println("\n NAME = "+cst.getString(2));
   		cst.close();
		con.close();
	
		
		}
		catch(Exception e)
		{
			System.out.println("ERROR MESSAGE : "+e.getMessage());
		}
   }
}
