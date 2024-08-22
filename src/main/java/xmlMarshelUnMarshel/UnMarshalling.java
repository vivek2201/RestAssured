package xmlMarshelUnMarshel;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarshalling {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		File file = new File("src\\main\\java\\user.xml");
		//User user = new User();
		JAXBContext context = JAXBContext.newInstance(User.class);
		Unmarshaller  unmarshaller = context.createUnmarshaller();
		User user = (User)unmarshaller.unmarshal(file);
		System.out.println(user.getAge());
		System.out.println(user.getEmail());
		System.out.println(user.getId());
		System.out.println(user.getName());
		
	}

}
