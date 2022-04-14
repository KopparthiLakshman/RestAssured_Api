package Learning.apiTesting;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;

public class log_if_only_error {

	
//	@Test
	public void log_if_only_error_method() {
		given().
				baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-62570a58c7b6e906537591c7-c9d9366692510b68dbdfac426c0627c0a2").
//				log().ifValidationFails().
//				config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
				config(config.logConfig(LogConfig.logConfig().blacklistHeader("x-api-key", "Accept"))).
				log().all().
		when().
				get("/workspaces").
		then().
//				log().ifError().
				log().ifError().
				assertThat().
				statusCode(200)
		
		;
	}
	
}
