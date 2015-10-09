package shirt_trade;

import java.sql.SQLException;
import java.sql.Statement;
import database.Connection;

/**
 * class CreatingTableMySQL
 * 
 * @author David Sajdl 
 * @version 7
 */
public class CreatingTableMySQL {
	
	private Statement  c;
	
	public CreatingTableMySQL(Connection con) throws SQLException{
		this.c = con.getConnection();
		
	}
	
	public boolean createSalseTableIfNotExist(){
		
		  String myTableName = "CREATE TABLE IF NOT EXISTS sale (" 
		            + "sale_id INT(5) NOT NULL AUTO_INCREMENT,"  
		            + "color VARCHAR(45) NOT NULL," 
		            + "sleeve VARCHAR(5) NOT NULL,"
		            + "quality INT(5),"
		            + "price DECIMAL(5,2),"
		            + "quantity INT(5),"
		            + "PRIMARY KEY (sale_id))"
		            + "ENGINE=InnoDB";
		  
		  String sql = "ALTER TABLE sale AUTO_INCREMENT = 1000;";
		  
		  try {
		          c.executeUpdate(myTableName);
		          c.executeUpdate(sql);
		      } catch (SQLException e ) {
		          System.out.println("An error has occurred on Table Creation\n" + e.getMessage());
		          return false;
		      }
		  return true;
		}
	
	public void addSaleDataIntoTable(Shirt s){
		String sql = "INSERT INTO sale (color, sleeve, quality, price, quantity) "
				+ "VALUES ( '" + s.getShirtColor() +"','"+ s.getSleevesSize() +"', "+ s.getCotonQual() +","+ s.getPrice()
				+"," + s.getQuantity() +");";
		try{
			c.executeUpdate(sql);
		} catch (Exception e) { 
            System.err.println("Exception occues when data was inserning into shitrs table! "); 
            System.err.println(e.getMessage()); 
        }
	}

}
