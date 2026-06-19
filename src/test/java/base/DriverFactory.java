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
 * 将来的に browser=chrome/firefox などの実行環境切り替えに対応可能
 * Selenium Grid を利用した分散実行にも拡張可能
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
		
		/* ============= headlessモードを実現する ============= */
		private static boolean isHeadless() {
			return Boolean.parseBoolean(
				System.getProperty("headless", "false")
			);
		}
		
		
		
		/* ================= Chrome ================= */
		private static WebDriver createChromeDriver() {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--start-maximized");
			
			if(isHeadless()) {
			    options.addArguments("-headless=new");
			    options.addArguments("--window-size=1920,1080");
			}
			
			return new ChromeDriver(options);
		}
		
		/* ================= Firefox ================= */

	    private static WebDriver createFirefoxDriver() {
	        WebDriverManager.firefoxdriver().setup();

	        FirefoxOptions options = new FirefoxOptions();
	        //options.addArguments("--width=1920", "--height=1080");
	        
	        if(isHeadless()) {
			    options.addArguments("-headless=new");
			    options.addArguments("--window-size=1920,1080");
			}

	        return new FirefoxDriver(options);
	    }

	    /* ================= Edge ================= */

	    private static WebDriver createEdgeDriver() {
	        //WebDriverManager.edgedriver().setup();

	        EdgeOptions options = new EdgeOptions();
	        //options.addArguments("--start-maximized");
	        
	        if(isHeadless()) {
			    options.addArguments("-headless=new");
			    options.addArguments("--window-size=1920,1080");
			}

	        return new EdgeDriver(options);
	    }
}
