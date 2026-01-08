package pages;

import base.BasePage;
import org.openqa.selenium.By;
import java.util.List;

public class ChallengingDomPage extends BasePage {
	
	private static final String PATH = "/challenging_dom";
	
	/* ================= URL ================= */
	@Override
	protected String path() {
		return PATH;
	}
	
	/* ================Locators ================= */
	//three buttons:by data-testid + tag combination （more stable than class）
	private final By buttons = By.cssSelector(".large-2.columns a");
	
	//form
	private final By tableRows = By.cssSelector("table tbody tr");
	private final By tableHeaders = By.cssSelector("table thead th");
	
	/* ===============page actions ================= */
	//click the nth button
	public void clickButton(int index) {
		findAll(buttons).get(index).click();
	}
	
	//return the count of buttons
	public int buttonCount() {
		return findAll(buttons).size();
	}
	
	// the rows' number of form
	public int rowCount() {
		return findAll(tableRows).size();
	}
	
	//headers of form
	public List<String> getHeaderTexts() {
		return findAll(tableHeaders)
				.stream()
				.map(e -> e.getText().trim())
				.toList();
	}
	
	//click the wanted row's edit
	public void clickEdit(int rowIndex) {
		By edit = By.cssSelector(
			"table tbody tr:nth-child(" 
			+ (rowIndex + 1) 
			+ ") a[href*='edit']"
		);
	}
	
	//click the wanted row's delete
	public void clickDelete(int rowIndex) {
		By delete = By.cssSelector(
			"table tbody tr:nth-child("
			+ (rowIndex + 1)
			+ ") a[href*='delete']"
		);
	}
}
