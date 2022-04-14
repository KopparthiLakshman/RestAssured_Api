package Learning.apiTesting;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.Matchers.*;

public class Sample_request {

//	@Test
	public void get_request() {
		given().
				baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-62570a58c7b6e906537591c7-c9d9366692510b68dbdfac426c0627c0a2").
		when().
				get("/workspaces").
		then().
				log().all().
				assertThat().
				statusCode(200);
		
	}
	
//	@Test
	public void response_Validation_Hamcrest() {
		given().
				baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-62570a58c7b6e906537591c7-c9d9366692510b68dbdfac426c0627c0a2").
		when().
				get("/workspaces").
		then().
				log().all().
				assertThat().
				statusCode(200).
				body("workspaces.name", hasItems("My Workspace", "Api_Testing_Workspace", "Workspace_Post") 
					,"workspaces.name[0]", equalTo("My Workspace")
					, "workspaces.size()", equalTo(3)
					,"workspaces.name", hasItem("My Workspace")	
						);
		
	}

	@Test
	public void response_Extract_JsonPath_Hamcrest_Assertion() {
		Response response =  given().
				baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-62570a58c7b6e906537591c7-c9d9366692510b68dbdfac426c0627c0a2").
		when().
				get("/workspaces").
		then().
//				log().all().
				assertThat().
				statusCode(200).extract().response();
		
		System.out.println("Extracting from JsonPath :"+JsonPath.from(response.asString()).get("workspaces.name[0]"));
//		ResponseBody body = response.getBody();
//		System.out.println(body.asString());
	}
	
	
}
