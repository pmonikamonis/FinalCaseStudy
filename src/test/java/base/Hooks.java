package base;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver(); // Initialize WebDriver
        driver.manage().window().maximize();
        driver.get("https://example.com"); // Replace with your app's base URL
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after the scenario
        }
    }

    public static WebDriver getDriver() {
        return driver; // Provide driver to other classes
    }
}
