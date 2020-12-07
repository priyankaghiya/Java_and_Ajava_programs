import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.net.Socket;
import java.util.Scanner;


public class MyClient
{
	public static void main(String[] args) 
	{
		try
		{
			Socket server=new Socket("localhost",1234);
			
			DataInputStream dis=new DataInputStream(server.getInputStream());
			DataOutputStream dos=new DataOutputStream(server.getOutputStream());
			Scanner scan=new Scanner(System.in);
			String fna="";
			
			System.out.println(" ENTER FILE NAME : ");
			fna=scan.next();
			
			dos.writeUTF(fna);
			
			String msg=dis.readUTF();
			
			if(msg.equals("FILE EXISTS"))
			{
				System.out.println("\n FILE EXISTS ");
				
				FileWriter fw=new FileWriter("src//"+fna);
				String data=dis.readUTF();
				
				fw.write(data);
				fw.close();
				System.out.println("\n FILE DOWNLOADED SUCCESSFULLY");
			}
			else
			{
				System.out.println("\n FILE DOESN'T EXIST");
			}
			
			server.close();
			dis.close();
			dos.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR MESSSAGE : "+e.getMessage());
		}
		
	}

}
