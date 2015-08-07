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
}
