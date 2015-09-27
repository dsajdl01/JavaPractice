package ConnectionToCSV;
/**
 * Class MapObject 
 * 
 * @author dsajdl01
 * @version 7
 */
import java.util.HashMap;
import java.util.Map;

public class MapObject {
	
	public Map<Integer,EthnicGroupInLondon> getDataToObject(Map<Integer, String> data){
		
		HashMap<Integer,EthnicGroupInLondon> eg = new HashMap<Integer,EthnicGroupInLondon>();
		for(Map.Entry<Integer, String> d : data.entrySet()){
			String line = d.getValue();
			String[] eGroup = line.split(",");
			int index = getInt(eGroup[0]);
			EthnicGroupInLondon group = new EthnicGroupInLondon(eGroup[1], eGroup[2], getInt(eGroup[3]), 
							 getInt(eGroup[4]), getInt(eGroup[5]), getInt(eGroup[6]), getInt(eGroup[7]), 
							 getInt(eGroup[8]), getInt(eGroup[9]), getInt(eGroup[10]), getInt(eGroup[11]), getInt(eGroup[12]));
			eg.put(index, group);
		}
		return eg;
	}
	
	private int getInt(String n){
		return Integer.parseInt(n);
	}

}
