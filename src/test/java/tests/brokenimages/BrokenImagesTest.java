package tests.brokenimages;

import api.ImageApiClient;
import base.BaseTest;
import pages.BrokenImagesPage;
import utils.ImageCheckResult;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

import io.qameta.allure.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("Static Resources")
@Story("Broken Images Detection")
@Tag("smoke")
public class BrokenImagesTest extends BaseTest {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Detect broken images using JavaScript naturalWidth strategy")
	void detectBrokenImages_UIandAPI() {
		
		BrokenImagesPage page = new BrokenImagesPage();
		page.openPage();
		
		List<ImageCheckResult> results = new ArrayList<>();
		
		for(WebElement img : page.getAllImages()) {
			
			String url = page.getImageUrl(img);
			Boolean uiOK = page.isImageRendered(img);
			
			int statusCode = ImageApiClient
					.getImage(url)
					.getStatusCode();
			
			results.add(new ImageCheckResult(url, uiOK, statusCode));
		}
		
		//pull asserts together
		List<ImageCheckResult> broken = results.stream()
				.filter(r -> !r.isHealthy())
				.toList();
		
		assertFalse(
				broken.isEmpty(),
				"Broken images found:" + broken.stream()
						.map(r -> r.url + " | ui=" + r.uiOK + " | status=" + r.statusCode)
						.toList()
				);	
	}
}
