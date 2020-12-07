import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


public class FileCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f1;
		int capi=0,lowe=0,digi=0,sp=0,li=0,spe=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("\n ENTER FILE1 : ");
		f1=sc.next();
		
		File f=new File("src//"+f1);
		
		if(!f.exists())
		{
			System.out.println("\n FILE DOESN T EXIST ");
		}
		else 
		{
			try
			{
				FileInputStream fis=new FileInputStream(f);
				
				int n=0;
				
				while(n!= -1)
				{
					n=fis.read();
				
					if(n>=65 && n<=90)   //uppercase
					{
						capi++;
					}
					else if(n>=97 && n<=122)
					{
						lowe++;
					}
					else if(n>=48 && n<=57)
					{
						digi++;
					}
					else if(n==32)
					{
						sp++;
					}
					else if(n==13)   //to count line
					{
						li++;
					}
					else
						spe++;
				}
				fis.close();
			}
			catch(Exception e)
			{}
		}
		System.out.println("CAPITAL ALPHABETS :"+capi);		
		System.out.println("LOWER ALPHABETS :"+lowe);
		System.out.println("WORDS :"+(sp+1));
		System.out.println("DIGITS :"+digi);
		System.out.println("SPECIALS CHARACTERS :"+spe);
		System.out.println("TOTAL LINES :"+li);
	}

}
