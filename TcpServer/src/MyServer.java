import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MyServer 
{
	public static void main(String[] args) 
	{
		try
		{
			ServerSocket ss=new ServerSocket(1234);
			System.out.println(" SERVER WAITING...");
			Socket client=ss.accept();
			
			System.out.println("\n CLIENT CONNECTED......");
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			Scanner scan=new Scanner(System.in);
//			int n=0,m=0,b=0,sum=0;
			int a[]=new int[10];
			int max;
			int min,i,s=0;
			
			for(i=0;i<10;i++)
			{
				a[i]=dis.readInt();
				s=s+a[i];
			}
			dos.writeInt(s);
			
			max=a[0];
			min=a[0];
			
			for(i=0;i<10;i++)
			{
				if(a[i]>max)
				{
					max=a[i];
				}
				if(a[i]<min)
				{
					min=a[i];
				}
			}
			
			dos.writeInt(max);
			dos.writeInt(min);
			
//			while(m!=10)
//			{
//				a[m]=dis.readInt();
//				m++;
//			}
//			max=a[0];
//			min=a[0];
//			while(n!=10)
//			{
//						
//				sum=sum+a[n];
//				if(a[n]>max)
//				{
//					max=a[n];
//				}
//				else if(a[n]<min)
//				{
//					min=a[n];
//				}
//				
//				n++;
//			}
//		
//		
//		System.out.println("SUM "+sum);
//		System.out.println("MAX "+max);
//		System.out.println("MIN "+min);
		
		dis.close();
		dos.close();

		}
		catch(Exception e)
		{
			System.out.println("SERVER ERROR : ");
		}
	}

}
