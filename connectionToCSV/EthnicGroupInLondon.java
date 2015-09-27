package ConnectionToCSV;
/**
 * Class EthnicGroupInLondon 
 * 
 * @author dsajdl01
 * @version 7
 */
public class EthnicGroupInLondon implements LondonEthnicGroup {
	
	private String zone;
	private String name;
	private int allPep;
	
	private int christian;
	private int buddhist;
	private int hindu;
	
	private int jewish;
	private int muslim;
	private int sikh;
	
	private int other;
	private int noReligion;
	private int withoutState;

	public EthnicGroupInLondon(String zone, String name, int allP, int chr, int bud, int hin, int jew, int mus, int sikh, int other,int noR, int ws){
		this.zone = zone;
		this.name = name;
		this.allPep = allP;
		this.christian = chr;
		this.buddhist = bud;
		this.hindu = hin;
		this.jewish = jew;
		this.muslim = mus;
		this.sikh = sikh;
		this.other = other;
		this.noReligion = noR;
		this.withoutState = ws;
	}
	
	@Override
	public String getZoneCode() {
		return this.zone;
	}

	@Override
	public String getZoneName() {
		return this.name;
	}

	@Override
	public int getAllPopulation() {
		return this.allPep;
	}

	@Override
	public int getChristian() {
		return this.christian;
	}

	@Override
	public int getBuddhist() {
		return this.buddhist;
	}

	@Override
	public int getHindu() {
		return this.hindu;
	}

	@Override
	public int getJewish() {
		return this.jewish;
	}
	
	@Override
	public int getMuslim(){
		return this.muslim;
	}

	@Override
	public int getSikh() {
		return this.sikh;
	}

	@Override
	public int getOtherReligion() {
		return this.other;
	}

	@Override
	public int getNoReligion() {
		return this.noReligion;
	}

	@Override
	public int getReligionWithoutState() {
		// TODO Auto-generated method stub
		return this.withoutState;
	}
	
	@Override
	public String toString(){
		return this.getZoneCode() + " " + this.getZoneName() + " " + this.getAllPopulation() + " " + this.getChristian()
		   					+ " " + this.getBuddhist() + " " + this.getHindu() + " " + this.getJewish()
		   				    + " " + this.getMuslim() + " " + this.getSikh() + " " + this.getOtherReligion() 
		   					+ " " + this.getNoReligion() + " " + this.getReligionWithoutState();
	}

}
