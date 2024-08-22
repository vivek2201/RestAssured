package xmlMarshelUnMarshel;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
public class Marshelling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
User user= new User();
user.setId(123);
user.setAge(50);
user.setEmail("priya@gmail.com");
user.setName("Vivek");

try {
    JAXBContext context = JAXBContext.newInstance(User.class);
    Marshaller marshaller = context.createMarshaller();
   
File file = new File("src\\main\\java\\user.xml");
    marshaller.marshal(user, file);
    System.out.println();
} catch (JAXBException e) {
    e.printStackTrace();
}
}
	}

