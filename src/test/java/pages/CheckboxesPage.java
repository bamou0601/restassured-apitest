package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePage {
	
	private static final String PATH = "/checkboxes";
	
	 /* ========== Locators ========== */
	private final By checkboxes = By.cssSelector("#checkboxes input[type= 'checkbox']");
	
	@Override
	protected String path() {
		return PATH;
	}
	
	/* ========== page actions ========== */
	public int checkboxCount() {
		return findAll(checkboxes).size();
	}
	
	public boolean isChecked(int index) {
		return getCheckbox(index).isSelected();
	}
	
	public void check(int index) {
		WebElement cb = getCheckbox(index);
		if(!cb.isSelected()) {
			cb.click();
		}
	}
	
	public void uncheck(int index) {
		WebElement cb = getCheckbox(index);
		if(cb.isSelected()) {
			cb.click();
		}
	}
	
	/* ========== Internal Helper ========== */
	private WebElement getCheckbox(int index) {
		List<WebElement> list = findAll(checkboxes);
		if (index < 0 || index >= list.size()) {
			throw new IllegalArgumentException("Checkinbox index out of range: " + index);
		}
		return list.get(index);
	}
	
	
}
