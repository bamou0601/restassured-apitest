package base;

import utils.AllureAttachments;
import utils.ConfigReader;
import utils.JsonUtil;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.response.Response;

/**
 * APIテスト共通基盤クラス
 *
 * 全APIテストで共通利用する設定やベース情報を管理する。
 * 主な役割:
 * - APIのベースURL管理
 * - 共通設定（必要に応じてRestAssured初期化など）
 * ※現在はConfigReaderからBASE_URLを取得して利用
 * 作成者: 馬 猛
 * 作成日: 2026/06/22
 */

public class ApiBaseTest {
	
//	@BeforeAll
//	static void setup() {
//		RestAssured.baseURI = System.getProperty("base.url");;
//	}
	
	protected static final String BASE_URL = ConfigReader.getBaseUrl();
	
	protected void attachRequest(Object request) {

        AllureAttachments.attachRequest(
                JsonUtil.toJson(request));
    }

    protected void attachResponse(Response response) {

        AllureAttachments.attachResponse(response);
    }

}
