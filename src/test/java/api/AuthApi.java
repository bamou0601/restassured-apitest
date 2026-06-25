package api;

import base.ApiBaseTest;
import constants.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.AllureAttachments;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;

import java.util.Map;


public class AuthApi extends ApiBaseTest {
	
	@Step("ログインAPI実行")
	public Response auth_login(Object request) {
		
		attachRequest(request);
		
		Response response =
				given()
					.contentType("application/json")
					.body(request)
				.when()
					.post(BASE_URL + Endpoints.AUTH_LOGIN);
		
		attachResponse(response);
		 
		 return response;							
	}
	
	@Step("ユーザ情報取得API実行")
	public Response getCurrentUser(
			String token) {
		
		 attachRequest(
		            Map.of("token", token));

		 Response response = given()
				.header(
						"Authorization",
						"Bearer " + token)
		.when()
				.get(BASE_URL + Endpoints.AUTH_ME);
		 
		 
		 attachResponse(response);
		 
		 return response;
	}
	
	@Step("トークン更新API実行")
	public Response refreshToken(
			String refreshToken) {
		
		String requestBody =
	            """
	            {
	                "refreshToken":"%s"
	            }
	            """.formatted(refreshToken);
		
		attachRequest(requestBody);
		
		Response response =
	            given()
	                    .contentType("application/json")
	                    .body(requestBody)
	            .when()
	                    .post(BASE_URL + Endpoints.AUTH_REFRESH);
		
		attachResponse(response);
		
		return response;
							
	}

}
