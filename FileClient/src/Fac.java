public class Fac
{
	public static void main(String[] r)
	{
		int a=Integer.parseInt(r[0]);
		int fac=1,i;
		for(i=a;i>0;i--)
		{
			fac=fac*i;
		}
		System.out.println("\n FACTORIAL IS : "+fac);
	}
}
