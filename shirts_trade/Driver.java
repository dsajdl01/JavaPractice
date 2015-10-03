package shirt_trade;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Connection;

/**
 * Class Driver
 * 
 * @author David Sajdl 
 * @version 7
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL =  "https://raw.githubusercontent.com/dsajdl01/JavaPractice/master/shirts_trade/stock.csv";
		String line;
		ReadCsvFiles read = new ReadCsvFiles();
		try{
			// read .csv file from web site
			BufferedReader  out =read.readCSVFileFromWebsite(URL);
			System.out.println("\tSTOCK");
			
			while((line = out.readLine()) != null){
				System.out.println(line);
			}
			System.out.println("\n----------------------------\n");
			
			// read .csv file from local H drive  
			File dir = new File("H:/aaa_school");
			if(dir.exists()){
					ReadCsvFiles rcf = new ReadCsvFiles();
					String path = dir + "/invoice.csv";
					BufferedReader br = rcf.readCSVFileFromCompoter(path);
					System.out.println("\tINVOICE");
					while((line = br.readLine()) != null){
						System.out.println(line);
					}
			}
			
			System.out.println("\n----------------------------\n");
			// read data from database
			Connection conn = new Connection();
			Statement  c = conn.getConnection();
			String sqlQuery = "select  * from sale";
			ResultSet rs =c.executeQuery(sqlQuery);
			System.out.println("\tSALES");
			while(rs.next()){
				System.out.println(rs.getShort(1)+",  "+ rs.getString(2)+",  "+ rs.getString(3)+ ", "
				+ rs.getShort(4) +",  "+ rs.getDouble(5) +",  "+ rs.getShort(6));
			}
			
		} catch (IOException e){
			System.out.println(e.toString());
		} catch (SQLException sqle){
			System.out.println(sqle.toString());
		}
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
