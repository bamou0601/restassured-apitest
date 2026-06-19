package base;

import org.openqa.selenium.WebDriver;

/*
 * ThreadLocal を利用してWebDriverをスレッド単位で管理する
 * 各テストが独立したDriverを使用できるため、
 * 並列実行時の競合を防止できる
 */
public class DriverManager {
	
	private static final ThreadLocal<WebDriver> DRIVER =
			new ThreadLocal<>();
	
	public static void setDriver(WebDriver driver) {
		DRIVER.set(driver);
	}
	
	public static WebDriver getDriver() {
		return DRIVER.get();
	}
	
	public static void quitDriver() {
		WebDriver driver = DRIVER.get();
		if(driver != null) {
			driver.quit();
			DRIVER.remove();			
		}
	}
}
