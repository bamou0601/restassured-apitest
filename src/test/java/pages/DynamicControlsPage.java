package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

public class DynamicControlsPage extends BasePage {
	private static final String PATH = "/dynamic_controls";
	
	/*=============locators===============*/
	private final By checkbox = By.id("checkbox");
	private final By checkboxButton = By.cssSelector("#checkbox-example button");
	private final By input = By.cssSelector("#input-example input");
	private final By inputButton = By.cssSelector("#input-example button");
	private final By message = By.id("message");
	
	@Override
	protected String path() {
		return PATH;
	}
	
	/*=============page actions===============*/
	@Step("Dynamic Controls ページをオープンする")
	public void openPage() {
		open();
	}
	
	/* ---------- Checkbox block ---------- */
	@Step("remove / add ボタンをクリックする")
	public void clickCheckboxButton() {
		click(checkboxButton);
	}
	
	@Step("wait checkbox disappear")
	public void waitCheckboxDisappear() {
		getWait().until(
					ExpectedConditions
					.invisibilityOfElementLocated(checkbox)
					);
	}
	
	@Step("wait checkbox appear")
	public void waitCheckboxAppear() {
		visible(checkbox);
	}
	
	/*===========input block=================*/
	@Step("click Enable / Disable button")
	public void clickInputButton() {
		click(inputButton);
	}
	
	@Step("wait input available")
	public void waitInputEnabled() {
		getWait().until(
				ExpectedConditions
				.elementToBeClickable(input)
		);
	}
	
	@Step("wait input unavialable")
	public void waitInputDisabled() {
		getWait().until(ExpectedConditions.not(
				ExpectedConditions.elementToBeClickable(input)
		));
	}
	
	 /* ========== Common ========== */
	@Step("get remind message")
	public String getMessage() {
		return visible(message).getText();
	}
	
	public boolean isCheckboxPresent() {
		return exists(checkbox);
	}
	
	public boolean isInputEnabled() {
		return driver().findElement(input).isEnabled();
	}

}