package XMLpojo;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class complexUnmarshalling {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		JAXBContext context = JAXBContext.newInstance(Library.class);
		File file = new File("src\\main\\java\\Library.xml");
		Unmarshaller unmarshaller = context.createUnmarshaller();
	Library l=(Library)	unmarshaller.unmarshal(file);
	System.out.println(l.getBook().get(0).getAuthor());
	System.out.println(l.getBook().get(1).getId());
	System.out.println(l.getBook().get(0).getTitle());
	System.out.println(l.getBook().get(1).getPublisher().getYear());
	}

}
