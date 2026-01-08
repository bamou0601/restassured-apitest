package tests.api;

import base.ApiBaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("Web UI Automation")
@Feature("authenticate and security")
@Story("unpredicted Dom")
@Tag("smoke")
@Tag("api")
public class BasicAuthTest extends ApiBaseTest {
	
	@Test
	void basicAuthSuccessWithCredentials() {
		
		given()
			.auth().preemptive().basic("admin", "admin")
		.when()
			.get("/basic_auth")
		.then()
			.statusCode(200)
			.body(containsString(
				"Congratulations! You must have the proper credentials."
			));
	
	}
	
	@Test
	void basicAuthFailWithWrongCredentials() {

	    given()
	        .auth().preemptive().basic("admin", "wrong")
	    .when()
	        .get("/basic_auth")
	    .then()
	        .statusCode(401);
	}
}
