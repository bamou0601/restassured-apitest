package base;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
/*
 * 各テストメソッドで専用のWebDriverインスタンスを使用する。
 * 並列実行時のスレッドセーフ性を保証する。
 *
 * 主な責務：
 * - WebDriverの生成
 * - WebDriverの終了処理
 *
 * テスト共通機能（スクリーンショット取得、ログ出力など）は
 * 今後ここに追加する。
 *
 * ページ固有の操作や要素定義は含めない。
 */
@ExtendWith(FailureWatcher.class)
public abstract class BaseTest {
	
	@BeforeEach
	void setup() {
		DriverManager.setDriver(DriverFactory.createDriver());	
	}
	
	@AfterEach
	void tearDown() {
		try {
			attachScreenshotOnFailure();
		} finally {
			TestContextHolder.clear();
			DriverManager.quitDriver();
		}	
	}
	
    private void attachScreenshotOnFailure() {
		Throwable error = TestContextHolder.getThrowable();
		if (error == null) return; 
		
		try {
			TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			
			Allure.addAttachment(
					"Failure Screenshot - " + Thread.currentThread().getName(), 
					"image/png",
					new ByteArrayInputStream(screenshot),
					".png"
			);		
		} catch (Exception e) {
			// スクリーンショット取得に失敗してもテスト終了処理は継続する
			System.err.println("Screenshot capture failed: " + e.getMessage());
		}
	}
}
