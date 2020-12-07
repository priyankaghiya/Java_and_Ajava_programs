import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class MyReceiver 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(1234);  //here there are two servers so both the port nos should be different
			String msg="";
			byte b[]=new byte[20];
			DatagramPacket pack=null;
			
			pack=new DatagramPacket(b,b.length);
			ds.receive(pack);
			b=pack.getData();
			msg=new String(b);
			int i,c=0;
			
			for(i=0;i<msg.length();i++)
			{
				if(msg.charAt(i)=='a')
				{c++;}
			}
			msg=""+c;
			b=msg.getBytes();
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,4321);
			ds.send(pack);
			
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println("\n RECEIVER ERROR : "+e.getMessage());
		}

	}

}
