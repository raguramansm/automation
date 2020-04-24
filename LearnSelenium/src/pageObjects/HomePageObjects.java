package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {

	@FindBy(xpath="//div[@id='onetrust-close-btn-container']/button")
	public static WebElement containerButton;
	
	@FindBy(xpath="//a[text()='Sign In']")
	public static WebElement signInHome;
	
	@FindBy(id="marSigninEmail")
	public static WebElement username;
	
	@FindBy(id="marSigninPassword")
	public static WebElement password;
	
	@FindBy(xpath="//input[@value='Sign In']")
	public static WebElement signInButton;
	
	@FindBy(xpath="//a[@title='clothes']")
	public static WebElement clothes;	
	
	@FindBy(className = "asc-global-indicator show")
	public static WebElement visible;
}
