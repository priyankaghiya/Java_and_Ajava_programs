import java.util.*;
class InvalidGenderException extends Exception
{
	String gen;
	InvalidGenderException(String g)
	{
		gen=g;
	}
	public String toString()
	{
		return "GENDER ENTERED IS INCORRECT ";
	}
}

public class Gender
{
	public static void main(String [] st)
	{
		String gen;
		Scanner sc=new Scanner(System.in);
		System.out.print("YOUR GENDER : ");
		gen=sc.next();		
		try
		{
			if(gen.equalsIgnoreCase("male") || gen.equalsIgnoreCase("female"))
			{
				System.out.println("GENDER ENTERED IS CORRECT");
			}
			else
			{
				throw new  InvalidGenderException(gen);
			}
		}
			catch(InvalidGenderException ige)
			{
				System.out.println(ige);
			}
		
	}

}
				
	
	