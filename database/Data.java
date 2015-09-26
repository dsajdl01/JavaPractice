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
			Data data = new Data();
			Connection con = new Connection();
			UpdateDatabase ud = new UpdateDatabase(con);
			
			Statement  c = con.getConnection();
			String sql = ("SELECT * FROM book;");
			String sqlMem = ("SELECT * FROM member;");
			
			//print all tuples of books 
			ResultSet rs =c.executeQuery(sql); //"SELECT * FROM book ORDER BY author DESC LIMIT 1;");
			while(rs.next()) { 
				Books book = data.getBooks(rs);
				System.out.println(book);
				book = null;
			} 
			System.out.println("\n------------------------------------------------------------\n");
			//print all tuples of members
			ResultSet rsm = c.executeQuery(sqlMem);
			while(rsm.next()){
				Member m = data.getMember(rsm);
				System.out.println(m);
				m = null;
			}
			
			System.out.println("\n--------------------------------------------------");
			// counting all rows before inserting a new book
			int bookRows = ud.countTuplesIntable("book");
			System.out.println((bookRows > 0) ? "\nThe book table has "+ bookRows + " rows": "\nERROR");
			
			// inserting book into database
			Books nB = new Books("10 0-07-71256-3", " Object-Oriented System", "Simmon Bennett", 
					"McGrow-Hi;; Education", 2010, "Computing");
			ud.inserBook(nB.getISBN(), nB.getTitle(), nB.getAuthor(), nB.getPublisher(), nB.getYear(), nB.getCategory());
			nB = null;
			// counting all rows after anew book is inserted
			System.out.println("Count all rows after inserting new BOOK into database:");
			int bookRows2 = ud.countTuplesIntable("book");
			System.out.println((bookRows2 > 0) ? "The book table has "+ bookRows2 + " rows": "ERROR");
			
			System.out.println("\n--------------------------------------------------");
			// counting all rows before inserting a new member;
			int memRows = ud.countTuplesIntable("member");
			System.out.println((memRows > 0) ? "\nThe member table has "+ memRows + " rows": "\nERROR");
			// inserting a new member into database
			String name = "Alex Best";
			int age = 33;
			ud.inserMember(name, age);
			// counting all rows after a new member is inserted into member table
			System.out.println("Count all rows after inserting new MEMBER into database:");
			int memRows1 = ud.countTuplesIntable("member");
			System.out.println((memRows1 > 0) ? "The member table has "+ memRows1 + " rows": "ERROR");

			
			c.close();
		} catch(SQLException sqle){
			 System.out.println("SQL exception: " + sqle.toString());
		}
  }

	public Books getBooks(ResultSet r) throws SQLException{
		 return  new Books(r.getString("isbn"), r.getString("title"), r.getString("author"), r.getString("publisher"), r.getInt("year"), r.getString("category"));
	}
	
	public Member getMember(ResultSet r) throws SQLException{
		return new Member(r.getInt("memberNo"), r.getString("name"), r.getInt("age"));
	}

}
