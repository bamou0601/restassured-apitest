package extensions;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.*;

public class ScreenshotWatcher implements TestWatcher {
	
	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		WebDriver driver = DriverExtension.getDriver();
		if(driver != null) {
			attachFailureScreenshot(driver);
		}
		DriverExtension.quitDriver();
	}
	
	@Attachment(value = "Failure Screenshot", type = "image/png")
	public byte[] attachFailureScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
		
}
	
