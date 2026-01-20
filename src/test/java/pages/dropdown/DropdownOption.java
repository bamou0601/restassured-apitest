package pages.dropdown;

import java.util.Arrays;

public enum DropdownOption {
	OPTION_1("Option 1"),
	OPTION_2("Option 2");
	
	private final String visibleText;
	
	DropdownOption(String visibleText) {
		this.visibleText = visibleText;
	}
	
	public String text() {
		return visibleText;
	}
	
	public static DropdownOption fromText(String text) {
		return Arrays.stream(values())
				.filter(o -> o.text().equals(text))
				.findFirst()
				.orElseThrow(() -> 
					new IllegalArgumentException("Unknown option: "+ text));
	}

}
