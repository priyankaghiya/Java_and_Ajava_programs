class Track
{
	synchronized void tunnel(String rna,long sl)
	{
		System.out.println("\n "+rna+" HAS ENTERED INTO THE TUNNEL ");
		try { Thread.sleep(sl); }
		catch(Exception e) {}
		
		System.out.println("\n "+rna+" HAS CROSSED TUNNEL ");
	}
	
	synchronized void sulado()
	{
		System.out.println("\n\n RABBIT IS SLEEPING........");
		try{ wait();}
		catch(Exception e){}
		
		System.out.println("\n\n RABBIT WOKE UP AND RUN ");
	}
	
	synchronized void jagado()
	{
		notify();
	}
}

class Racer implements Runnable
{
	Thread th;
	String rna;
	Track tr;
	long sl;
	int miles;
	
	Racer(String rna,Track tr,long sl)
	{
		th=new Thread(this);
		this.rna=rna;
		this.tr=tr;
		this.sl=sl;
		miles=0;
		th.start();
	}
	
	public void run()
	{
		while(true)
		{
			try{ Thread.sleep(sl); }
			catch(Exception e){}
			
			miles++;
			
			if(miles==10)
			{
				System.out.println("\n\n\n "+rna+" HAS WON THE RACE ");
				System.exit(0);
			}
			else if(miles==3)
			{
				tr.tunnel(rna, sl);
			}
			else if(miles==5 && rna.equals("RABBIT"))
			{
				tr.sulado();
			}
			else if(miles==7 && rna.equals("TORTOISE"))
			{
				tr.jagado();
			}
		System.out.println("\n "+rna+" HAS FINISHED === "+miles+" MILES ");
		}
	}
}


public class RabbitTortoiseRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Track tr=new Track();
		
		
		Racer r1=new Racer("RABBIT",tr,3000);
		Racer r2=new Racer("TORTOISE",tr,4000);
	}

}
