package database;

/**
 * class Data
 * 
 * @author David Sajdl 
 * @version 7
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Data {

	public static void main(String[] args) {
	
		try{
			Connection con = new Connection();
			
			Statement  c = con.getConnection();
			String sql = ("SELECT * FROM book;");
			
			ResultSet rs =c.executeQuery(sql); //"SELECT * FROM book ORDER BY author DESC LIMIT 1;");
			while(rs.next()) { 
				Books book = getBooks(rs);
				System.out.println(book);
				book = null;
			} 
		
		} catch(SQLException sqle){
			 System.out.println("SQL exception: " + sqle.toString());
	 }
  }

	public static Books getBooks(ResultSet r) throws SQLException{
		Books book = new Books(r.getString("isbn"), r.getString("title"), r.getString("author"), r.getString("publisher"), r.getInt("year"), r.getString("category"));
		return book;
	}

}
