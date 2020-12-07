class Clg
{
	void lecture(String una)
	{
		System.out.println(una+" ENTERED THE LECTURE ");
		try {Thread.sleep(2000); }
		catch(Exception e) {}
		
		System.out.println(una+ "CAME OUT FROM THE LECTURE ");
	}
	synchronized void viva(String una)
	{
		System.out.println(una+ "ENTERED FOR VIVA ");
		try {Thread.sleep(2000); }
		catch(Exception e) {}
		System.out.println(una+ "VIVA's COMPLETED ");
		
	}
	void exam(String una)
	{
		System.out.println(una+ "ENTERED INTO THE EXAM HALL ");
		try {Thread.sleep(2000); }
		catch(Exception e) {}
		System.out.println(una+ "CAME OUT FROM THE EXAM HALL ");
	}
	synchronized void submission(String una)
	{
		System.out.println(una+ "ENTERED TO GIVE SUBMISSION ");
		try {Thread.sleep(2000); }
		catch(Exception e) {}
		System.out.println(una+ "SUBMISSION COMPLETED ");
	}
}

class Student implements Runnable
{
	Thread th;
	String una;
	Clg cl;
	Student(String una,Clg cl)
	{
		th=new Thread(this);
		this.una=una;
		this.cl=cl;
		th=new Thread(this);
		th.start();
	}
	
	public void run()
	{
		cl.lecture(una);
		cl.exam(una);
		cl.viva(una);
		cl.exam(una);
		cl.submission(una);
	}
}
public class ClgLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Clg c1=new Clg();
		
		Student s1=new Student("Piyu",c1);
	}

}
