import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mytab")
public class Std 
{
	@Id
	int sid;
	
	@Column(name="sna")
	String sna;
	
	@Column(name="sag")
	int age;
	
	Std()
	{}
	
	Std(int sid,String sna,int age)
	{
		this.sid=sid;
		this.sna=sna;
		this.age=age;
	}
	
	Std(int sid)
	{
		this.sid=sid;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void show()
	{
		System.out.println(" "+sid+" , "+sna+" , "+age);
	}
	
}
