package test;

public class Books {
private  int bookId;
private String title;
private String author;
private long isbn;
private  String catogery;
private String description;
private int totalcopies;
private int availablecopies;
private int is_borrowed;
	// TODO Auto-generated constructor stub

	// TODO Auto-generated constructor stub

public Books() {
	// TODO Auto-generated constructor stub
}

public int isIs_borrowed() {
	return is_borrowed;
}
public void setIs_borrowed(int is_borrowed) {
	this.is_borrowed = is_borrowed;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public long getIsbn() {
	return isbn;
}
public void setIsbn(long isbn) {
	this.isbn = isbn;
}
public String getCategory() {
	return catogery;
}
public void setCategory(String category) {
	this.catogery = category;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getTotalcopies() {
	return totalcopies;
}
public void setTotalcopies(int totalcopies) {
	this.totalcopies = totalcopies;
}
public int getAvailablecopies() {
	return availablecopies;
}
public void setAvailablecopies(int availablecopies) {
	this.availablecopies = availablecopies;
}
public Books(int bookId, String title, String author, long isbn, String catogery, String description, int totalcopies, int availablecopies, int is_Borrowed) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.author = author;
	this.isbn = isbn;
	this.catogery = catogery;
	this.description = description;
	this.totalcopies = totalcopies;
	this.availablecopies = availablecopies;
	this.is_borrowed=is_Borrowed;
}
}

