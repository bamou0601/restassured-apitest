package base;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 这里可以加 browser=chrome/firefox
 * 也可以支持 Selenium Grid
 */
public class DriverFactory {
	
	public static WebDriver createDriver() {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		return driver;
	}	

}
