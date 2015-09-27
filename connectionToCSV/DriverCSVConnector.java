package ConnectionToCSV;
/**
 * Class DriverCSVConnector 
 * 
 * @author dsajdl01
 * @version 7
 */
import java.io.File;
import java.util.Map;

public class DriverCSVConnector {

	public static void main(String[] args) {
		
		File dir = new File("H:/aaa_school/DatabaseConection");
		if(dir.exists()){
			ConnectToCSVFile ctv = new ConnectToCSVFile();
			Map<Integer, String> countries = ctv.readDataFromCSVFile("H:/aaa_school/DatabaseConection/country.csv");
			if(countries != null){
				for(Map.Entry<Integer, String> e : countries.entrySet()){
					String[] country = e.getValue().split(",");
					System.out.println(e.getKey() + ") County [code= " + country[4] + " , name= " + country[5]);
				}
			} else {
				System.out.println("ERROR");
			} 
			Map<Integer, String> ethnicGroup = ctv.readDataFromCSVFile("H:/aaa_school/ethnicGroup.csv");
			if(ethnicGroup !=null){
				for(Map.Entry<Integer, String> g : ethnicGroup.entrySet()){
					System.out.println(g.getKey() + "]  " +g.getValue());
				}
			}
			
		} else {
			System.out.println("SORRY: but H:/aaa_school/DatabaseConection folfers do not exist!");
		}

	}

}
