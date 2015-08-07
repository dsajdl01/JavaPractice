package programUsingHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LondonInformation {
	
	private HashMap<String,Property> hash = new HashMap<String,Property>();

	public LondonInformation(Map<String, Property> p) {
		if(p.isEmpty()) return;
		hash.putAll(p);
	}
	public int[] getLondonInformation(){
		int[] info = {0,0,0,0,0,0};
		Collection<Property> values = hash.values();
    	for (Property value : values) {
    		info[0] += value.getPopulation();
    		info[1] += value.getMale();
    		info[2] += value.getFemale();
    		info[3] += value.getLiningHouse();
    		info[4] += value.getLiningCommunal();
    		info[5] += value.getStudents();
    	}
		return info;
	}
	public Property getBorough(String bor){
		if(hash.containsKey(bor)){
			for(Entry<String, Property> entry : hash.entrySet()){
				if(entry.getKey().equals(bor.trim())){
					return entry.getValue();
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	public double getAreaOfLondon(){
		Double total = 0.0;
		Collection<Property> values = hash.values();
    	for (Property value : values) {
    	   total += value.getArae();
    	}
		return total;
	}
	public String getBiggestBorough(){
		Double greater = 0.0;
		Property pr;
		String borough ="";
		for(Map.Entry<String, Property> e : hash.entrySet()){
			 String key = e.getKey();
			 pr = e.getValue();
			 if(greater < pr.getArae()){
				 greater = pr.getArae();
				 borough = key;
			 }
		}
    	return borough + " "+greater +"km2";
	}
	
	public String getsmallestBorough(){
		Double smaller = 2000.0;
		Property pr;
		String borough ="";
		for(Map.Entry<String, Property> e : hash.entrySet()){
			 String key = e.getKey();
			 pr = e.getValue();
			 if(smaller > pr.getArae()){
				 smaller = pr.getArae();
				 borough = key;
			 }
		}
		return borough + " "+smaller +"km2";
	}
	public void printAllBorougth(){
		System.out.println("\nBorough,  All_population,  Male,   Female,  Live_House, Live_Communal, Students, Area_km ");
		for(Map.Entry<String, Property> e : hash.entrySet()){
			 Property val = e.getValue();
			 System.out.println( e.getKey() +",    " + val.getPopulation() + ",    " + val.getMale() + 
					 ",   " + val.getFemale() + ",    " + val.getLiningHouse() + ",      " + val.getLiningCommunal() +
					 ",      " + val.getStudents() + ",      " + val.getArae());
		}
	}
}
