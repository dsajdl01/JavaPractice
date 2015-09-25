package database;
/**
 * class Books
 * 
 * @author David Sajdl
 * @version 7
 */
public class Books implements Book {
	
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String category;
	private int year;
	
	public Books(String isbn, String title, String author, String publisher, int year, String category){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.category = category;
	}

	@Override
	public String getISBN() {
		return this.isbn;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getAuthor(){
		return this.author;
	}

	@Override
	public String getPublisher() {
		return this.publisher;
	}

	@Override
	public int getYear() {
		return this.year;
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public String toString(){
		return this.isbn+", " + this.title +", " + this.author +
				", " + this.publisher + ", " + this.year + ", " + this.category;
	}
}
