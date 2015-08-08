package programUsingHashMap;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Program {

	public static void main(String[] args) throws Exception {
		HashMap<String, LondonEthnicGroup> hm = new HashMap<String, LondonEthnicGroup>();
		HashMap<String, Property> hash = new HashMap<String, Property>();
	
		ReadFile rf = new ReadFile();
		try{
			hash.putAll(rf.filereader("londonAtributes.txt"));
			LondonInformation li = new LondonInformation(hash);
			System.out.println("\tLONDON'S INFORMATION ARE FROM THE YEAR 2011");
			System.out.println("London area has " + li.getAreaOfLondon() + "km2");
			System.out.println("London's biggest borough is: " + li.getBiggestBorough());
			System.out.println("London's smallest borough is: " + li.getsmallestBorough());
			int[] info = li.getLondonInformation();
			System.out.println("In London lives " + formatNum(info[0]) + " people");
			System.out.println("In London lives " + formatNum(info[1]) + " male");
			System.out.println("In London lives " + formatNum(info[2]) + " female");
			System.out.println("In London lives " + formatNum(info[5]) + " student");
			System.out.println("In London " + formatNum(info[3]) + " people live in house");
			System.out.println("In London " + formatNum(info[4]) + " pople lives in communal");
			String br = "Waltham Forest";
			hm.putAll(rf.readFile("LondonEthincGroup.txt"));
			System.out.println();
			LondonEthnicInformation lei = new LondonEthnicInformation(hm);
			LondonEthnicGroup leiBor = lei.getBoroughEthnicGroup(br);
			Property borough = li.getBorough(br);
			if(borough != null && leiBor != null){
				System.out.println("\tINFORMATION OF " + br + " BOROUGH, data from 2011");
				System.out.println("In " + br + " lives " + formatNum(borough.getPopulation()) + " people");
				System.out.println("From  " + formatNum(borough.getPopulation()) + ", " + formatNum(borough.getMale()) + " are male and " + formatNum(borough.getFemale()) + " female");
				System.out.println(br + " area has " + borough.getArae() +"km2");
				System.out.println(br + " has " + formatNum(leiBor.getWhiteBrithish()) + " white British people, " +
						formatNum(leiBor.getIndian()) + " Indian, " +  formatNum(leiBor.getChinese()) + " Chinese, " +
						formatNum(leiBor.getAfricanBlackBritish()) + " black African Brithish and other ethinc.");
			} else{
				System.out.println("Sorry your borough has not been found, please check your spelling and try it again");
			}
			int[] le = lei.getLondonEthnic();
			System.out.println("\nIn London lives " + formatNum(le[0]) + " white British, which is " + getPrecentage(le[0], info[0]));
			System.out.println("In London lives " + formatNum(le[1]) + " white Irish, which is " + getPrecentage(le[1], info[0]));
			System.out.println("In London lives " + formatNum(le[2]) + " other white, which is " + getPrecentage(le[2], info[0]));
			System.out.println("In London lives " + formatNum(le[3]) + " Indian, which is " + getPrecentage(le[3], info[0]));
			System.out.println("In London lives " + formatNum(le[4]) + " Pakistani, which is " + getPrecentage(le[4], info[0]));
			System.out.println("In London lives " + formatNum(le[5]) + " Bangladeshi, which is " + getPrecentage(le[5], info[0]));
			System.out.println("In London lives " + formatNum(le[6]) + " African black British, which is " + getPrecentage(le[6], info[0]));
			System.out.println("In London lives " + formatNum(le[7]) + " Chinese, which is " + getPrecentage(le[7], info[0]));
			int[] et =lei.getGroupingOfEthnicGroup();
			System.out.println("\nIn London lives " + formatNum(et[0]) + " white British and European, which is " + getPrecentage(et[0], info[0]));
			System.out.println("In London lives " + formatNum(et[1]) + " white black British, which is " + getPrecentage(et[1], info[0]));
			System.out.println("In London lives " + formatNum(et[2]) + " Indian, Pakistani, Bangladeshi, which is " + getPrecentage(et[2], info[0]));
			System.out.println("In London lives " + formatNum(et[3]) + " black British, which is " + getPrecentage(et[3], info[0]));
			System.out.println("In London lives " + formatNum(et[4]) + " Asian, which is " + getPrecentage(et[4], info[0]));
			li.printAllBorougth();
			lei.printAllBoroughsEthnicGroup();
		} catch (Exception e){
			System.out.println("Error occur:" + e.toString());
		}
		
	}
	public static String getPrecentage(int ethnicPop, int londonPop){
		double total =  ((double) ethnicPop / (int) londonPop);
		return String.format("%.2f",(total * 100)) +"%";
	}

	public static String formatNum(int n){
		String pattern = "##,###,###";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(n); 
	}
}
