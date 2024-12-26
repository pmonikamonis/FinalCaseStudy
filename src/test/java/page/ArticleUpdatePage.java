package page;

import static org.testng.Assert.assertNull;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ArticleUpdatePage {
	
	WebDriver driver;
	public static String exp_updbdy=null;
	ArticleActionPage artact;
	
	@FindBy(xpath="(//button/a[text()=' Edit Article'])[2]")
	WebElement update_art;
	
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement art_body;
	
	@FindBy(xpath="(//button[text()='Update Article'])[1]")
	WebElement update_btn;
	
	@FindBy(xpath="//div/p")
	WebElement upd_body;
	
	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
	WebElement del_art;
	
	
	public ArticleUpdatePage(WebDriver driver)
	{
		this.driver= TestBase.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	public void validatearticlePage()
//	{
//		String actual= artact.art_name.getText();
//		Assert.assertEquals(actual, ArticleActionPage.exp_art);
//	}
	public void updatearticle()
	{
		update_art.click();
		art_body.clear();
		art_body.sendKeys("Test Completed");
		exp_updbdy=art_body.getText();
		update_btn.click();
	}
	
	public void validateupdatedarticle()
	{
		String actualbody= upd_body.getText();
		Assert.assertEquals(actualbody, exp_updbdy);
	}
	public void deletearticle()
	{
		del_art.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
        System.out.println("Alert message: " + alertText);
        alert.accept();
        System.out.println("Alert accepted successfully.");
	}
	public void validatedeletedarticle() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Global Feed']")).click();
		boolean delart= driver.findElements(By.xpath("//div[@class='article-preview']/a/h1[text()='"+artact.exp_art+"']")).isEmpty(); 
		Assert.assertTrue(delart,"Article should be deleted and no longer exist");
	}
	
	
}
