package pages.dropdown;

import base.BasePage;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
	
	private static final String PATH = "/dropdown";
	private static By dropdown = By.id("dropdown"); 
	
	@Override
	protected String path() {
		return PATH;
	}
	
	/*============page actions=============*/
	
	@Step("打开dropdown页面")
	public void openPage() {
		open();
	}
	
	@Step("选择下拉菜单: {option}")
	public void selectByVisibleText(DropdownOption option) {
		new Select(find(dropdown))
				.selectByVisibleText(option.text());
	}
	
	@Step("获取当前下拉菜单选项")
	public DropdownOption selectedOption() {
		String text = new Select(find(dropdown))
				.getFirstSelectedOption()
				.getText();
		return DropdownOption.fromText(text);
	}
	
	@Step("获取下拉菜单文本")
	public String selectedOptionText() {
		return new Select(find(dropdown))
				.getFirstSelectedOption()
				.getText();
	}
	
	@Step("验证已选择项目是{option}")
	public boolean isSelected(DropdownOption option){
		return selectedOption() == option;
	}
}
