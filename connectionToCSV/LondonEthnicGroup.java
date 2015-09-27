package ConnectionToCSV;
/**
 * interface LondonEthnicGroup 
 * 
 * @author dsajdl01
 * @version 7
 */
public interface LondonEthnicGroup {

	String getZoneCode();
	String getZoneName();
	int getAllPopulation();
	int getChristian();
	int getBuddhist();
	int getHindu();
	int getJewish();
	int getMuslim();
	int getSikh();
	int getOtherReligion();
	int getNoReligion();
	int getReligionWithoutState();
}
