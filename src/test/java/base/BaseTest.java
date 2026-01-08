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
 * 每个test方法一个driver
 * 并行完全安全
 * 职责：WebDriver初始化/回收
 * 测试级别通用能力（截图、日志以后加）
 * 不允许出现页面细节
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
			//防止截图失败影响测试结束
			System.err.println("Screenshot capture failed: " + e.getMessage());
		}
	}
}
