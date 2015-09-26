package database;
/**
 * Class DriverQuery
 * 
 * @author David Sajdl 
 * @version 7
 */

import java.sql.SQLException;

public class DriverQuery {

	public static void main(String[] args) {
		
		try{
			Connection con = new Connection();
			Query query = new Query(con);
			System.out.println("All books in Library which are not borrowwed:");
			query.printAllNotBorroedBook();
			System.out.println("\nAll books which where borrowwed more than 2 times with the same member are:");
			query.printMembersWhoBorrowedBookMorethan(2);
			System.out.println("\nGet all datails of the book 'The Greatest Show on Earth'");
			Book book = query.getBook("The Greatest Show on Earth");
			System.out.println((book == null)? "The book this name has not been found" : book);
			System.out.println("\nGet details of the member 'Gaby Navas'");
			Member member = query.getMember("Gaby Navas");
			System.out.println((member == null)? "Member with Gaby Navas has not been found" : member);
		} catch(SQLException sqle){
			 System.out.println("SQL exception: " + sqle.toString());
		}
	}

}
