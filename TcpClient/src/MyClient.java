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
			
			int a[]=new int[10];
			int i,s,max,min;
			
			for(i=0;i<a.length;i++)
			{
				System.out.println("ENTER NO : ");
				a[i]=scan.nextInt();
				dos.writeInt(a[i]);
			}
			
			s=dis.readInt();
			max=dis.readInt();
			min=dis.readInt();
			
			
			System.out.println("SUM "+s);
			System.out.println("MAX "+max);
			System.out.println("MIN "+min);

			
//			System.out.println("ENTER THE VALUE OF 10 ELEMENTS : ");
//			
//			for(int i=0;i<10;i++)
//			{
//				System.out.println("VALUE "+i);
//				a[i]=scan.nextInt();
//				dos.writeInt(a[i]);
//			}
//			
			dis.close();
			dos.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("SERVER ERROR : ");
		}


	}

}
