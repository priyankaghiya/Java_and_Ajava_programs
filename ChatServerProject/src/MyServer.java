import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MyServer 
{
	public static void main(String[] args) 
	{
		try
		{
			ServerSocket ser=new ServerSocket(1234);
			
			System.out.println(" SERVER WAITING...");
			Socket client=ser.accept();//accept method will wait the server and when client will send the request all the client data will be in the socket 
			
			System.out.println("\n CLIENT CONNECTED......");
			
			InetAddress ip=client.getInetAddress();
			
			System.out.println("\n ADDRESS : "+ip.getHostAddress());
			System.out.println("\n NAME : "+ip.getHostName());
			
			System.out.println("\n\n ADDRESS : "+ip.getLocalHost());
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			Scanner scan=new Scanner(System.in);

			System.out.println("HW");
			
			int a=dis.readInt();
			int b=dis.readInt();
			
			int c=a+b;
			
			dos.writeInt(c);
			/*
			String msg="";
			
//			dos.writeUTF("WEL-COME CLIENT ");
			
			while(!msg.equals("QUIT"))
			{
				System.out.print(" MSG FOR CLIENT : ");
				msg=scan.nextLine();
				dos.writeUTF(msg);
				
				msg=dis.readUTF();
				System.out.println("\n MSG FROM CLIENT : "+msg);
			}*/
			
			dis.close();
			dos.close();
			client.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SERVER ERROR : "+e.getMessage());
		}

	}

}
