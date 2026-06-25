package model;

import lombok.Data;


/**
 * ログインAPIテストデータモデル
 * リクエストと期待値を管理
 * 作成者: 馬 猛
 * 作成日: 2026/06/22
 */

@Data
public class LoginTestData {

    private String name;
    private LoginRequest request;
    private Expected expected;
    
    public String toString() {
    		return name;
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    public static class Expected {
    		private int statusCode;
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String gender;
        private String image;
        private Boolean accessToken;
        private Boolean refreshToken;
    }
    
    // リクエスト取得
    public LoginRequest getRequest() {
        return request;
    }
    
    // 期待値取得
    public Expected getExpected() {
        return expected;
    } 
}
