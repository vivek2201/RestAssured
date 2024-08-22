package XMLpojo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import xmlMarshelUnMarshel.User;

public class ComplexMarshelling {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
Publisher publisher = new Publisher();
publisher.setName("Priya");
publisher.setYear(2024);
Book book = new Book();
book.setAuthor("WrenMartin");
book.setId(1);
book.setPublisher(publisher);
book.setTitle("English");

Publisher publisher2 = new Publisher();
publisher2.setName("Prentice Hall");
publisher2.setYear(2008);
Book book2 = new Book();
book2.setId(2);
book2.setTitle("Clean Code");
book2.setAuthor("Robert C. Martin");
book2.setPublisher(publisher2);
Library library = new Library();
List<Book> booklist= new ArrayList<Book>();
booklist.add(book);
booklist.add(book2);

library.setBook(booklist);
JAXBContext context = JAXBContext.newInstance(Library.class);
Marshaller marshaller = context.createMarshaller();
File file = new File("src\\main\\java\\Library.xml");
marshaller.marshal(library, file);
	}

}

