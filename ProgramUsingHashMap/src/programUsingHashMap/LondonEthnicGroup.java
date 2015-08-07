package programUsingHashMap;

public class LondonEthnicGroup {
	String borough;
	int allPeople, whiBrith, irish, otherWhite, WhiBlacCar, whiBlackAff, whitAsia, otheMix;
	int india, pakis, bang, otherAsia, blackCar, afrBlack, otherBlack, chinese, otherEtnicGroup;
	
	public LondonEthnicGroup(String bor,int all, int br, int ir, int otWH, int wb, int wba,int wa,int om, int i, int p, int b, int oa, int bc, int ab, int ob, int ch, int oeg){
		this.borough = bor.trim();
		this.allPeople = all;
		this.whiBrith = br;
		this.irish = ir;
		this.otherWhite = otWH;
		this.WhiBlacCar =  wb;
		this.whiBlackAff = wba;
		this.whitAsia = wa;
		this.otheMix = om;
		this.india = i;
		this.pakis = p;
		this.bang = b;
		this.otherAsia = oa;
		this.blackCar = bc;
		this.afrBlack = ab;
		this.otherBlack = ob;
		this.chinese = ch;
		this.otherEtnicGroup = oeg;
	}
	public String getBorough(){
		return this.borough;
	}
	
	public int getAllPeople(){
		return this.allPeople;
	}
	public int getWhiteBrithish(){
		return this.whiBrith;
	}
	
	public int getWhiteIrish(){
		return this.irish;
	}
	public int getOtherWhite(){
		return this.otherWhite;
	}
	public int getWhiteBlackCaribbean(){
		return this.WhiBlacCar;
	}
	public int getWhiteBlackAfrican(){
		return this.whiBlackAff;
	}
	public int getWhiteAsian(){
		return this.whitAsia;
	}
	public int getOtherMixed(){
		return this.otheMix;
	}
	public int getIndian(){
		return this.india;
	}
	public int getPakistani(){
		return this.pakis;
	}
	public int getBangladeshi(){
		return this.bang;
	}
	public int getOtherAsian(){
		return this.otherAsia;
	}
	public int getCaribbeanBlackBrithish(){
		return this.blackCar;
	}
	public int getAfricanBlackBritish(){
		return this.afrBlack;
	}
	public int getOtherBlackBritish(){
		return this.otherBlack;
	}
	public int getChinese(){
		return this.chinese;
	}
	public int getOtherEthicGroup(){
		return this.otherEtnicGroup;
	}
	@Override
	public String toString(){
		return this.getBorough() +",  "+ this.getAllPeople() + ",  "+ this.getWhiteBrithish() +", "+ 
				this.getWhiteIrish()+", "+ this.getOtherWhite() +", "+ this.getWhiteBlackCaribbean() +", "+
				this.getWhiteBlackAfrican() +", "+ this.getWhiteAsian() +", " + this.getOtherMixed() + ", " +
				this.getIndian() +", " +this.getPakistani()+ ", " + this.getBangladeshi() + ", " + 
				this.getOtherAsian() +", " + this.getCaribbeanBlackBrithish() +", " + this.getAfricanBlackBritish() +", " +
				this.getOtherBlackBritish() + ", " + this.getChinese() + ", " + this.getOtherEthicGroup();
	}
}