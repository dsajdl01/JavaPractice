package OOP.comparator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * class SCVReader read shirt.scv file 
 * and initialize object base on file values.
 * Then the object Shirts is stored in hashmap.
 * 
 * @author David Sajdl 
 * @version 7
 */
public class SCVReader {
 
    private BufferedReader br;
    
    public SCVReader(){
        br = null;
    }
    
    public Map<Integer, Shirts> readDataFronSCVShitrFile(){
        HashMap<Integer, Shirts> shirts = new HashMap<Integer, Shirts>();
        try{
            String line;
            int index = 0;
            br = new BufferedReader(new FileReader("shirts.csv"));
            while((line = br.readLine()) != null){
                Shirts s = getShirtObject(line);
                shirts.put(index,s);
                index++;
            }
        } catch (FileNotFoundException e) {
		    	System.out.println(e.getMessage()); 
		} catch (IOException e) {
				System.out.println(e.getMessage()); 
		} finally {
			if(br != null){
				try{
					br.close();
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
			}
		}
		return shirts;
	}
	// convert string, which rerpesent line of .scv file to Shirts object 
	// and return created shirts object 
    private Shirts getShirtObject(String l){
        String[] data = l.split(",");
        return new Shirts(data[0].trim(), data[1].trim(), data[2].trim(),getInt(data[3]),getInt(data[4]),getInt(data[5]));
    }
    // convert string number to integer and return converted integer
    private int getInt(String n){
        return Integer.parseInt(n);
    }
}
