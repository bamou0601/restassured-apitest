package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DigestAuthPage extends BasePage {
	
	private static final String PATH = "/digest_auth";	
	private final By successMsg = By.cssSelector("div.example p");
	
	@Override
	protected String path() {
		return PATH;
	}
	
	@Step("use Digest Auth to login(username: {username}, password: {password})")
	public void openWithAuth(String username, String password) {
		String baseUrl = System.getProperty("base.url");
		if(baseUrl == null) {
			throw new IllegalStateException("base.url is not set");
		}
		
		//https://user:pass@host/path
		String authUrl = baseUrl.replace("https://", 
				"https://" + username + ":" + password + "@");
		
		driver().get(authUrl + path());
	}
	
	@Step("get success message of succeding auth")	
	public String getSuccessMsg() {
		return text(successMsg);
	}	
}


