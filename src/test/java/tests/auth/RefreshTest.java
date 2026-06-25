package tests.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import api.AuthApi;
import assertions.auth.RefreshAssertions;
import base.ApiBaseTest;
import io.restassured.response.Response;
import model.RefreshTestData;
import utils.JsonUtil;

public class RefreshTest extends ApiBaseTest {
	
	static Stream<RefreshTestData> RefreshData() throws Exception {

        RefreshTestData[] data =
                JsonUtil.read(
                        "testdata/auth/refresh-data.json",
                        RefreshTestData[].class);

        return Arrays.stream(data);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("RefreshData")
    void refreshTest(RefreshTestData data) {
    		
    		//debug code
    		//System.out.println("BASE_URL = " + BASE_URL);
   		//System.out.println(System.getProperty("base.url"));

    		// Given
        AuthApi authApi = new AuthApi();
        
        // When
        Response response =
                authApi.auth_login(
                        data.getLogin().getRequest());
        
        assertEquals(
			    data.getLogin()
			        .getExpected()
			        .getStatus(),
			        response.getStatusCode());
        
     // Token取得
		String refreshToken =
				response.jsonPath()
                 	.getString("refreshToken");

		// When
		Response refreshResponse =
				authApi.refreshToken(refreshToken);

		
		refreshResponse.then().log().all();
		
		// Then
		RefreshAssertions.verifyStatusCode(
				refreshResponse, 
				data.getRefresh().getExpected().getStatus());
		
		RefreshAssertions.verifyRefreshResponse(
				refreshResponse, 
				data.getRefresh().getExpected());               
    }   
}
