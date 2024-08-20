package resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utilities {
	static RequestSpecification res;
	public RequestSpecification requestSpec() throws IOException
	{
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		if(res==null)
		{
		PrintStream ps= new PrintStream(new FileOutputStream("logging.txt"));
		res = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURI")).addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				.setContentType(ContentType.JSON).build();
		return res;
		}
		return res;
	}
	public String getGlobalValues(String Key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Vivek\\eclipse-workspace\\RestAPIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(Key);
	}
	public String getJsonValue(Response response, String Key)
	{
		String res=response.asString();
		JsonPath js=new JsonPath(res);
		return  (js.get(Key).toString());
	}

}
