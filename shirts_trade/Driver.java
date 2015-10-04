package shirt_trade;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

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
		ReadCsvFiles read = new ReadCsvFiles();
		try{
			// read .csv file from web site
			BufferedReader  out =read.readCSVFileFromWebsite(URL);
			ShirtProcess sp = new ShirtProcess();
			HashMap<String, Shirt> stock = sp.getGroupShirtProduct(out);
			
			
			// read .csv file from local H drive 
			HashMap<String, Shirt> invoice = null;
			File dir = new File("H:/aaa_school");
			if(dir.exists()){
					ReadCsvFiles rcf = new ReadCsvFiles();
					String path = dir + "/invoice.csv";
					BufferedReader br = rcf.readCSVFileFromCompoter(path);
					invoice = sp.getGroupShirtProduct(br);
			}
			
			// read data from database
			// Connection class is in imported from database package
			Connection conn = new Connection();
			Statement  c = conn.getConnection();
			String sqlQuery = "select  * from sale";
			HashMap<String, Shirt> sales = sp.getGroupShirtsProduct( c.executeQuery(sqlQuery));
			
			// finding different between stock, invoice and sales 
			StringBuffer output = new StringBuffer();
			int diff, count = 0; 
			double total = 0;
			// looping through invoice and match data with stock and sales  
			for(Entry<String, Shirt> inv : invoice.entrySet()){
				// get key and values
				String key = inv.getKey();
				Shirt invoi = inv.getValue();
				Shirt sold = sales.get(key);
				Shirt stk = stock.get(key);
				
				// get different between files:
				if(sold == null){
					diff = (invoi.getQuantity()) - (stk.getQuantity());
				} else {
					 diff = (invoi.getQuantity()) - (sold.getQuantity() + stk.getQuantity());
				}
				//if there is different add record into string buffer
				if(diff != 0){
					count += diff;
					output.append("The " + invoi.getShirtColor() +" shirt with " + invoi.getSleevesSize()+" sleeves and " + invoi.getCotonQual() +
						"% cotton:\n");
					output.append("Invoice:   " + invoi.getQuantity() + "\nStock:     "+ stk.getQuantity() + "\nSold:      "+ sold.getQuantity());
					double amount = diff * invoi.getPrice();
					output.append("\nDifferent: "+ diff + "\nAmount:    £" +String.format( "%.2f", amount) +"\n");
					total += amount;
				}
			}
			//printout the result
			if(total !=  0){
				System.out.println("The different between invoice, sale and stock is: " + count +"\n\nMISSING PRODUCT:");
				System.out.println(output.toString());
				System.out.println("Total cost: £" + String.format( "%.2f", total));
			} else{
				System.out.println("There is no different between invoice, sale and stock");
			}
			
		} catch (IOException e){
			System.out.println(e.toString());
		} catch (SQLException sqle){
			System.out.println(sqle.toString());
		}
	}


}
