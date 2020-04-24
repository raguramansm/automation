package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commonFunctions.CommonFunc;
import pageObjects.ClpPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.PdpPageObjects;

public class TestSignIn extends CommonFunc{	
	
	@Test
	public void verifySignIn() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		PageFactory.initElements(driver, HomePageObjects.class); //To populate the web elements from the class file HomePageObjects
		System.out.println("Entering into VerifySignIn test case");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		HomePageObjects.containerButton.click();
		HomePageObjects.signInHome.click();
		HomePageObjects.username.sendKeys(prop.getProperty("username"));
		HomePageObjects.password.sendKeys(prop.getProperty("password"));
		HomePageObjects.signInButton.click();

		System.out.println("VerifySignIn test case is validated successfully");
	}
	
}
