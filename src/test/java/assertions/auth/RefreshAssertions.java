package assertions.auth;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.restassured.response.Response;
import model.RefreshTestData;

public class RefreshAssertions {

	public static void verifyStatusCode(
			Response response,
			int expectedStatusCode) {
		
		assertEquals(
				expectedStatusCode,
				response.getStatusCode());
		
	}
	
	public static void verifyRefreshResponse(
			Response response,
			RefreshTestData.RefreshExpected expected) {
		//assertAllを使って、すべての期待値を判断する
		assertAll(
    			() -> {
    					if(Boolean.TRUE.equals(expected.getAccessToken())) {
    						assertNotNull(
    			                    response.jsonPath().getString("accessToken"));
    					}
    				}, 	
    			
    			() -> {
    					if(Boolean.TRUE.equals(expected.getRefreshToken())) {
			    			assertNotNull(
			    					response.jsonPath().getString("refreshToken"));
			    		}
    				}	
		);
	}
}	
