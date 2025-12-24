package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

public class AllureUtils {
	
	@Attachment(value = "Step Screenshot", type = "image/png")
	public static byte[] captureStep(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	
	
	
	
	
}
