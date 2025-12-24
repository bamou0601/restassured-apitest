package extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverExtension implements BeforeEachCallback,
										AfterEachCallback,
										ParameterResolver {
	
	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
	
	@Override
	public void beforeEach(ExtensionContext context) {
		WebDriverManager.chromedriver().setup();
		DRIVER.set(new ChromeDriver());
	}
	
	@Override
	public void afterEach(ExtensionContext context) {
		
	}
	
	public static void quitDriver() {
		WebDriver driver = DRIVER.get();
		if(driver != null) {
			driver.quit();
			DRIVER.remove();
		}
	}
	
	@Override
	public boolean supportsParameter(ParameterContext pc, ExtensionContext ec) {
		return pc.getParameter().getType() == WebDriver.class;
	}
	
	@Override
	public Object resolveParameter(ParameterContext pc, ExtensionContext ec) {
		return DRIVER.get();
	}
	
	public static WebDriver getDriver() {
		return DRIVER.get();
	}
		
}
