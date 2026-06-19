package tests.auth;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
public class AuthMe {

    // テスト対象 API のベース URL
    private static final String BASE_URL = "https://dummyjson.com";

    @Test
    @Description("Token を取得後、再利用して認可付きリクエストを実行")
    void testReuseToken() {
        // Step 1: ログイン API にてユーザー認証し Token を取得
        String token = 
        		given()
        			.contentType("application/json")
        			.body("""
                {
                    "username": "emilys",
                    "password": "emilyspass"
                }	
                """)
            .when()
               .post(BASE_URL + "/auth/login")
            .jsonPath()
                .getString("token");

        // Step 2: 取得した Token を Bearer 認証ヘッダーに設定して /auth/me にアクセス
        given()
            .header("Authorization", "Bearer " + token)
       .when()
            .get(BASE_URL + "/auth/me")
       .then()
            .statusCode(200)
            .body("username", equalTo("emilys"));
    }
}
