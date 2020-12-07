

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
    System.out.println("170410107019");
    System.out.println("Database Metadata");
    try{
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
    	DatabaseMetaData DM = con.getMetaData();
    	System.out.println("Driver Name : "+DM.getDriverName());
    	System.out.println("Driver version : "+DM.getDriverVersion());
    	System.out.println("Driver UserName : "+DM.getUserName());
    	System.out.println("Driver Product Name : "+DM.getDatabaseProductName());
    	System.out.println("Driver Product version : "+DM.getDatabaseProductVersion());
    	System.out.println("Parameter MetaData");
    	PreparedStatement ps = con.prepareStatement("insert into student2 values(?,?)");
    	ParameterMetaData PM = ps.getParameterMetaData();
    	System.out.println("Number of parameters : "+PM.getParameterCount());
    	System.out.println("Mode for parameter 1 : "+PM.getParameterMode(1));	
    	System.out.println("Mode for parameter 2 : "+PM.getParameterMode(2));
    	Statement st =  con.createStatement();
    	ResultSet rs = st.executeQuery("select * from student2");
    	ResultSetMetaData RM = rs.getMetaData();
    	System.out.println("No of columns : "+RM.getColumnCount());
    	System.out.println("Column 1 size : "+RM.getColumnDisplaySize(1));
    	System.out.println("Column 2 size : "+RM.getColumnDisplaySize(2));
    	System.out.println("Column 2 name : "+RM.getColumnLabel(1));
    	System.out.println("Column 2 name : "+RM.getColumnLabel(2));
    	System.out.println("schema Name : "+RM.getSchemaName(1));
    	System.out.println("table Name : "+RM.getTableName(1));
    }
catch(Exception e){
	System.out.println("ERROR MESSAGE : "+e.getMessage());
}
    }

}

