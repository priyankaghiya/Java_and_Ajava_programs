import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class NoteFrame extends Frame implements ActionListener
{
	MenuBar mb;
	Menu fi,ed,fo,vi,he;
	MenuItem ne,op,sa,sas,ex,d1,d2;
	TextArea ta;
	
	NoteFrame(String s)
	{
		super(s);
		ta=new TextArea();
		add(ta);
		mb=new MenuBar();
		
		fi=new Menu("File");
		ed=new Menu("Edit");
		vi=new Menu("View");
		fo=new Menu("Format");
		he=new Menu("Help");
		
		ne=new MenuItem("New");
		op=new MenuItem("Open");
		sa=new MenuItem("Save");
		sas=new MenuItem("Save As");
		
		MenuShortcut mx=new MenuShortcut(KeyEvent.VK_X);
		
		ex=new MenuItem("Exit",mx);
		d1=new MenuItem("-");
		d2=new MenuItem("-");
		
		fi.add(ne);  fi.add(op); fi.add(d1);  fi.add(sa);   fi.add(sas); fi.add(d2);  fi.add(ex);
		
		mb.add(fi);  mb.add(ed);   mb.add(vi);   mb.add(fo);   mb.add(he);
		
		
		setMenuBar(mb);
		
		ne.addActionListener(this);
		op.addActionListener(this);
		sa.addActionListener(this);
		sas.addActionListener(this);
		ex.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}


	public void actionPerformed(ActionEvent ae) 
	{
		String s=ae.getActionCommand();
		
		if(s.equals("Exit"))
		{
			System.exit(0);
		}
		
	}
}


public class MyNotepad 
{
	public static void main(String[] args) 
	{
		NoteFrame mf=new NoteFrame("PRIYANKA");
		mf.setVisible(true);  // for frame it is by deafult it is false so we have to make it true
		mf.setSize(1000,600);
	}

}
