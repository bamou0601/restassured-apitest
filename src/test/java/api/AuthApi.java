package api;

import base.ApiBaseTest;
import constants.Endpoints;
import model.LoginTestData;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class AuthApi extends ApiBaseTest {
	
	public Response auth_login(
			LoginTestData.Request request) {
		
		return given()
				.contentType("application/json")
				.body(request)
		.when()
				.post(BASE_URL + Endpoints.AUTH_LOGIN);
							
	}
	
	public Response getCurrentUser(
			String token) {
		
		return given()
				.header(
						"Authorization",
						"Bearer " + token)
		.when()
				.post(BASE_URL + Endpoints.AUTH_ME);
							
	}
	
	public Response refreshToken(
			String token) {
		
		return given()
				.header(
						"Authorization",
						"Bearer " + token)
		.when()
				.post(BASE_URL + Endpoints.AUTH_REFRESH);
							
	}

}
