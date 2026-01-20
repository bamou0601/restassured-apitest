package pages;

import org.openqa.selenium.*;
import base.BasePage;


public class DynamicContentPage extends BasePage {
	
	private static final String PATH = "/dynamic_conten";
	private static By clickBtn = By.cssSelector(PATH);
	
	@Override
	public String path() {
		return PATH;
	}
	
	
}
