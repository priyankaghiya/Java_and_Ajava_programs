class Database
{
	void read(String una)
	{
		System.out.println(una + "  STARTED READING DATA FROM THE DATABASE ");
		try {Thread.sleep(3000);}
		catch (Exception e) {}
		System.out.println(una + "  HAS COMPLETED READING ");
	}
	
	void edit(String una)
	{
		System.out.println(una +"  STARTED EDITING DATA FROM THE DATABASE ");
		try {Thread.sleep(3000);}
		catch (Exception e) {}
		System.out.println(una +"  HAS COMPLETED EDITING ");
	}
}

class User implements Runnable
{
	Thread th;
	Database d;
	String una;
	
	User(String una, Database d)
	{
		th=new Thread(this);
		this.una=una;
		this.d=d;
		th.start();
	}
	
	public void run()
	{
		d.read(una);
		
		if(una.equals("SUPER USER"))
		{
		d.edit(una);
		}
		else
		{
			synchronized(d)
			{
				d.edit(una);
			}
		}
	}
}


public class MySyn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Database d1=new Database();
		
		User u1=new User("RUPAL",d1);
		User u2=new User("AMIT",d1);
		User u3=new User("SACHIN",d1);
		
		User u4=new User("SUPER USER",d1);
	}

}
