package shirt_trade;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Class ShirtProcess
 * 
 * @author David Sajdl 
 * @version 7
 */
public class ShirtProcess {

	private static boolean firstline = true;
	HashMap<String, Shirt> product;
	
	
	public HashMap<String, Shirt> getGroupShirtProduct(BufferedReader br) throws IOException{
		product = new HashMap<String, Shirt>();
		String line;
		while((line = br.readLine()) != null){
			if(!firstline){
				String[] array = line.split(",");
				String key = array[1].trim() +"_" + array[2].trim() +"_"+array[3].trim();
				
				if(product.containsKey(key)){
					product.get(key).plusQuantity(getInt(array[5].trim()));
					product.get(key).addPrice(Double.parseDouble(array[4].trim()));
				}
				else{
					Shirt s = gerShirtObject(line);
					product.put(key, s);
				}
				
			} else {
				firstline = false;
			}
		}
		firstline = true;
		return product;
	}
	
	public HashMap<String, Shirt> getGroupShirtsProduct(ResultSet rs) throws SQLException{
		 product = new HashMap<String, Shirt>();
		 while(rs.next()){
			 String key = rs.getString("color")+"_"+rs.getString("sleeve")+"_"+ rs.getInt("quality");
			
			 if(product.containsKey(key)){
				product.get(key).plusQuantity(rs.getInt("quantity"));
				product.get(key).addPrice(rs.getDouble("price"));
			 } 
			 else {
				 Shirt s = gerShirtObject(rs.getString("sale_id")+","+rs.getString("color")+","
						 +rs.getString("sleeve")+","+ rs.getInt("quality")+","+rs.getDouble("price")+","+rs.getInt("quantity"));
				 product.put(key, s);
			 }
		 }
		 return product;
	}
	
	public Shirt gerShirtObject(String line){
		String[] array = line.split(",");
		return new Shirt(getInt(array[0].trim()), array[1].trim(), array[2].trim(), 
				getInt(array[3].trim()), Double.parseDouble(array[4].trim()), getInt(array[5].trim()));
	}
	
	private int getInt(String n) {
		// TODO Auto-generated method stub
		return Integer.parseInt(n);
	}
}
