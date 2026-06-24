package tests.auth;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import model.MeTestData;
import utils.JsonUtil;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import api.AuthApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Token の再利用テスト
 * 
 * シナリオ:
 * 1. ログイン API でユーザー認証を行い、Token を取得する
 * 2. 取得した Token を Bearer 認証ヘッダーに設定
 * 3. 認可が必要な /auth/me エンドポイントを呼び出し
 * 4. ユーザー情報が正しく返されることを検証する
 * 作成者: 馬 猛
 * 作成日: 2026/06/19
 */
@Epic("API自動化")
@Feature("ログインとTokenの管理")
@Story("Token再利用のテスト")
@Tag("API")
@Tag("回帰テスト")
public class MeTest {

    static Stream<MeTestData> loginData() throws Exception {

    		MeTestData[] data =
                JsonUtil.read(
                        "testdata/auth/me-data.json",
                        MeTestData[].class);

        return Arrays.stream(data);
    }
	
    void loginTest(MeTestData data) {
    		
    		// Given
    		AuthApi authApi = new AuthApi();

    		// Login
    		Response loginResponse =
    				authApi.auth_login(
    						data.getLogin().getRequest());

    		// Token取得
    		String accessToken =
    				loginResponse.jsonPath()
                     	.getString("accessToken");

    		// When
    		Response meResponse =
    				authApi.getCurrentUser(accessToken);

    		// Then
    		assertEquals(
    				data.getMe().getExpected().getStatus(),
    				meResponse.getStatusCode());

    		assertEquals(
    				data.getMe().getExpected().getUsername(),
    				meResponse.jsonPath().getString("username"));

    		assertEquals(
    				data.getMe().getExpected().getGender(),
    				meResponse.jsonPath().getString("gender"));
    }
}
