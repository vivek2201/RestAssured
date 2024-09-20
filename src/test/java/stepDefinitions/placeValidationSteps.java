package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestdataBuild;
import resources.utilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import builder.JsonBuild;

public class placeValidationSteps extends utilities {
	RequestSpecification res;
	Response response;
	static String  place_id;
	JsonPath js;
	TestdataBuild data = new TestdataBuild();
	String filePath;
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String langauge, String address) throws IOException {
		filePath= "Config//AddPlacePayload.json";
		Map<String,String> data= new HashMap<String,String>();
	    data.put("name",name);
	    data.put("address", address);
	    data.put("language",langauge);
	 	
	res=given().spec(requestSpec())
			.body(JsonBuild.updatePayload(data,filePath));
			//.body(data.AddPlacePayload(name,language,address));
	
	
		}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		//this valueof method call the constructor and assign the value to the global variable of that class
	APIResources resourceapi=	APIResources.valueOf(resource);
	System.out.println(resourceapi.getResource());
	if(method.equalsIgnoreCase("POST"))
	{
		//getResource function return the value of resource
		response= res.when().post(resourceapi.getResource());
	
	}
	else if (method.equalsIgnoreCase("GET"))
	{response= res.when().get(resourceapi.getResource());
	//new code from vivek
	System.out.println("printing response"+response.prettyPrint());
	System.out.println("printing lat"+ response.body().path("location.latitude"));
	

		/*
		 * AddPlace ap=res.when().get(resourceapi.getResource()).as(AddPlace.class);
		 * System.out.println(ap.getAccuracy());
		 * System.out.println(ap.getLocation().getLat());
		 */
		
	}
	   
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int Code) {
	assertEquals(response.statusCode(),Code);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
	   
	   assertEquals(getJsonValue(response,key),value);
	   
	}
	
	@Then("verify place_Id created  maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id = getJsonValue(response,"place_id");
	   res= given().spec(requestSpec()).queryParam("place_id", place_id);
	   InputStream schemaStream = getClass().getClassLoader().getResourceAsStream("responseschema.json");
       if (schemaStream == null) {
           throw new RuntimeException("Schema file not found in classpath");
       }
	   user_calls_with_http_request(resource,"GET");
	   response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaStream));
	   //response.then().body("latitude", containsString("latitude"));
	   ///to get the resonse time in milliseconds getTime()
	   long responsetime = response.time();
	   ///to get the response body size in bytes
	  
	   int responsebodysize	= response.getBody().asString().length();
	   int maxAcceptableSize = 5000;
	   System.out.println(responsetime);
	   long MaxAcceptableResponseTime = 2000;
	   assertTrue(responsetime < MaxAcceptableResponseTime);
	   assertTrue(responsebodysize<maxAcceptableSize);
	   //response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\Vivek\\eclipse-workspace\\RestAPIFramework\\src\\test\\resources\\responseschema.json"));
	   String resname=getJsonValue(response,"name");
	   assertEquals(resname,name);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(place_id);
	    res = given().spec(requestSpec()).body(data.deletePayload(place_id));
	    
	}






	
}
