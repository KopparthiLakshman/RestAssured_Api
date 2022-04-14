package Learning.apiTesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


// this will create workspace and delete the workspace also
public class Validate_Postman_non_bdd_style {

	@BeforeClass
	public void beforeClass(){

		RequestSpecBuilder rsb = new RequestSpecBuilder();
					rsb.setBaseUri("https://api.postman.com").
					addHeader("x-api-key", "PMAK-62570a58c7b6e906537591c7-c9d9366692510b68dbdfac426c0627c0a2").
					setContentType(ContentType.JSON).
					log(LogDetail.ALL);

		RestAssured.requestSpecification = rsb.build();

		ResponseSpecBuilder responseSB = new ResponseSpecBuilder();
		responseSB.expectStatusCode(200).
		expectContentType(ContentType.JSON).
		log(LogDetail.ALL);
		
		RestAssured.responseSpecification = responseSB.build();

		
	}

	@Test
	public void Validate_Postman_non_bdd_style_1() {
		String payload = "{\"workspace\": \r\n"
				+ "        {\r\n"
				+ "            \"name\": \"Work2_eclipse2\",\r\n"
				+ "            \"type\": \"personal\",\r\n"
				+ "            \"description\" : \"Creating Workspace with api request\"\r\n"
				+ "        }\r\n"
				+ "}";

		System.out.println(payload);
	
		
		Response res = 	with().
								body(payload).post("/workspaces").
						then().
								extract().response();
		
		String id =JsonPath.from(res.asString()).get("workspace.id");
		
		System.out.println(id+"  :: id of the workspace");
		
// Deletion of created workspace
		delete_workspace_Created_In_Above_method(id);
	}
	
	
	public void delete_workspace_Created_In_Above_method(String id) {

		String deleteWorkspace=id;
		with().
			  delete("/workspaces/"+deleteWorkspace).
		then().
				log().all();
	}

}
