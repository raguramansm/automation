package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunc;
import pageObjects.ClpPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.PdpPageObjects;

public class TestAddToCart extends CommonFunc{
	
	public static WebDriver driver=null;
	
	public void clickCatagory()
	{
		PageFactory.initElements(driver, HomePageObjects.class);
		WebDriverWait wait = new WebDriverWait (driver,20);
		boolean invisble = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("asc-global-indicator show")));
		if (invisble)
		{
			HomePageObjects.clothes.click();
		}		
	}
	
	public void selectProduct()
	{
		PageFactory.initElements(driver, ClpPageObjects.class);
		ClpPageObjects.selectProduct.click();
	}
	
	public void selectSize()
	{
		PageFactory.initElements(driver, PdpPageObjects.class);
		Select size=new Select(PdpPageObjects.selectSize);
		size.selectByValue("8");		
	}
	
	public void addtoBag()
	{
		PageFactory.initElements(driver, PdpPageObjects.class);
		PdpPageObjects.addToBag.click();
	}
	
	@Test 
	public void verifyAddToCart()
	{
		System.out.println("Entering into VerifyAddToCart test case");
		String title = driver.getTitle();
		System.out.println(title);
		clickCatagory();
		selectProduct();
		selectSize();
		addtoBag();
	}

}