package api;

import base.ApiBaseTest;
import constants.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.AllureAttachments;

import static io.restassured.RestAssured.given;


public class AuthApi extends ApiBaseTest {
	
	@Step("ログインAPI実行")
	public Response auth_login(Object request) {
		
//		AllureAttachments.attachRequest(
//                JsonUtil.toJson(request));
		
		Response response =
				given()
					.contentType("application/json")
					.body(request)
				.when()
					.post(BASE_URL + Endpoints.AUTH_LOGIN);
		
//		AllureAttachments.attachResponse(response);
		 
		 return response;							
	}
	
	@Step("ユーザ情報取得API実行")
	public Response getCurrentUser(
			String token) {
		
		return given()
				.header(
						"Authorization",
						"Bearer " + token)
		.when()
				.get(BASE_URL + Endpoints.AUTH_ME);
							
	}
	
	@Step("トークン更新API実行")
	public Response refreshToken(
			String refreshToken) {
		
		return given()
				.contentType("application/json")
				.body("""
					{
						
						"refreshToken": "%s"
					}
					""".formatted(refreshToken))
		.when()
				.post(BASE_URL + Endpoints.AUTH_REFRESH);
							
	}

}
