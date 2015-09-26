package database;
/**
 * class UpdateDatabase
 * 
 * @author David Sajdl 
 * @version 7
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDatabase {
	
	private Statement  c;
	private final String insert = "INSERT INTO";
	private final String val = "VALUES(";
	
	// constructor with passing parameter connection to database
	public UpdateDatabase(Connection con) throws SQLException{
		this.c = con.getConnection();
	}
	
	/**
	 * insertMember method enable to insert incoming data into database table call member 
	 * 
	 * @param name String member's name
	 * @param age integer member's age
	 */
	public void inserMember(String name, int age){
		try{
			String sql=  insert + " member (name, age) "+ val +"'"+name+"',"+ age+")";
			c.executeUpdate(sql);
		} catch (Exception e) { 
            System.err.println("Member table gots an exception! "); 
            System.err.println(e.getMessage()); 
        } 
	}
	/**
	 * inserBook method enable to insert incoming data into database table called book 
	 * 
	 * @param isbn String book's ISBN
	 * @param title String book's title
	 * @param author  String book's author
	 * @param publisher  String book's publisher
	 * @param year  int book's year
	 * @param category  String book's category
	 */
	public void inserBook(String isbn, String title, String author, String publisher, int year, String category){
		try{
			String sql = insert + " book (isbn, title, author, publisher, year, category) " + val +
				"'"+isbn+"','"+title+"','"+author+"','"+publisher+"',"+year+",'"+category+"')";
			c.executeUpdate(sql);
		} catch (Exception e) { 
            System.err.println("Boot table gots an exception! "); 
            System.err.println(e.getMessage()); 
        }
	}
	
	/**
	 *  countTuplesIntable method enable to count all rows from incoming table string;
	 *  
	 * @param tableName String table name
	 * @return integer represent numbers of rows or -1 if table name does not exist in database. 
	 */
	public int countTuplesIntable(String tableName){
		int tuples = 0;
		if(!(tableName.equals("member")) && !(tableName.equals("book")) && !(tableName.equals("borrowed"))){
			System.out.println("Incorrect table name. Please check table name and try it again.");
			return -1;
		}
		try{
			ResultSet resSet = c.executeQuery("SELECT count(*) FROM " + tableName);
			if(resSet.next()){
				tuples = resSet.getInt(1);
			} else{
				System.out.println("Database error has occured during counting rows!");
				tuples = -1;
			}
			
		} catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
		return tuples; 
	}
}