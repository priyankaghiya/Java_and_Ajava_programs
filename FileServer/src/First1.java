public class First1
{
	public static void main(String []st)
	{
		System.out.println("TOTAL ARGS :"+st.length);
		for(int i=0;i<st.length;i++)
		{
			System.out.println(st[i]+"="+st[i].length());
		}
	}
}