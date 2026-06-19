package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
/*
 * Pageにはprivate WebDriver driver存在しないよう
 * いつもDriverManagerを通して取得
 * 責務：
 * 管理 driver
 * 管理 wait
 * 提供 UI DSL（click / type / text / exists）
 * open() の通用実現を提供（なお、具体的なURLを知らない）
 * 
 */
public abstract class BasePage {
	
	/* ===================== Driver ===================== */
	protected WebDriver driver() {
		return DriverManager.getDriver();
	}
	
	/* ====================== URL  ====================== */
	protected abstract String path();
	
	public void open() {
		//BasePageはbaseUrlがどこか来るのが知らないが、存在だけを要求
		String baseUrl = System.getProperty("base.url");
		if(baseUrl == null) {
			throw new IllegalStateException("base.url is not set");
		}
		driver().get(baseUrl + path());
	}
	
	/* ================== Wait Strategy ================= */
	private static final long DEFAULT_WAIT = 10;
	
	protected WebDriverWait getWait() {
	    return getWait(DEFAULT_WAIT);
	}

	protected WebDriverWait getWait(long seconds) {
	    return new WebDriverWait(driver(), Duration.ofSeconds(seconds));
	}

	/* ==================== Core Find ==================== */
	protected WebElement find(By locator) {
		return getWait().until(
				ExpectedConditions
				.presenceOfElementLocated(locator));
	}
	
	protected WebElement visible(By locator) {
	    return getWait().until(
	    		ExpectedConditions
	    		.visibilityOfElementLocated(locator));
	}
	
	protected WebElement clickable(By locator) {
		return getWait().until(
				ExpectedConditions
				.elementToBeClickable(locator));
	}
	
	protected List<WebElement> findAll(By locator) {
		return getWait().until(
			ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
		);
	}
	
	/* ================== Business Actions ================== */
	protected void click(By locator) {
		clickable(locator).click();
	}
	
	protected void type(By locator, String text) {
		WebElement el = visible(locator);
		el.clear();
		el.sendKeys(text);
	}
	
	protected String text(By locator) {
		return visible(locator).getText();
	}
	
	protected boolean exists(By locator) {
		try {
			find(locator);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

}
