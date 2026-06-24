package assertions.auth;

import io.restassured.response.Response;
import model.LoginTestData;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginSuccessfullyAssertions {
	
	public static void verifyStatusCode(
			Response response,
			int expectedStatusCode) {
		
		assertEquals(
				expectedStatusCode,
				response.getStatusCode());
		
	}
	
	public static void verifyLoginResponse(
			Response response,
			LoginTestData.Expected expected) {
		//assertAllを使って、すべての期待値を判断する
		assertAll(
    			() -> assertEquals(
    					expected.getUsername(),
                        response.jsonPath()
                                .getString("username")),
    			
    			() -> assertEquals(
    					expected.getEmail(),
                        response.jsonPath()
                                .getString("email")),
    			
    			() -> assertEquals(
    					expected.getFirstName(),
                        response.jsonPath().getString("firstName")),
    			
    			
    			() -> assertEquals(
    					expected.getLastName(),
                        response.jsonPath().getString("lastName")),
    			
    			() -> assertEquals(
    					expected.getGender(),
                        response.jsonPath().getString("gender")),
    			
    			() -> assertEquals(
    					expected.getImage(),
                        response.jsonPath().getString("image"))
    		);
		
		if(Boolean.TRUE.equals(expected.getAccessToken())) {
			assertNotNull(
                    response.jsonPath().getString("accessToken"));
		}
			
		if(Boolean.TRUE.equals(expected.getRefreshToken())) {
    			assertNotNull(
    					response.jsonPath().getString("refreshToken"));
    		}
		
	}
}
