package programUsingHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LondonInformation {
	
	private HashMap<String,Property> hash = new HashMap<String,Property>();

	public LondonInformation(Map<String, Property> p) {
		if(p.isEmpty()) return;
		hash.putAll(p);
	}
	public double getAreaOfLondon(){
		Double total = 0.0;
		Collection<Property> values = hash.values();
    	for (Property value : values) {
    	   total += value.getArae();
    	}
		return total;
	}
	/**
	public LondonInformation( Map<String, Double> hash) throws TheException{
		if(hash.isEmpty()) { throw new TheException("The hash does not contain any value");}
		this.hash.putAll(hash);
	}
	
	public Double areaOfLondon(){
		Double total = 0.0;
		Collection<Double> values = hash.values();
    	for (Double value : values) {
    	   total += value;
    	}
		return total;
	}
	
	public void printLondonBorough(){
		Set<String> keys = hash.keySet();
		for(String key : keys){
			 System.out.println(key);
		}
	}
	//London area is 1594.7255km2
	*/
}
