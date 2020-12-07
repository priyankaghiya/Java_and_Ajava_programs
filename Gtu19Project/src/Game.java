import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class Board
{
	BufferedReader br;
	Random ra;
	
	Board()
	{
		ra=new Random();
	}
	
	synchronized int throwDice(String pna)
	{
		try{
			Thread.sleep(3000);
		}
		catch(Exception e) {}
		
		br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n PRESS ENTER TO THROW DICE FOR :"+pna+" ==>> ");
		try{br.read(); } catch(Exception e) {}
		
		int dice=ra.nextInt(6);
		dice++;
		
		return dice;
	}
	
}


class Player implements Runnable
{
	Thread th;
	String pna;
	Board b;
	int points,dice;
	Player(String pna,Board b)
	{
		th=new Thread(this);
		this.pna=pna;
		this.b=b;
		points=0;
		dice=0;
		th.start();
	}
	public void run()
	{
		while(true)
		{
			dice=b.throwDice(pna);
			System.out.println("\n PREVIOUS POINTS = "+points+" DICE NO = "+dice+"FOR PLAYER :"+pna );
			
			points+=dice;
			
				if(points==50)
				{
					System.out.println("\n\n\n  "+pna+" HAS WON THE GAME ");
					System.exit(0);
				}
				else if(points>50)
				{
					points-=dice;
				}
				else if(points==7 || points==19 || points==25 || points==39)
				{
					System.out.println("\n "+pna+" HAS GOT THE LADDER");
					points+=5;
				}
				else if(points==9 || points==20 || points==26 || points==36 || points==40 || points==49)
				{
					System.out.println("\n  "+pna+"HAS BEEN BITTEN BY SNAKE ");
					points-=8;
				}
				System.out.println("\n\n UPDATED SCORE == "+points+"FOR "+pna);
		}
	}
}
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b=new Board();
		
		Player p1=new Player(args[0],b);
		Player p2=new Player(args[1],b);
	}
}
