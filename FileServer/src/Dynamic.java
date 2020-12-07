import java.util.*;

class Dynamic
{
	public static void main(String[] st)
	{
		int n,sum=0,max=0,min=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("ENTER THE ARRAY SIZE : ");
		n=scan.nextInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
		{
			System.out.print("ENTER NUMBER : ");
			a[i]=scan.nextInt();
		}
		for(int i=0;i<a.length;i++)    
		{
			sum=sum+a[i];
		}
		System.out.println("SUM IS : "+sum);
		min=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<min)
			{
				min=a[i];
			}
		}
		System.out.println("MINIMUM NUMBER IS : "+min);
		max=a[0];
		for(int j=0;j<a.length;j++)
		{
			
			if(a[j]>max)
			{
				max=a[j];
			}
		}
		System.out.println("MAXIMUM NUMBER IS : "+max);
		
		
	}
}