import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class MyClient {

	public static void main(String[] args) 
	{
		try
		{
									//"127.0.0.1" indicates to JVM that it is on the same pc/laptop
			Socket ser=new Socket("localhost",1234);
			
			DataInputStream dis=new DataInputStream(ser.getInputStream());
			DataOutputStream dos=new DataOutputStream(ser.getOutputStream());
			Scanner scan=new Scanner(System.in);
			String msg="";
			int m=0;
			
			while(!msg.equals("QUIT"))
			{
			   msg=dis.readUTF();
			   System.out.println("\n MSG FROM SERVER :"+msg);
			   m=dis.readInt();
			   System.out.println("\n integer value:"+m);
			   System.out.println("\n ENTER MSG FOR SERVER :");
			   msg=scan.nextLine();
			   dos.writeUTF(msg);
				
			}
			
			
			
			
			dis.close();
			dos.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("CLIENT ERROR :"+e.getMessage());
		}


	}

}
