import java.util.*;

class DySor
{
	public static void main(String[] s)
	{
		int temp,n,i;
		Scanner p= new Scanner(System.in);
		System.out.println("ENTER THE ARRAY");
		n=p.nextInt();
		int a[]=new int[n];
		System.out.println("\n ENTER ELEMENT :");
		for(i=0;i<a.length;i++)
		{
			a[i]=p.nextInt();
		}
		for(i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
			if(a[i]>a[j])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			}
			System.out.print(" "+a[i]);
		}
		
	}

}
