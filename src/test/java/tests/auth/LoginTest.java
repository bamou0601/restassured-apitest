/**
 * ログイン API テスト
 * ユーザー情報が正しく返されることを検証する
 * 作成者: 馬 猛
 * 作成日: 2026/06/22
 */

package tests.auth;

import base.ApiBaseTest;
import model.LoginTestData;
import utils.JsonUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import api.AuthApi;
import assertions.auth.LoginSuccessfullyAssertions;

import java.util.Arrays;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;


@Epic("API自動化")
@Feature("ログインとTokenの管理")
@Story("ログイン機能のテスト")
@Tag("API")
@Tag("回帰テスト")
public class LoginTest extends ApiBaseTest {

    static Stream<LoginTestData> loginData() throws Exception {

        LoginTestData[] data =
                JsonUtil.read(
                        "testdata/auth/login-data.json",
                        LoginTestData[].class);

        return Arrays.stream(data);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("loginData")
    void loginTest(LoginTestData data) {
    		
    		//debug code
    		//System.out.println("BASE_URL = " + BASE_URL);
   		//System.out.println(System.getProperty("base.url"));

    		// Given
        AuthApi authApi = new AuthApi();
        
        // When
        Response response =
                authApi.auth_login(
                        data.getRequest());
        
       // debug code
       // response.then().log().all();
        
      //then
        LoginSuccessfullyAssertions.verifyStatusCode(
        		response, data.getExpected().getStatusCode());
        
        LoginSuccessfullyAssertions.verifyLoginResponse(
        		response, data.getExpected());
             
    }   
}