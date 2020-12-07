import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class StdHiber 
{
	public static void main(String[] args) 
	{
		try
		{
			Configuration con=new Configuration();
			con.configure();
			
			SessionFactory sf=con.buildSessionFactory();
			
			Session ss=sf.openSession();
			ss.beginTransaction();
			
			//Inserting 
			//Std s1=new Std(12,"Hello",30);
			//ss.save(s1);
			
			//Deleting
			//Std s1=new Std(12);
			//ss.delete(s1);
			
			List list=ss.createQuery("from Std").list(); //the query wriiten is HQL query without database name or table name
			
			for(int i=0;i<list.size();i++)
			{
				Std s=(Std)list.get(i);
				s.show();
			}
			
			ss.getTransaction().commit();
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println("HIBER ERROR : "+e.getMessage());
		}

	}

}
