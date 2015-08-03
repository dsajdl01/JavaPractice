package programUsingHashMap;

import java.util.HashMap;

public class Program {

	public static void main(String[] args) throws Exception {
		HashMap<String, Double> hm = new HashMap<String, Double>();
		// TODO Auto-generated method stub
		ReadFile rf = new ReadFile();
		try{
			hm.putAll(rf.readFile("londonArea.txt"));
			System.out.println(hm);
		} catch (Exception e){
			System.out.println("Error occur:" + e.toString());
		}
		
	}

}
