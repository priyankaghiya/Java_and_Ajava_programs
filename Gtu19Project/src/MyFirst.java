import java.util.Scanner;  //press ctrl+shift+o


public class MyFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		
		Scanner scan=new Scanner(System.in);
		System.out.print("ENTER NO1 : ");
		a=scan.nextInt();
		
		System.out.print("ENTER NO2: ");
		b=scan.nextInt();
		
		c=a/b;
		
		System.out.println("\n\n DIV : "+c);
		
	}

}
