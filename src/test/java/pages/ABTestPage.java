package pages;

import base.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

public class ABTestPage extends BasePage {
	
	/* =============== Locators =============== */
	private static final String PATH = "/abtest";
	private By title = By.tagName("h3");
    
	/* =============== URL =============== */
	@Override
    protected String path() {
    	return PATH;
    }
	
	/* ============ Page Semantics =========== */
	/*whether page title displayed*/
    public boolean isTitleDisplayed() {
    	return exists(title);
    }
    
    /* タイトルのテキストを取得する */
    public String getTitleText() {
    	return text(title);
    }

    /* タイトルが有効なA/Bテストタイトルであるかを判定する */
    public boolean hasValidABTestTitle() {
        Set<String> expectedTitles = Set.of(
                "A/B Test Control",
                "A/B Test Variation 1"
        );
        return expectedTitles.contains(getTitleText());
    }
}
