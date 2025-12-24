package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	private static final String PATH = "/login";
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    private final By successMsg = By.cssSelector(".flash.success");
    private final By failedMsg = By.id("flash");
    private final By logoutButton = By.cssSelector("a[href='/logout']");
    
    @Override
    protected String path() {
    	return PATH;
    }
    
    public void login(String user, String pwd) {
    	type(username, user);
    	type(password, pwd);
    	click(loginBtn);
    }
    
    public boolean isLoginSuccess() {
    	return exists(logoutButton);
    }
    
    public String successMessage() {
    	return text(successMsg);
    }

    public boolean isLoginFail() {
    	return exists(failedMsg);
    }
    
    public String failedMessage() {
    	return text(failedMsg);
    }

}
