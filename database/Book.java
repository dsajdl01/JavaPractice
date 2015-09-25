package database;
/**
 * interface Book
 * 
 * @author David Sajdl 
 * @version 7
 */
public interface Book {
	String getISBN();
	String getTitle();
	String getAuthor();
	String getPublisher();
	int getYear();
	String getCategory();

}
