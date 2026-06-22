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
    private Request request;
    private Expected expected;

    @Data
    public static class Request {
        private String username;
        private String password;
    }

    @Data
    public static class Expected {
    		private int statusCode;
        private String username;
        private Boolean tokenExists;
    }
    
    // リクエスト取得
    public Request getRequest() {
        return request;
    }
    
    // 期待値取得
    public Expected getExpected() {
        return expected;
    } 
}
