package XMLpojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Library {
 public List<Book> getBook() {
		return Book;
	}

	public void setBook(List<Book> book) {
		Book = book;
	}

private List<Book> Book;
}
