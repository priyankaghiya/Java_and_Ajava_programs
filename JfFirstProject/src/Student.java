
public class Student 
{
	int sid;
	String sna;
	int sag;
	
	public String nextPage()//here method name can be anything but here it is given nextPage
	{
		return "output";  
	}
	
	//here in the index file there is submit which here is called as the control button that would contain the
	//action in that we would make the object of the this class ie here (Student) and would call this nextPage
	//method thus now the JSF would call this method and whatever it returns it would call that jsp file in the Web COntent
	
	
	public Student()
	{ }

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSna() {
		return sna;
	}

	public void setSna(String sna) {
		this.sna = sna;
	}

	public int getSag() {
		return sag;
	}

	public void setSag(int sag) {
		this.sag = sag;
	}
	
	
 
}
