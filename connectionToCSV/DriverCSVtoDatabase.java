package ConnectionToCSV;
/**
 * Class DriverCSVtoDatabase 
 * 
 * @author dsajdl01
 * @version 7
 */
import java.io.File;
import java.sql.SQLException;
import java.util.Map;



import database.Connection;

public class DriverCSVtoDatabase {

	public static void main(String[] args) {
		try{
			File dir = new File("H:/aaa_school");
			if(dir.exists()){
				ConnectToCSVFile ctvf = new ConnectToCSVFile();
				Map<Integer, String> ethnicGroup = ctvf.readDataFromCSVFile("H:/aaa_school/ethnicGroup.csv");
				if(ethnicGroup != null){
					MapObject mo = new  MapObject();
					Map<Integer, EthnicGroupInLondon> ethnicG = mo.getDataToObject(ethnicGroup);
					Connection con = new Connection();
					DatabaseStuff ds = new DatabaseStuff(con);
					boolean isTableExist = ds.createEthnicTableIfNotExist();
					if(isTableExist){
						int len = ethnicG.size();
						for(int i = 0; i < len; i++){
							ds.addDataToEthnicTable(ethnicG.get(i));
						}
						System.out.println("Data added into ethnic table");
					} else{
						System.out.println("ethnic table does not exist in database!!");
					}
				} else {
					System.out.println("ERROR occuer to read csv file");
				}
			}
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
