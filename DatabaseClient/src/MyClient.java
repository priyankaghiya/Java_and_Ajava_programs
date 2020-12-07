import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			
			System.out.println("ENTER ID : ");
			int id=scan.nextInt();
			
			dos.writeInt(id);
			
			String record="";
			
			
			record=dis.readUTF();
			
			System.out.println("\n RECORD IS : "+record);
				
			dis.close();
			dos.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR MESSSAGE : "+e.getMessage());
		}
		
	}

}
