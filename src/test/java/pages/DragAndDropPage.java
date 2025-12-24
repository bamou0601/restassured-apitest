package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {
	
	private static final String PATH = "/drag_and_drop";
	private final By columnA = By.id("column-a");
	private final By columnB = By.id("column-b");

	@Override
	public String path() {
		return PATH;
	}
	
	//HTML5 Drag & Drop workaround using JS
	public void dragAToB() {	
		WebElement a = driver().findElement(columnA);
		WebElement b = driver().findElement(columnB);
		new Actions(driver()).dragAndDrop(a, b).perform();
	}
	
	//@Step("Verify boxes are swapped")
	public boolean isSwapped() {
		String aHeader = driver().findElement(columnA).getText();
		return "B".equals(aHeader);
	}
	
}
