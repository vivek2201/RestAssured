package XMLpojo;

public class Book {
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Publisher getPublisher() {
		return Publisher;
	}
	public void setPublisher(Publisher publisher) {
		Publisher = publisher;
	}
	private String Author;
	private int id;
	private Publisher Publisher;

}
