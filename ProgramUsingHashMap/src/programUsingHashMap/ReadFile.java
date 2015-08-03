package programUsingHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
		
	@SuppressWarnings("resource")
	public Map<String, Double> readFile(String fileName) throws Exception{

        // This will reference one line at a time
        String line = null;
        HashMap<String, Double> hash = new HashMap<String, Double>();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	String[] tempArr = line.split(",");
            	if(chackingStrings(tempArr[0], tempArr[1])){
            		hash.put(tempArr[0], Double.parseDouble(tempArr[1].trim()));
            	}else {
            		throw new TheException(line + " has not been validated!");            		
            	}
            }    
            // closing files.
            bufferedReader.close();
            return hash;
        } catch (TheException tEx) {
        	System.out.println("Error: The line " + tEx.toString());
        	return null;
        }
        catch(IOException ex) {
        	System.out.println("Error reading file '" 
        						+ fileName + "'\n" + ex.toString());
        	// or could be as: ex.printStackTrace();
        	return null;
        }
	}
	public boolean chackingStrings(String borough, String area){
		String digitRegExp = "^\\d{0,3}\\.\\d{0,4}$";
		String letterRegExp = "^[a-zA-Z]+$";
		return borough.replaceAll("\\s+", "").matches(letterRegExp) && area.replaceAll("\\s+","").matches(digitRegExp);
	}
}

