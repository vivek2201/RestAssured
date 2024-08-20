package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlaceAPI")
	public void beforeScenario() throws IOException
	{
		//write the code if place id is null run this code before hitting deleteplaceapi
		placeValidationSteps placevalidation= new placeValidationSteps();
		if(placeValidationSteps.place_id==null)
		{
		placevalidation.add_place_payload("priya", "English", "Melbourne");
		placevalidation.user_calls_with_http_request("AddPlaceAPI", "POST");
		placevalidation.verify_place_id_created_maps_to_using("priya", "GetPlaceAPI");
		}
	}

}
