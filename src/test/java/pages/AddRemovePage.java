package pages;

import org.openqa.selenium.By;
import base.BasePage;

public class AddRemovePage extends BasePage {

	private static final String PATH = "/add_remove_elements/";
	
	/*============ locators ================*/
	private final By addBtn = By.xpath("//button[text()='Add Element']");
	private final By deleteBtns = By.cssSelector("button.added-manually");
	
	/*============ URL ================*/
	@Override
	public String path() {
		return PATH;
	}
	//actions
	public void addElement() {
		click(addBtn);
	}
	
	public void deleteFirstBtn() {
		click(deleteBtns);
	}
	
	//assertions
	public boolean hasDeleteButton() {
		return exists(deleteBtns);
	}
	
	public int deleteButtonCount() {
		return driver().findElements(deleteBtns).size();
	}
}
