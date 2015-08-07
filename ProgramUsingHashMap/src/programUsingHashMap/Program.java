package programUsingHashMap;

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
			System.out.println("In London lives " + info[0] + " people");
			System.out.println("In London lives " + info[1] + " male");
			System.out.println("In London lives " + info[2] + " female");
			System.out.println("In London lives " + info[5] + " student");
			System.out.println("In London " + info[3] + " people live in house");
			System.out.println("In London " + info[4] + " pople lives in communal");
			String br = "Waltham Forest";
			hm.putAll(rf.readFile("LondonEthincGroup.txt"));
			System.out.println();
			LondonEthnicInformation lei = new LondonEthnicInformation(hm);
			LondonEthnicGroup leiBor = lei.getBoroughEthnicGroup(br);
			Property borough = li.getBorough(br);
			if(borough != null && leiBor != null){
				System.out.println("\tINFORMATION OF " + br + " BOROUGH, data from 2011");
				System.out.println("In " + br + " lives " + borough.getPopulation() + " people");
				System.out.println("From  " + borough.getPopulation() + ", " + borough.getMale() + " are male and " + borough.getFemale() + " female");
				System.out.println(br + " area has " + borough.getArae() +"km2");
				System.out.println(br + " has " + leiBor.getWhiteBrithish() + " white British people, " +
						leiBor.getIndian() + " Indian, " +  leiBor.getChinese() + " Chinese, " +
						leiBor.getAfricanBlackBritish() + " black African Brithish and other ethinc.");
			} else{
				System.out.println("Sorry your borough has not been found, please check your spelling and try it again");
			}
			int[] et =lei.getGroupingOfEthnicGroup();
			double whtBriPrecent =  ((double) et[0] / (int) info[0]);
			System.out.println("In London lives " + et[0] + " white British which is " + String.format("%.2f",(whtBriPrecent * 100)) +"%");
			li.printAllBorougth();
			lei.printAllBoroughsEthnicGroup();
		} catch (Exception e){
			System.out.println("Error occur:" + e.toString());
		}
		
	}

}
