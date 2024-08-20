package resources;
import java.util.ArrayList;
import java.util.List;
import pojo.AddPlace;
import pojo.Location;

public class TestdataBuild {

	public AddPlace AddPlacePayload(String name, String langauge, String address)
	{
		AddPlace addplace = new AddPlace();
		addplace.setAccuracy(50);
		addplace.setName(name);
		addplace.setAddress(address);
		addplace.setLanguage(langauge);
		addplace.setWebsite("http://google.com");
		addplace.setPhone_number("(+91) 983 893 3937");
		List<String>  types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		addplace.setTypes(types);
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		addplace.setLocation(location);
		return addplace;
	}
	public String deletePayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
	}
}
