package commonFunctions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunc {
	public static Properties prop = null;  //initialize as global so that we can use the property value across the class
	public static WebDriver driver = null; //initialize as global so that we can use the WebDriver across the class
	//Load property file values and return
	public Properties loadPropertyFile() throws IOException
	{
		FileInputStream fis = new FileInputStream("config.properties"); //Access the file
		prop = new Properties();		
		prop.load(fis);  //load the property file
		return prop;	//	
	}
	
	@BeforeSuite  //Execute in the beginning of the suite
	public void launchBrowser() throws IOException
	{
		loadPropertyFile();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String driverlocation = prop.getProperty("driverlocation");	
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", driverlocation);
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterSuite  //Execute in the end of the suite
	public void tearDown()
	{
		driver.close();
	}
}



// http://www.software-testing-tutorials-automation.com/2014/03/testngxml-creating-single-or-multiple.html