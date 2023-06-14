package TestRunner;
import org.junit.runner.RunWith;   
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  

@RunWith(Cucumber.class) 
//@CucumberOptions(features="C:\\Users\\Pramod Nawale\\eclipse-workspace\\BDD\\src\\test\\resource\\Features\\Login.feature",
//@CucumberOptions(features="C:\\Users\\Pramod Nawale\\eclipse-workspace\\BDD\\src\\test\\resource\\Features\\",
@CucumberOptions(features={"D:\\Project\\Pramod Automation Project 2023\\eclipse\\eclipse\\BDD\\src\\test\\resource\\Features\\Customers.feature",
		"D:\\Project\\Pramod Automation Project 2023\\eclipse\\eclipse\\BDD\\src\\test\\resource\\Features\\Login.feature"},



glue="StepDefinition",
dryRun = false,
strict = true,
monochrome = true,
//tags= "@Sanity or @regression",
//tags= "@Sanity",

//plugin = { "pretty", "html:target/reports"}
//plugin = { "pretty", "json:target/reports/cucumber.json"}
//plugin = { "pretty",  "junit:target/reports/cucumber.xml"}
plugin = {"pretty","html:target/cucumber-reports/reports12.html"}
)

public class TestRunner {

}
