package patterncodingclub;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ENTER THE VALUE OF N :");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=n;i>=1;i--)
		{
			for(int j=i;j>=1;j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		for(int i=2;i<=n;i++)
		{
			for(int k=1;k<=i;k++)
			{
				System.out.print(k);
			}
			System.out.println();
		}
	}

}
