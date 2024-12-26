package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static TestBase testbase;
	public static WebDriver driver;
	
	public TestBase()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
	}
	
	public static void initDriver()
	{
		if(testbase==null)
		{
			testbase = new TestBase();
		}
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void OpenUrl(String Url)
	{
		driver.get(Url);
	}
	
	public static void tearDown()
	{
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
		testbase=null;
	}
}
