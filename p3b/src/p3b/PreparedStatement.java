package p3b;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
class PrepareStatement   
{
    Scanner scan= null;	
	PrepareStatement()
		{
		scan= new Scanner(System.in);
        }
	void insert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
			PreparedStatement pst=con.prepareStatement("insert into student2 values(?,?,?,?,?,?)");
			int id=1,sem=1;
			String na,dept,email;
			Long contact;
			System.out.print("ENTER ENROLLMENT NO:");
			id= scan.nextInt();
			scan.nextLine();
			System.out.print("ENTER NAME:");
			na=scan.nextLine();
			scan.nextLine();
			System.out.print("ENTER DEPARTMENT:");
			dept=scan.nextLine();
			System.out.print("ENTER SEMESTER:");
			sem=scan.nextInt();
			scan.nextLine();
			System.out.print("ENTER EMAIL ID:");
			email=scan.next();
			System.out.print("ENTER CONTACT NO:");
			contact=scan.nextLong();
			pst.setInt(1,id);
			pst.setString(2,na);
			pst.setString(3,dept);
			pst.setInt(4, sem);
			pst.setString(5, email);
			pst.setLong(6, contact);
			pst.execute();
			System.out.println("ENTRY INSERTED SUCCESSFULLY");
			pst.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.print("INSERT ERROR:"+e.getMessage());
		}
	}
	void delete()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
			PreparedStatement pst=con.prepareStatement("delete from student2 where sid=(?)");
			int id;
			System.out.print("ENTER ID TO DELETE :");
			id=scan.nextInt();
			
			pst.setInt(1, id);
			pst.execute();
			System.out.println("ENTRY DELETED SUCCESSFULLY/n");
			pst.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.print("DELETE ERROR:"+e.getMessage());
		}
	}
	void update()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
			PreparedStatement pst=con.prepareStatement("update student2 set sna=? where sid=?");		
			int id=1;
			String na;
			System.out.print("ENTER ID WHICH YOU NEED TO CHANGE : ");
			id=scan.nextInt();
			pst.setInt(2,id);
			scan.nextLine();
			System.out.print("ENTER NAME TO BE UPDATED :");
			na=scan.nextLine();
			scan.nextLine();
			pst.setString(1,na);
			pst.execute();
			System.out.println("ENTRY UPDATED SUCCESSFULLY/n");
			pst.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("UPDATE ERROR:"+e.getMessage());
		}
	}
   void display() {
	   try
	   {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student2");
			while(rs.next())
			{
				int a=rs.getInt(1);
				String b=rs.getString(2);
				String c=rs.getString(3);
				int d=rs.getInt(4);
				String e=rs.getString(5);
				long f=rs.getLong(6);
				System.out.println(" "+a+"\t "+b+"\t "+c+"\t "+d+"\t "+e+"\t "+f+ "\n");
			}
			rs.close();
			st.close();
			con.close();
            }
		
		catch(Exception e)
		{
			System.out.println("ERROR: "+e.getMessage());
		}
        }
}
class Jdbc
{
	public static void main(String[] args) 
	{
		try
		{
			//System.out.println("DRIVER REGISTERED SUCCESSFULLY...");
			int ch=0;
			Scanner sc= new Scanner(System.in);
			PrepareStatement p1=new PrepareStatement();
			while(ch!=5)
			{
				System.out.println("\nMENU......\n");
				System.out.println("1.INSERT");
				System.out.println("2.DELETE");
				System.out.println("3.UPDATE");
				System.out.println("4.DISPLAY");
				System.out.print("5.EXIT");
				System.out.print("\n ENTER YOUR CHOICE : ");
				ch=sc.nextInt();
				switch(ch)
				{
					case 1: p1.insert();
							break;
					case 2: p1.delete();
							break;
					case 3: p1.update();
							break;
                   case 4: p1.display();
                            break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR: "+e.getMessage());
		}
}
	}

