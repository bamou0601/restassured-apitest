package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/*
 * 这里可以加 browser=chrome/firefox
 * 也可以支持 Selenium Grid
 */
public class DriverFactory {
	
	public static WebDriver createDriver() {
		BrowserType browser = resolveBrowser();
		
		return switch(browser) {
			case FIREFOX -> createFirefoxDriver();
			case EDGE -> createEdgeDriver();
			default -> createChromeDriver();
		};
	}		
		/* ============= Browser Resolver ============= */	
		private static BrowserType resolveBrowser() {
			String browserName = System.getProperty("browser", "CHROME").toUpperCase();
			
			try {
				return BrowserType.valueOf(browserName);
			} catch(IllegalArgumentException e) {
				throw new RuntimeException(
						"Unsupported browser:" + browserName +
						" (Supported: CHROME, FIREFOX, EDGE)"
				);
			}
		}
		
		/* ================= Chrome ================= */
		private static WebDriver createChromeDriver() {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--start-maximized");
			return new ChromeDriver(options);
		}
		
		/* ================= Firefox ================= */

	    private static WebDriver createFirefoxDriver() {
	        WebDriverManager.firefoxdriver().setup();

	        FirefoxOptions options = new FirefoxOptions();
	        //options.addArguments("--width=1920", "--height=1080");

	        return new FirefoxDriver(options);
	    }

	    /* ================= Edge ================= */

	    private static WebDriver createEdgeDriver() {
	        //WebDriverManager.edgedriver().setup();

	        EdgeOptions options = new EdgeOptions();
	        //options.addArguments("--start-maximized");

	        return new EdgeDriver(options);
	    }
}
