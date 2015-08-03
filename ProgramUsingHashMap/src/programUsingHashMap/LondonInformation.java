package programUsingHashMap;

import java.util.HashMap;
import java.util.Map;

public class LondonInformation {
	
	private HashMap<String, Double> hash;
	
	public LondonInformation(Map<String, Double> hash){
		this.hash.putAll(hash);
	}

}
