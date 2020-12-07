import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;


public class ImageJdbc 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/imagebase","root","");
			PreparedStatement pst=con.prepareStatement("insert into mytab values(?)");
			File file=new File("src//newimages//image.jpg"); //file ne locate karva mathe
			
			FileInputStream fis=new FileInputStream(file);//file ne read kari lese
			
			pst.setBinaryStream(1, fis);
			pst.execute();
			
			pst.close();
			fis.close();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from mytab where iname='image'");
			String name="";
			while(rs.next())
			{
				name=rs.getString(1);
				InputStream is=rs.getBinaryStream(2);
				OutputStream os=new FileOutputStream(new File("src/newimages/"+name+".jpg"));
				int c=0;
				while((c=is.read())>-1)
				{
					os.write(c);
				}
				os.close();
				is.close();
				
			}
			//jlab.setIcon(new ImageIcon("src/newimages"+name+".jpg"));
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR : "+e.getMessage());
		}

	}

}
