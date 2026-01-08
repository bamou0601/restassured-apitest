package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ImageApiClient {
	
	public static Response getImage(String imageUrl) {
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.when()
				.get(imageUrl)
				.andReturn();
	}
}
