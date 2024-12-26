package StepDef;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.Hooks;
import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ArticleActionPage;
import page.ArticlePage;

public class ArticleActionsStepDef {
	
	WebDriver driver;
	ArticleActionPage articleactionPage;
	
	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() throws InterruptedException {
	  
		driver=TestBase.getDriver();
		articleactionPage=new ArticleActionPage(driver);
		
		Thread.sleep(1000);
		articleactionPage.globalnav();
//		driver.findElement(By.xpath("//nav[@class='navbar navbar-light']/div/ul[2]/li/a")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Global Feed']")).click();
		//Assert.assertEquals(driver.getTitle(),"Conduit");
		//System.out.println("Global Feed  .."+ driver.getTitle());
	}
	
	@When("User select an article {string}")
	public void user_select_an_article(String strart) throws InterruptedException {
		
		articleactionPage.selectarticle(strart);
	   
	}
	//@Then("Article detail page must be displayed")
	@Then("Article detail page should be displayed")
	public void article_detail_page_should_be_displayed() {
		
		articleactionPage.validatearticlePage();
	}


	}
