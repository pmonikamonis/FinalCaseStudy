package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Hooks;
import base.TestBase;

public class ArticlePage {
	
	WebDriver driver;

	
	@FindBy(xpath="//a[text()='New Article']")
	WebElement newart_link;

	@FindBy(xpath="//fieldset/input[@name='title']")
	WebElement newart_title;
	
	@FindBy(xpath="//fieldset/input[@name='description']")
	WebElement newart_about;

	@FindBy(xpath="//textarea[@name='body']")
	WebElement newart_body;
	
	@FindBy(name="tags")
	WebElement newart_tag;
	
	@FindBy(xpath="//button[text()='Publish Article']")
	WebElement publish_btn;
	
		
	public ArticlePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= TestBase.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void create_article()
	{
		newart_link.click();
		
	}
	public void ProvideArticledetails(String strtitle, String strabt, String strbdy, String strtag)
	{
		newart_title.sendKeys(strtitle);
		newart_about.sendKeys(strabt);
		newart_body.sendKeys(strbdy);
		newart_tag.sendKeys(strtag);
		publish_btn.click();
	}
	
	
}

