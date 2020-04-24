package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PdpPageObjects {
	
	@FindBy(id="jst-prod-size-15045339")
	public static WebElement selectSize;
	
	@FindBy(id="addToBagButtonWrapper")
	public static WebElement addToBag;

}
