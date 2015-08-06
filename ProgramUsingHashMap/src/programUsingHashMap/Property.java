package programUsingHashMap;


public class Property {
	 private int ALL_POPULATION, MALE, FEMALE, LIVE_HOUSE, LIVE_COMMUNAL, STUDENTS;
	 private double AREA;
	//private property[] container_statuses;
	
	public Property(int population, int male, int female, int house, int communal, int student, double area){
		this.ALL_POPULATION = population;
		this.MALE = male;
		this.FEMALE = female;
		this.LIVE_HOUSE = house;
		this.LIVE_COMMUNAL = communal;
		this.STUDENTS = student;
		this.AREA = area;
	}
	public int getPopulation(){
		return this.ALL_POPULATION;
	}
	public int getMale(){
		return this.MALE;
	}
	public int getFemale(){
		return this.FEMALE;
	}
	public int getLiningHouse(){
		return this.LIVE_HOUSE;
	}
	public int getLiningCommunal(){
		return this.LIVE_COMMUNAL;
	}
	public int getStudents(){
		return this.STUDENTS;
	}
	public double getArae(){
		return this.AREA;
	}
}
