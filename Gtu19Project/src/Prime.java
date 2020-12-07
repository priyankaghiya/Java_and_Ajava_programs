class MyPrime implements Runnable
{
	Thread th;
	int i,n,m,k,l;
	MyPrime(int n,int k,int m)
	{
		th=new Thread(this);
		//this.i=i;
		this.n=n;
		this.k=k;
		this.m=m;
		th.start();
	}
	
	public void run()
	{
		for(int j=k;j<=m;j++)
		{
			for(l=k;l<=n/2;l++)
			{
				if(n%j!=0)    
				{     
					System.out.println(m);
				}
			
				else 
					continue;
			}
		}
	}
}





public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(args[0]);
		int m;
		int u;
		int k;
		for(int i=1;i<=n/50;i++)
		{
			m=50*i;
			if(i==1)
				u=0;
			else 
				u=1;
			k=1+u*50;
			//System.out.println("m "+m + " k "+k);
			MyPrime mp=new MyPrime(n,k,m);
			try {mp.th.join();}
			catch(Exception e){}
		}
	}

}
