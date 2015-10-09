package shirt_trade;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import database.Connection;

/**
 * Class DriverAddingDataToDatabase
 * 
 * @author David Sajdl 
 * @version 7
 */
public class DriverAddingDataToDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("H:/aaa_school");
		try{
			if(dir.exists()){
				ReadCsvFiles rcf = new ReadCsvFiles();
				String path = dir + "/sale.csv";
				BufferedReader br = rcf.readCSVFileFromCompoter(path);
				String line;
				boolean firstline = true;
				ShirtProcess sp = new ShirtProcess();
				// Connection class is in the database package
				Connection conn = new Connection();
				CreatingTableMySQL ctm = new CreatingTableMySQL(conn);
				boolean isDatabaseExist = ctm.createSalseTableIfNotExist();
				if(isDatabaseExist){
					while((line = br.readLine()) != null){
						if(!firstline){
							Shirt shirt = sp.gerShirtObject(line);
							ctm.addSaleDataIntoTable(shirt);
							shirt = null;
							System.out.println(line);
						} else{
							firstline = false;
						}
					}
				}
			}
		} catch (IOException ioe){
			System.out.println(ioe.toString());
		} catch (SQLException sqlE){
			System.out.println(sqlE.toString());
		}
	}

}
