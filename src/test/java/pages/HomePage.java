package pages;

import base.BasePage;
import org.openqa.selenium.By;
//import utils.WaitUtils;
//utils.WaitUtils don't work any more
public class HomePage extends BasePage {
	
	private static final String PATH = "";
	private By homeMsg = By.cssSelector("h1.heading");

    protected String path() {
    	return PATH;
    }
	
    public boolean openSuccess() {
    	return exists(homeMsg);
    }
	
    public String successMessage() {
    	return text(homeMsg);
    }
}
