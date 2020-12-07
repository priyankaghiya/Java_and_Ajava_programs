import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MyServer {

	public static void main(String[] args) 
	{
		try
		{
			ServerSocket server=new ServerSocket(1234);
			System.out.println("\n SERVER IS WAITING ......");
			Socket client=server.accept();
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			Scanner scan=new Scanner(System.in);
			String msg="";
			int m;
			
			while(!msg.equals("QUIT"))
			{
				System.out.print("\n ENTER MSG FOR CLIENT :");
			    msg=scan.nextLine();
			    m=10;
			    dos.writeUTF(msg);  //Unicode transform format
			    dos.writeInt(m);
			    msg=dis.readUTF();
			    System.out.println("\n MSG FROM CLIENT : "+msg);
			}
			
			
			
			
			dis.close();
			dos.close();
			client.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("SERVER ERROR :"+e.getMessage());
		}

	}

}
