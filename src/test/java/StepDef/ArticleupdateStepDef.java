package StepDef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ArticleActionPage;
import page.ArticleUpdatePage;

public class ArticleupdateStepDef {
	
	WebDriver driver;
	ArticleUpdatePage artupdPage;
	
	@Given("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed() {
		driver=TestBase.getDriver();
		artupdPage=new ArticleUpdatePage(driver);
//		artupdPage.validatearticlePage();
	}
	
	@When("User update article detail")
	public void user_update_article_detail() throws InterruptedException {
		
		Thread.sleep(1000);
		artupdPage.updatearticle();
		
	}
	
	@Then("Article detail must be updated")
	public void article_detail_must_be_updated() throws InterruptedException {
		Thread.sleep(1000);
		artupdPage.validateupdatedarticle();
	}
	
	@When("User delete article")
	public void user_delete_article() throws InterruptedException
	{
		Thread.sleep(1000);
		artupdPage.deletearticle();
//		Actions actions= new Actions(driver);
//		actions.moveToElement(null)
		
	}
	
	@Then("Article must be deleted")
	public void article_must_be_deleted() throws InterruptedException
	{
		Thread.sleep(1000);
		artupdPage.validatedeletedarticle();
	}
	
	

}
