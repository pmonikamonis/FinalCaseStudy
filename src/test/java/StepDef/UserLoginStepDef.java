package StepDef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class UserLoginStepDef {
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	
	@Given("User is on Login page")
	public void user_is_on_login_page() throws IOException {
		
	TestBase.initDriver();
	driver=TestBase.getDriver();
	prop= new Properties();
	String path= System.getProperty("user.dir")+
			"\\src\\test\\resources\\ConfigFiles\\configFiles.properties";
	FileInputStream fin= new FileInputStream(path);
	prop.load(fin);
	TestBase.OpenUrl(prop.getProperty("url"));
	loginPage = new LoginPage(driver);
	loginPage.sigin();
	}
	
	@When("User provide {string} and {string}")
	public void user_provide_and(String string1, String string2) {
		loginPage.validlogin(string1, string2);
	   
	}
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
	 Assert.assertEquals(driver.getTitle(),"Conduit");
	}


}
