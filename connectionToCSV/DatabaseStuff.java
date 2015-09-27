package ConnectionToCSV;
/**
 * Class DatabaseStuff 
 * 
 * @author dsajdl01
 * @version 7
 */
import java.sql.SQLException;
import java.sql.Statement;
import database.Connection;

public class DatabaseStuff {
	
	private Statement  c;
	
	public DatabaseStuff(Connection con) throws SQLException{
		this.c = con.getConnection();
		
	}
	
	public boolean createEthnicTableIfNotExist(){
		
	  String myTableName = "CREATE TABLE IF NOT EXISTS ethnic (" 
	            + "zone_no VARCHAR(4) NOT NULL,"  
	            + "borough VARCHAR(45) NOT NULL," 
	            + "population INT(6) NOT NULL,"
	            + "christian INT(6),"
	            + "buddhist INT(6),"
	            + "hindu INT(6),"
	            + "jewish INT(6),"
	            + "muslim INT(6),"
	            + "sikh INT(6),"
	            + "other INT(6),"
	            + "noreligion INT(6),"
	            + "withoutState INT(6),"
	            + "PRIMARY KEY (zone_no))"
	            + "ENGINE=InnoDB";
	  try {
	          c.executeUpdate(myTableName);
	      } catch (SQLException e ) {
	          System.out.println("An error has occurred on Table Creation\n" + e.getMessage());
	          return false;
	      }
	  return true;
	}
	
	public void addDataToEthnicTable(EthnicGroupInLondon et){
		String sql = "INSERT INTO ethnic (zone_no, borough, population, christian, buddhist, hindu, jewish, muslim, sikh, other, noreligion, withoutState) "
				+ "VALUES ( '"  + et.getZoneCode() + "','" + et.getZoneName() +"',"+ et.getAllPopulation() +", "+ et.getChristian() +","+ et.getBuddhist()
				+"," + et.getHindu() +"," + et.getJewish() +", " + et.getMuslim() + ", " + et.getSikh() + ", " + et.getOtherReligion() + ", " 
				+ et.getNoReligion() + ", " + et.getReligionWithoutState() +");";
		try{
			c.executeUpdate(sql);
		} catch (Exception e) { 
            System.err.println("Exception occues when data was inserning into ethnic table! "); 
            System.err.println(e.getMessage()); 
        }
	}


}
