package page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class ArticleActionPage {
	
	WebDriver driver;
	public static String exp_art=null;
	
	
	@FindBy(xpath="//div/h1")
	WebElement art_name;
	
//	@FindBy(xpath="//a[text()='Home']")
//	WebElement home_page;
//	
//	@FindBy(xpath="//button[text()='Global Feed']")
//	WebElement global_page;
	
	
//	
	public ArticleActionPage(WebDriver driver)
	{
		this.driver= TestBase.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void globalnav() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//nav[@class='navbar navbar-light']/div/ul[2]/li/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Global Feed']")).click();
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		WebElement home= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='navbar navbar-light']/div/ul[2]/li/a")));
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", home);
//		WebElement global= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Global Feed']")));
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", global);
	}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", home_page);
//		//home_page.click();
//		executor.executeScript("arguments[0].click();", global_page);
//		//global_page.click();
//	}
	
	public void selectarticle(String articlename)
	{
		WebElement selart = driver.findElement(By.xpath("//div[@class='article-preview']/a/h1[text()='"+articlename+"']"));
		selart.click();
		exp_art=articlename;
	}
	
	public void validatearticlePage()
	{
		String actual= art_name.getText();
		Assert.assertEquals(actual, exp_art);
	}
	
	
	
}
