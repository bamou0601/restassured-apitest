package assertions.auth;

import io.restassured.response.Response;
import model.MeTestData;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MeAssertions {
	
	public static void verifyStatusCode(
			Response response,
			int expectedStatusCode) {
		
		assertEquals(
				expectedStatusCode,
				response.getStatusCode());
		
	}
	
	public static void verifyMeResponse(
			Response response,
			MeTestData.MeExpected expected) {
		//assertAllを使って、すべての期待値を判断する
		assertAll(
    			() -> assertEquals(
    					expected.getUsername(),
                        response.jsonPath()
                                .getString("username")),
    			
    			() -> assertEquals(
    					expected.getGender(),
                        response.jsonPath().getString("gender"))		
    		);		
	}
}
