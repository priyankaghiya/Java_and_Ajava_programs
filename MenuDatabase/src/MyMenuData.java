import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;


class DataOperation
{
	Scanner scan=new Scanner(System.in);
	void show()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		Statement st=con.createStatement();
	   		
	   		ResultSet rs=st.executeQuery("select * from mytab");
	   		
	   		ResultSetMetaData rsm=rs.getMetaData();
	   		
	   		System.out.println("\n TABLE : "+rsm.getTableName(1));
	   		
	   		System.out.println("COLUMN : "+rsm.getColumnCount());
	   		
	   		for(int i=1;i<=rsm.getColumnCount();i++)
	   		{
	   			System.out.println(" "+rsm.getColumnName(i)+" : "+rsm.getColumnTypeName(i));
	   		}
	   		
	   		while(rs.next())
	   		{
	   			int a=rs.getInt("sid");
	   			String b=rs.getString("sna");
	   			int c=rs.getInt("sag");
	   			System.out.println(""+a+" , "+b+" , "+c);
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
	void insert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		Statement st=con.createStatement();
	   		
	   		System.out.println("ENTER SID");
	   		int id=scan.nextInt();
	   		System.out.println("ENTER SNAME");
	   		String name=scan.next();
	   		System.out.println("ENTER SAGE");
	   		int age=scan.nextInt();
	   		st.executeUpdate("insert into mytab values("+id+",'"+name+"',"+age+")");
			
	   		//rs.close();
			st.close();
			con.close();
		

		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}
	}
	void delete()
	{
		try
		{
		int aa;
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("\n DRIVER REGISTERED SUCESSFULLY....");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
		System.out.println("\n DATABASE FOUND SUCCESSFULLY..... ");
		
		Statement st=con.createStatement();
		
		System.out.println("ENTER THE ID OF THE ROW TO BE DELETED");
		aa=scan.nextInt();
		st.executeUpdate("delete from mytab where sid="+aa);
		
		//rs.close();
		st.close();
		con.close();
	
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}
		
	}
	void update()
	{
		try
		{
			int bb;int cc;
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("\n DRIVER REGISTERED SUCCESSFULLY...");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
		System.out.println("\n DATABASE FOUND SUCCESSFULLY...");
		
		Statement st=con.createStatement();
		
		System.out.println("ENTER THE VALUE OF THE AGE OF ROW TO BE UPDATED");
		cc=scan.nextInt();
		System.out.println("ENTER THE NEW ID TO BE UPDATED");
		bb=scan.nextInt();
		st.executeUpdate("update mytab set sid="+bb+" where sag="+cc);
	
		st.close();
		con.close();
	
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}
	}
	
	void updatable()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   		
	   		ResultSet rs=st.executeQuery("select * from emp");
	   		
	   		rs.absolute(2); //jumps to record having 2 id
	   		rs.updateString("ena","PIYU");
	   		rs.updateInt("ead",45);
	   		rs.updateRow();
	   		

	   		/*rs.absolute(5); //jumps to record having 5 id
	   		rs.updateString("ena","SACHIN");
	   		rs.updateRow();
	   		

	   		rs.absolute(1); //jumps to record having 1 id
	   		rs.updateString("ena","AMIT");
	   		rs.updateRow();
	   		rs.first();
	   		rs.previous();*/
	   		while(rs.next())
	   		{
	   			int a=rs.getInt("eid");
	   			String b=rs.getString("ena");
	   			int c=rs.getInt("ead");
	   			System.out.println(" "+a+" , "+b+" , "+c);
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
	
	void prepareInsert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		//Statement st=con.createStatement();
	   		PreparedStatement pst=con.prepareStatement("insert into mytab values(?,?,?)");
	   		
	   		int id=1;
	   		
	   		while(id!=0)
	   		{
	   			System.out.print("\n ENTER ID -NAME - AGE : ");
	   			id=scan.nextInt();
	   			String name=scan.next();
	   			int age=scan.nextInt();
	   		//System.out.println("ENTER SID");
	   		
	   		//System.out.println("ENTER SNAME");
	   		
	   		//System.out.println("ENTER SAGE");
	   			if(id!=0)
	   			{
	   				pst.setInt(1,id);
	   				pst.setString(2,name);
	   				pst.setInt(3,age);
	   				pst.execute();
	   				//st.executeUpdate("insert into mytab values("+id+",'"+name+"',"+age+")");
	   			}
	   		}
	   		//rs.close();
			//st.close();
			con.close();
			pst.close();
		

		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}

	}
	
	void prepareDelete()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		//Statement st=con.createStatement();
	   		PreparedStatement pst=con.prepareStatement("delete from mytab where sid=(?)");
	   		int id=1;
	   			while(id!=0)
	   			{
	   			System.out.println("ENTER ID : ");
	   			id=scan.nextInt();
	   			
	   				if(id!=0)
	   				{
	   					pst.setInt(1,id);
	   					pst.execute();
	   				}
	   			
	   			}
	   		
		con.close();
		pst.close();
		}

		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}
	  
	}
	
	void prepareUpdate()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		//Statement st=con.createStatement();
	   		PreparedStatement pst=con.prepareStatement("update mytab set sid=? where sag=?");
	   	
	   		int age=1;
	   		int a;
	   		while(age!=0)
	   		{
	   			System.out.println("ENTER THE AGE  ");
	   			age=scan.nextInt();
	   			System.out.println("ENTER THE NEW SID TO BE UPDATED ");
	   			a=scan.nextInt();
	   			
	   			   			
	   			if(age!=0)
	   			{
	   				pst.setInt(1,a);
	   				pst.setInt(2, age);
	   				pst.execute();
	   			}
	   		}
	   		con.close();
	   		pst.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}
	}
	
	void callableInsert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   		
	   		//Statement st=con.createStatement();
	   		
	   		CallableStatement cst=con.prepareCall(" { call insertQ(?,?,?) } ");
	   		
	   		System.out.println("ENTER SID");
	   		int id=scan.nextInt();
	   		System.out.println("ENTER SNAME");
	   		String name=scan.next();
	   		System.out.println("ENTER SAGE");
	   		int age=scan.nextInt();
	   		//st.executeUpdate("insert into mytab values("+id+",'"+name+"',"+age+")");
			
	   		//rs.close();
	   		
	   		cst.setInt(1, id);
	   		cst.setString(2, name);
	   		cst.setInt(3, age);
	   		cst.execute();
			cst.close();
			con.close();
		

		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}

	}
	
	void callableOut()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   	
	   		CallableStatement cst=con.prepareCall(" { call with_out(?,?) } ");
	   		
	   		System.out.print("\n ENTER ID : ");
	   		int a=scan.nextInt();
	   		
	   		cst.setInt(1,a);
	   		cst.registerOutParameter(2, Types.VARCHAR);
	   		
	   		cst.execute();  //it will execute the query
	   			   		
	   		System.out.println("\n NAME = "+cst.getString(2));
	   		
	   		cst.close();
			con.close();
		

		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}

	}
	
	void callableOutHomeWork()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   	
	   		CallableStatement cst=con.prepareCall(" { call with_outHW(?,?) } ");
	   		
	   		System.out.print("\n ENTER NAME : ");
	   		String a=scan.next();
	   		
	   		cst.setString(1,a);
	   		cst.registerOutParameter(2, Types.VARBINARY);
	   		
	   		cst.execute();  //it will execute the query
	   			   		
	   		System.out.println("\n AGE = "+cst.getInt(2));
	   		
	   		cst.close();
			con.close();
		

		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}

	}
	
	void myBatch()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY.... ");
	   		
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
	   		System.out.println("\n DATABASE FOUND SUCCESSFULLY....");
	   	
	   		Statement st=con.createStatement();
	   		st.addBatch("insert into mytab values(16,'GHIYA',160)");
	   		st.addBatch("insert into mytab values(17,'Juniors',170)");
	   		st.addBatch("delete from mytab where sid=3");
	   		
	   		st.executeBatch();
			con.close();
		

		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}


	}
	
	void upload()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			PreparedStatement pst=con.prepareStatement("insert into imgtab values(?,?)");
			
			pst.setInt(1, 1);
			
			File file=new File("src//images//Capture.JPG"); //file ne locate karva mathe
			
			FileInputStream fis=new FileInputStream(file);//file ne read kari lese
			
			pst.setBinaryStream(2, fis);
			pst.execute();
			
			pst.close();
					
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n FILE ERROR : "+e.getMessage());
		}
		
	}
}



public class MyMenuData 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int ch=0;
		DataOperation d1=new DataOperation();
		
		while(ch!=14)
		{
			System.out.println("\n DATABASE MENU : ");   
			System.out.println("1. SHOW ");
			System.out.println("2. INSERT ");
			System.out.println("3. DELETE ");
			System.out.println("4. UPDATE ");
			System.out.println("5. UPDATABLE" );
			System.out.println("6. PREPARED INSERT ");
			System.out.println("7. PREPARED DELETE ");
			System.out.println("8. PREPARED UPDATE ");
			System.out.println("9. CALLABLE INSERT ");
			System.out.println("10. CALLABLE OUT ");
			System.out.println("11. CALLABLE OUT HOME-WORK");
			System.out.println("12. BATCH METHOD");
			System.out.println("13. UPLOAD FILE ");
			System.out.println("14. EXIT ");
			System.out.println("\n SELECT YOUR OPTION : ");
			ch=scan.nextInt();
			
			switch(ch)
			{
			case 1: d1.show();   break;
			
			case 2: d1.insert();  break;
			
			case 3: d1.delete(); break;
			
			case 4: d1.update(); break;
			
			case 5: d1.updatable(); break;
			
			case 6: d1.prepareInsert(); break;
			
			case 7: d1.prepareDelete(); break;
			
			case 8: d1.prepareUpdate(); break;
			
			case 9: d1.callableInsert();  break;
			
			case 10: d1.callableOut();   break;
			
			case 11: d1.callableOutHomeWork(); break;
			
			case 12: d1.myBatch();  break;
			
			case 13:d1.upload();  break;
			}
		}
	}

}
