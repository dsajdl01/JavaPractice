package database;
/**
 * Class Query
 * 
 * @author David Sajdl 
 * @version 7
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

	private Statement  c;
	ResultSet rs;
	
		// constructor with passing parameter connection to database
		public Query(Connection con) throws SQLException{
			this.c = con.getConnection();
		}
		
	public void printAllNotBorroedBook() throws SQLException{
		ResultSet resSet = c.executeQuery("SELECT isbn, title FROM book WHERE isbn NOT IN (SELECT isbn FROM borrowed);");
		while(resSet.next()){
			System.out.printf("%-25s %5s %n", resSet.getString("isbn"), resSet.getString("title"));
		}
	}
	public void printMembersWhoBorrowedBookMorethan(int n) throws SQLException{
		rs = c.executeQuery("SELECT title, name, COUNT(name) As total_borrow_catgory  FROM member, borrowed, book "
				+ "WHERE member.memberNo = borrowed.memberNo AND book.isbn = borrowed.isbn "
				+ "GROUP BY name, category "
				+ "HAVING COUNT(name) > " + n) ;
		while(rs.next()){
			System.out.printf("%-25s %5s %n", rs.getString("title"), rs.getString("name") +"\t" + rs.getString("total_borrow_catgory") );
		}
	}
	
	public Book getBook(String title) throws SQLException{
		rs = c.executeQuery("SELECT * FROM book WHERE title = '"+title +"'");
		Book b; 
		if(rs.next()){
			Data data = new Data();
			b = data.getBooks(rs);
			return b;
		}
		return null;
	}
	public Member getMember(String name) throws SQLException{
		rs = c.executeQuery("SELECT * FROM member WHERE name = '"+name +"'");
		Member m; 
		if(rs.next()){
			Data data = new Data();
			m = data.getMember(rs);
			return m;
		}
		return null;
	}
	
}
