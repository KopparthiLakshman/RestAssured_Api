package Learning.apiTesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class log_if_only_error {

	
	@Test
	public void log_if_only_error_method() {
		given().
				baseUri("")
		
		.when()
		.then();
	}
	
}
