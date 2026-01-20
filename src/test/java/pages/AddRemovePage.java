package pages;

import org.openqa.selenium.By;
import base.BasePage;
import io.qameta.allure.*;

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
	
	@Step("打开add_remove_elements页面")
	public void openPage() {
		open();
	}
	//actions
	@Step("点击add按钮添加元素")
	public void addElement() {
		click(addBtn);
	}
	
	@Step("点击删除按钮删除元素")
	public void deleteFirstBtn() {
		click(deleteBtns);
	}
	
	//assertions
	@Step("判断被删除元素是否存在")
	public boolean hasDeleteButton() {
		return exists(deleteBtns);
	}
	
	@Step("统计被删除元素剩余数量")
	public int deleteButtonCount() {
		return driver().findElements(deleteBtns).size();
	}
}
