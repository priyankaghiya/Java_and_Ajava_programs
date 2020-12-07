import java.applet.Applet;
import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class ShiftingOfButton extends Applet implements MouseListener 
{
	Label lab;
	Button by,bn;
	Font f;
	Random ra;
	int c,r;
	
		public void init()
		{
			setLayout(null);
			
			f=new Font("Arial",Font.BOLD,30);
			setFont(f);
			
			ra=new Random();
			
			lab=new Label("IS VIKAS SIR INTELLIGENT ??? ");
			by=new Button("YES");
			bn=new Button("NO");
			
			bn.addMouseListener(this);
			
			lab.setBounds(50,50,600,70);
			by.setBounds(200,200,100,40);
			bn.setBounds(350,200,100,40);
			
			add(lab);  add(by);   add(bn);
		}

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent me)
		{
			//bn.setLabel("YES");
			//bn.setBackground(Color.cyan);
			//bn.setVisible(false);
			//bn.setEnabled(false);
			
			c=ra.nextInt(1000);
			r=ra.nextInt(500);
			bn.setLocation(c,r);
			
		}

		public void mouseExited(MouseEvent arg0) {
			//bn.setLabel("NO");
			//bn.setBackground(Color.pink);
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
