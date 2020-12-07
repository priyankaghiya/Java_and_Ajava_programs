import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Employee 
{
	public int eid;
	public String ena;
	public int eag;
	
	public Employee()
	{}

	
	
	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
	}



	public String getEna() {
		return ena;
	}



	public void setEna(String ena) {
		this.ena = ena;
	}



	public int getEag() {
		return eag;
	}



	public void setEag(int eag) {
		this.eag = eag;
	}



	public String whatNext()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			Statement st=con.createStatement();
			
			st.executeUpdate("insert into mytab values("+eid+",'"+ena+"',"+eag+")");
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n NEXT ERROR : "+e.getMessage());
		}
		
		return "result";
	}
}
