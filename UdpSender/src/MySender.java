import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//receiver no progam pehla run thase
public class MySender 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket sender=new DatagramSocket(1234);
			String msg="";
			byte b[]=new byte[1024];
			DatagramPacket pack=null;
			
			Scanner scan=new Scanner(System.in);
			
			System.out.println("ENTER STRING : ");
			msg=scan.nextLine();
			b=msg.getBytes();
			
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,4321);
			sender.send(pack);
			
			pack=new DatagramPacket(b,b.length);
			sender.receive(pack);
			b=pack.getData();
			msg=new String(b);
			System.out.println("\n CONVERTED  = "+msg);
					
			sender.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SENDER ERROR : "+e.getMessage());
		}

	}

}
