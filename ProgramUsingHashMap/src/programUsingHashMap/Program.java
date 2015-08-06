package programUsingHashMap;

import java.util.HashMap;

public class Program {

	public static void main(String[] args) throws Exception {
		HashMap<String, Double> hm = new HashMap<String, Double>();
		HashMap<String, Property> hash = new HashMap<String, Property>();
		// TODO Auto-generated method stub
		ReadFile rf = new ReadFile();
		try{
			rf.readFile("LondonEthincGroup.txt");
			//System.out.println(hm);
			
			
			//System.out.println("London area is " + li.areaOfLondon() +"km2");
			//li.printLondonBorough();;
			hash.putAll(rf.filereader("londonAtributes.txt"));
			LondonInformation li = new LondonInformation(hash);
			System.out.println("London area is " + li.getAreaOfLondon());
		} catch (Exception e){
			System.out.println("Error occur:" + e.toString());
		}
		
	}

}
