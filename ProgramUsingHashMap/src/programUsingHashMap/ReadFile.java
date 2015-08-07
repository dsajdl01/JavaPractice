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
	        	} else {
	        		throw new TheException("Data is not validated, in the line: " 
	        				+LA[i]+", "+LA[i+1]+", "+LA[i +2]+", "+LA[i+3]+", "+LA[i+4]+", "+LA[i+5]+", "+LA[i+6]+", "+LA[i+7]);
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
	public Map<String, LondonEthnicGroup> readFile(String fileName) throws Exception{

        // This will reference one line at a time
        String line = null;
        HashMap<String, LondonEthnicGroup> hash = new HashMap<String, LondonEthnicGroup>();
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            LondonEthnicGroup leg;
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	String[] a = line.split(",");
            	if(arrayIsValid(a)){
            		leg = new LondonEthnicGroup((a[1]),getInt(a[2]),getInt(a[3]),getInt(a[4]),getInt(a[5]),getInt(a[6]),getInt(a[7]),getInt(a[8]),getInt(a[9]),getInt(a[10]),getInt(a[11]),getInt(a[12]),getInt(a[13]),getInt(a[14]),getInt(a[15]),getInt(a[16]),getInt(a[17]),getInt(a[18]));
            		hash.put(a[0], leg);
            		System.out.println(line);
            	} else {
            		throw new TheException ("Data is not validated, on line: " + line);
            	}
             }    
            return hash;
     }

	public boolean arrayIsValid(String[] a){
			for(int i = 2; i < a.length; i++){
				if(!checkInteger(a[i])){
					System.out.println("It false: -" + a[i].replaceAll("\\s+","")+"-");
					return false;
				}
			}
			return chackingStrings(a[0],a[1]);
	}
	public boolean checkInteger(String n){
		String intRegExp = "^\\d{1,6}+$";
		return n.replaceAll("\\s+", "").matches(intRegExp);
	}
	public boolean chackingStrings(String id, String borough){
		String idRegExp = "^00[A-Z{2}]+$";
		String letterRegExp = "^[a-zA-Z]+$";
		boolean ids = id.replaceAll("\\s+", "").matches(idRegExp);
		boolean b = borough.replaceAll("\\s+", "").matches(letterRegExp);
		return ids && b;
	}
}

