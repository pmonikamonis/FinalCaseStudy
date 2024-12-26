package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/",
		glue= {"StepDef"},
		dryRun=false,
		monochrome=true,
		plugin={"pretty",
				"html:target/reports/HTMLReport.html",
				"json:target/cucumber.json"
				
		}
		)

public class UserLoginTestRunner extends AbstractTestNGCucumberTests{

}
