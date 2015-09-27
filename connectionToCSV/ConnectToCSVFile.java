package ConnectionToCSV;
/**
 * Class connectToSCYFile 
 * 
 * @author dsajdl01
 * @version 7
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConnectToCSVFile {
	
	private BufferedReader br;
	
	public ConnectToCSVFile(){
		br = null;
	}

	public Map<Integer, String> readDataFromCSVFile(String fileName){
		HashMap<Integer,String> file = new HashMap<Integer,String>();
		try{
			String line;
			int index = 0;
			br = new BufferedReader(new FileReader(fileName));
			while((line = br.readLine()) !=null){
				file.put(index, line);
				index++;
			}
		} catch (FileNotFoundException e) {
		    	e.printStackTrace(); 
		} catch (IOException e) {
				e.printStackTrace();
		} finally {
			if(br != null){
				try{
					br.close();
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
			}
		}
		return file;
	}
}
