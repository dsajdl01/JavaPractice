package database;
/**
 * class Member
 * 
 * @author David Sajdl 
 * @version 7
 */
public class Member implements Staff {
	private int memId;
	private String memName;
	private int memAge;

	public Member(int id, String name, int age){
		this.memId = id;
		this.memName = name;
		this.memAge = age;
	}
	
	@Override
	public int staffNo() {
		return this.memId;
	}

	@Override
	public String staffName() {
		return this.memName;
	}

	@Override
	public int staffAge() {
		return this.memAge;
	}

	@Override
	public String toString(){
		return this.staffNo() + " " + this.staffName() +" "+ this.staffAge();
	}
}
