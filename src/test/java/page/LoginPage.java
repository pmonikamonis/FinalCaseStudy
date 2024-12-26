package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login_link;
	
	@FindBy(name="email")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement login_Btn;
	
	public LoginPage(WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sigin()
	{
		login_link.click();
		
//		emailid.sendKeys("pmonikamonis@gmail.com");
//		pwd.sendKeys("Moni0809");
//		login_Btn.click();
	}
	
	public void validlogin(String username, String Password)
	{
		emailid.sendKeys(username);
		pwd.sendKeys(Password);
		login_Btn.click();
	}
}
