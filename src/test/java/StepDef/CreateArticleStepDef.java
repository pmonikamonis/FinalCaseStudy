package StepDef;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Hooks;
import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ArticlePage;

public class CreateArticleStepDef {
	
	//TestBase testbase;
	WebDriver driver;
	//driver=TestBase.getDriver();
	ArticlePage articlePage;
	
	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
		//TestBase.initDriver();
		driver=TestBase.getDriver();
		articlePage=new ArticlePage(driver);
		articlePage.create_article();
		Assert.assertEquals(driver.getTitle(),"Conduit");
	  
	}
	
	@When("User enters Article details")
	public void user_enters_article_details(DataTable dataTable) {
		
		List<Map<String,String>> article= dataTable.asMaps();
		String title = article.get(0).get("title");
		String about = article.get(0).get("Desc");
		String body = article.get(0).get("Content");
		String tags = article.get(0).get("tag");
		articlePage.ProvideArticledetails(title,about,body,tags);
	  
	}
	@Then("Article must be created")
	public void article_must_be_created() {
		
		Assert.assertEquals(driver.getTitle(),"Conduit");
	}
	@After
	public void attachScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot src= (TakesScreenshot)driver;
			byte[] imge= src.getScreenshotAs(OutputType.BYTES);
			scenario.attach(imge, "image/png", "Screenhot");
		}
	}

}
