package base;

import org.openqa.selenium.WebDriver;

/*
 * ThreadLocal 
 * 线程隔离 
 * 并行必备
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
