package pages;

import base.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BrokenImagesPage extends BasePage {
	
	private final By images = By.tagName("img");
	private final static String PATH = "/broken_images";
	
	@Override
	protected String path() {
		return PATH;
	}
	
	/*==============page actions==============*/
	@Step("打开Broken imamges页面")
	public void openPage() {
		open();
	}

	 /* ==================== Elements ==================== */
	public List<WebElement> getAllImages() {
		//return driver().findElements(images);
		return getWait().until(
			ExpectedConditions.presenceOfAllElementsLocatedBy(images)
		);
	}
	
	/* ==================== Business Logic ==================== */
	/**
     * use JS to judge whetheer img broken
     * isDisplayed forbidden
     */
	@Step("获取图片URL")
	public String getImageUrl(WebElement img) {
		//return img.getAttribute("src");
		String url = img.getAttribute("src");
		Allure.addAttachment("Image URL", url);
		return url;
	}
	
	@Step("检查图片是否加载出来")
	public boolean isImageRendered(WebElement img) {
		return (Boolean)((JavascriptExecutor) driver())
				.executeScript(
						"return arguments[0].complete && arguments[0].naturalWidth > 0;", 
						img
				);
	}
	
}


