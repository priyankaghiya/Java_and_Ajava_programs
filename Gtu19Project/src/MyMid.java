import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class MyMid
{
	public static void main(String[] args) 
	{
		String f1;
		String line="";
		Scanner sc=new Scanner(System.in);
		System.out.println("\n ENTER THE FILE NAME : ");
		f1=sc.next();
		int i=0,m=0;;
		File f=new File("src//"+f1);
		
		if(!f.exists())
		{
			System.out.println("FILE DOESNOT EXISTS ");
		}
		else
		{
			try
			{
				FileReader fr=new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				
				while(line!=null)
				{
					line=br.readLine();
					i++;					
				}
				fr.close();
				m=i/2;
				
				i=0;
				line="";
				fr=new FileReader(f);
				BufferedReader br1=new BufferedReader(fr);
				while(line!=null)
				{
					line=br1.readLine();
					i++;
						if(i>=(m-5)&& i<(m+5))
						{
							System.out.println(line);
						}
				}
				fr.close();
			}
			catch(Exception e) {}
		}
	}

}
/