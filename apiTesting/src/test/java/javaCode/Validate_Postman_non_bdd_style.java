package javaCode;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Validate_Postman_non_bdd_style {
	@Test
	public void Validate_Postman_non_bdd_style_1() {
		String payload = "{    \"workspace\": \r\n"
				+ "        {\r\n"
				+ "            \"name\": \"Workspace_Post_eclipse\",\r\n"
				+ "            \"type\": \"personal\",\r\n"
				+ "            \"description\" : \"Creating Workspace with api request\"\r\n"
				+ "        }\r\n"
				+ "}";
		with().
				baseUri(payload).post("/workspaces").
		then().
				log().all();
					
		
		
		
	}
}
