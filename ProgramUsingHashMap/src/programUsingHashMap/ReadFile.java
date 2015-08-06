package programUsingHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
		
	
	public Map<String, Property> filereader(String filename) throws Exception{
		
		HashMap<String, Property> map = new HashMap<String, Property>();
		Path file = Paths.get(filename);
		byte[]  bytes = Files.readAllBytes(file);
        String str = new String(bytes);
        String[] LA = str.split(",|\n");
        for(int i = 0; i < LA.length; i = i + 8){
        	if(validateProperty(LA[i], LA[i+1], LA[i +2], LA[i+3], LA[i+4], LA[i+5], LA[i+6], LA[i+7])){
        		double AREA = Double.parseDouble(LA[i+7].trim());
        		Property pr = new Property(getInt(LA[i+1]),getInt(LA[i +2]), getInt(LA[i+3]), getInt(LA[i+4]), getInt(LA[i+5]), getInt(LA[i+6]), AREA);
           		map.put(LA[i], pr);
        	}
        }
		return map;
	}
	public int getInt(String n){
		return Integer.parseInt(n.trim());
	}
	public boolean validateProperty(String bor,String a,String b,String c,String d,String e,String f,String area){
		String digitRegExp = "^\\d{0,3}\\.\\d{0,4}$";
		String letterRegExp = "^[a-zA-Z]+$";
		String intRegExp = "^\\d{1,6}+$";
		boolean borough = bor.replaceAll("\\s+", "").matches(letterRegExp);
		boolean a1 = a.replaceAll("\\s+", "").matches(intRegExp);
		boolean b1 = b.replaceAll("\\s+", "").matches(intRegExp);
		boolean c1 = c.replaceAll("\\s+", "").matches(intRegExp);
		boolean d1 = d.replaceAll("\\s+", "").matches(intRegExp);
		boolean e1 = e.replaceAll("\\s+", "").matches(intRegExp);
		boolean f1 = f.replaceAll("\\s+", "").matches(intRegExp);
		boolean area1 = area.replaceAll("\\s+", "").matches(digitRegExp);
		return borough && a1 && b1 && c1 && d1 && e1 && f1 && area1;
	}
	
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

