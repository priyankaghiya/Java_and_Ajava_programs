import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class MyRev
{
	public static void main(String[] st) 
	{
		String f1="",f2="";
		f1=st[0];
		//f2=st[1];
		String data="";
		File f=new File("src//"+f1);
		if(!f.exists())
		{
			System.out.println("\n\n FILE DOESNOT EXISTS ");
		}
		else
		{
	
			try
			{
				FileInputStream fis=new FileInputStream(f);
				int n=0;
				
				while(n!=-1)
				{
					n=fis.read();
					if(n!=-1)
					{
						data=data+(char)n;
					}
				}
				fis.close();
				
				StringBuffer sb=new StringBuffer(data);
				
				data=sb.reverse().toString();
				
				//File f4=new File("src//"+f2);
				FileWriter fw=new FileWriter("src//"+st[1]);
				
				fw.write(data);
				fw.close();
			}
			catch(Exception e) {}
		}

	}

}
