import java.util.*;

class empl
{
	int id;
	String na,dept; 
	double hra,da,pf,sal,tsal,nsal;
        Scanner sc=new Scanner(System.in);
	empl(int id,String na,String dept)
	{
		this.id=id;
		this.na=na;
		this.dept=dept;
	}
	void input()
	{
		System.out.println("ENTER YOUR SALARY  : ");
		sal=sc.nextInt();
		hra=(sal*10)/100;
		da=sal/100;
		pf=sal/100;
		tsal=sal+hra+da;
		nsal=tsal-pf;
	}
	void show()
	{
		System.out.println("ID : "+id);
		System.out.println("NAME : "+na);
		System.out.println("DEPT : "+dept);
		System.out.println("TOTAL SALARY : "+tsal);
		System.out.println("NET SALARY : "+nsal);
	}
}
public class Employee
{
	public static void main(String[] s)
	{
		empl e=new empl(Integer.parseInt(s[0]),s[1],s[2]);
		e.input();
		e.show();
	}
}
		