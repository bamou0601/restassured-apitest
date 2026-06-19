package tests.auth;

import base.ApiBaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("API自動化")
@Feature("ログインとtokenの管理")
@Story("ログイン機能のテスト")
@Tag("API")
@Tag("回帰テスト")
public class AuthLogin {
	
	// テスト対象 API のベース URL
    private static final String BASE_URL = "https://dummyjson.com";
    
	@Test
	@Description("正常系ログイン")
	void LoginSuccessfully() {
		String requestBody = """
		        {
		            "username":"emilys",
		            "password":"emilyspass"
		        }
		        """;
		given()
			.contentType("application/json")
			.body(requestBody)
	   .when()
			.post(BASE_URL + "/auth/login")
	   .then()
			.statusCode(200)
			.body("username", equalTo("emilys"))
			.body("token", notNullValue())
			.body("refreshToken", notNullValue());			
	}
	
	
	@Test
	@Description("異常系ログイン")
	void LoginFailed() {
		
		String requestBody = """
		        {
		            "username":"wrong",
		            "password":"wrong"
		        }
		        """;
		given()
		.contentType("application/json")
		.body(requestBody)
	.when()
		.post(BASE_URL + "/auth/login")
	.then()
		.statusCode(400);
	}
}
