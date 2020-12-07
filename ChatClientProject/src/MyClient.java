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
			Socket server=new Socket("127.0.0.1",1234);//("192.168.43.180",1234);//127.0.0.1 is IP address 
			
			
			DataInputStream dis=new DataInputStream(server.getInputStream());
			DataOutputStream dos=new DataOutputStream(server.getOutputStream());
			Scanner scan=new Scanner(System.in);
			
			System.out.println("ENTER FIRST NUMBER : ");
			int a=scan.nextInt();
			dos.writeInt(a);
			System.out.println("ENTER SECOND NUMBER : ");
			int b=scan.nextInt();
			dos.writeInt(b);
			
			int c=dis.readInt();
			
			System.out.println("SUM OF TWO NUMBERS IS "+c);
			
			/*String msg="";
			
		//	msg=dis.readUTF();
			//System.out.println("FROM SERVER : "+msg);
			
			while(!msg.equals("QUIT"))
			{
				msg=dis.readUTF();
				System.out.println("\n FROM SERVER : "+msg);
				
				
				System.out.print("\n MSG FOR SERVER : ");
				msg=scan.nextLine();
				dos.writeUTF(msg);
			}*/
			
			
			dis.close();
			dos.close();
			server.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}

	}

}
