package programUsingHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LondonEthnicInformation {

	private HashMap<String,LondonEthnicGroup> hash = new HashMap<String,LondonEthnicGroup>();
	
	
	public LondonEthnicInformation(Map<String,LondonEthnicGroup> leg) throws TheException{
		if(leg.isEmpty()) throw new TheException("The Object 'LondonEthnicGroup' is null");
		hash.putAll(leg);
	}
	public int[] getLondonEthnic(){
		int[] et = {0,0,0 ,0,0,0 ,0,0};
		Collection<LondonEthnicGroup> values = hash.values();
    	for (LondonEthnicGroup value : values) {
    		et[0] += value.getWhiteBrithish();
    		et[1] += value.getWhiteIrish();
    		et[2] += value.getOtherWhite();
    		et[3] += value.getIndian();
    		et[4] += value.getPakistani();
    		et[5] += value.getBangladeshi();
    		et[6] += value.getAfricanBlackBritish();
    		et[7] += value.getChinese();
    	}
    	return et;
	}
	public int[] getGroupingOfEthnicGroup(){
		int[] et = {0,0,0 ,0,0};
		Collection<LondonEthnicGroup> values = hash.values();
    	for (LondonEthnicGroup value : values) {
    		et[0] += value.getWhiteBrithish() + value.getWhiteIrish() + value.getOtherWhite();
    		et[1] += value.getWhiteBlackCaribbean() + value.getWhiteBlackAfrican() + value.getWhiteAsian() + value.getOtherMixed();
    		et[2] += value.getIndian() + value.getPakistani() + value.getBangladeshi() + value.getOtherAsian();
    		et[3] += value.getCaribbeanBlackBrithish() + value.getAfricanBlackBritish() + value.getOtherBlackBritish() + value.getOtherBlackBritish();
    		et[4] += value.getChinese() + value.getOtherEthicGroup();
    	}
    	return et;
	}
	public LondonEthnicGroup getBoroughEthnicGroup(String bor){
		Collection<LondonEthnicGroup> values = hash.values();
    	for (LondonEthnicGroup value : values) {
    		if(bor.equals(value.getBorough().trim())){
    			return value;
    		}
    	}
		return null;
	}
	public void printAllBoroughsEthnicGroup(){
		System.out.println("\n     [1] \t[2]\t  [3]   [4]   [5]    [6]  [7]  [8]    [9]  [10]  [11]  [12]   [13]  [14]  [15]  [16] [17]  [18]");
		Collection<LondonEthnicGroup> values = hash.values();
    	for (LondonEthnicGroup value : values) {
    		System.out.println(value.toString());
    	}
    	
    	System.out.println( "[01] = London Borough \n[02] = All People\n[03] = White British\n[04] = White Irish"
    			+ "\n[05] = Other White\n[06] = White Black Caribbean\n[07] = White Black African\n[08] = White Asian"
    			+ "\n[09] = Othe Mixed\n[10] = Indian\n[11] = Pakistani\n[12] = Bangladeshi\n[13] = Other Asian"
    			+ "\n[14] = Black Caribbean British\n[15] = African Black  British\n[16] = Other Black Brithish"
    			+ "\n[17] = Chinese\n[18] = Other Ethic Group");
		
    	
    	
    	
    	
	}
}
