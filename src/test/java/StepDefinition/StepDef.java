// child class of base class
package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import PageObject.AdminPage;
import PageObject.CreateCustomerPage;
import PageObject.CustomerListPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

	@Before(order=0) // hooks
	public void setup1()
	{
		readConfig = new ReadConfig();
		
		//initialise logger
		log = LogManager.getLogger("StepDef");

		System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver = null;
			break;

		}

	
		log.fatal("Setup1 executed...");


	}

//	@Before("@sanity") // conditional hooks
//	public void setup2()
//	{
//		System.out.println("Setup2 method is executed..");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		log.info("Setup2 executed..");
//		driver.manage().window().maximize();
//	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 	
	{	
		
		cl = new CustomerListPage(driver);
		ap = new AdminPage(driver);
		lp = new LoginPage(driver);// memory allocate karne
		ccp = new CreateCustomerPage(driver); // memory allocate karne
		log.info("Chrome browser launched");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.get(url);
		log.info("url opened");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd,String pwd) 
	{
		lp.enteremailaddress(emailAdd);
		lp.enterpassword(pwd);
		log.info("email address and password entered ");
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		lp.ClickOnLoginBtn();
		log.info("Clicked on loginbtn");
	}
	////////////////////// Login feature//////////////////////////////////////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			log.warn("Test passed:title matched");
			Assert.assertTrue(true);  //pass
		}
		else
		{
			log.warn("Test failed:title not matched");
			Assert.assertTrue(false); //fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() 
	{
		lp.ClickOnLogoutBtn();
		log.info("user clicked on logout");
	}

	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
		//driver.quit();
		log.info("browser closed");
	}

	////////////////////////////////Add new customer page//////////////////////////////////////////
	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() 
	{

		String actualTitle=ap.getPageTitle();

		String expectedTitle = "Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle))
		{
			log.info("user can view dashboard test passed");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu()
	{
		ap.clickOnCustomersMenu();
		log.info("customer menu clicked");
	}   

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item()
	{
		ap.clickOnCustomersMenuItem();
		log.info("customer menu item clicked");
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() 
	{
		cl.clickOnAddnew();
		log.info("clicked on add new btn");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() 
	{
		String actualTitle = ccp.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
	
		

//				if(actualTitle.equals(expectedTitle))
//				{
//					Assert.assertTrue(true);
//				}
//				else
//				{
//					Assert.assertTrue(false);
//				}

	}

	@When("User enter customer info")
	public void user_enter_customer_info()
	{
		//ccp.enteremailadd(generateEmailId()+ "@gmail.com");
		ccp.enteremailadd("pramodnawale852@gmail.com");
		ccp.enterpassword("Nawale@123");
		ccp.enterfirstname("Pramod");
		ccp.enterlastname("Nawale");
		ccp.enterGender("Male");
		ccp.enterdob("9/19/1992");
		ccp.entercompanyname("pan infotech");
		ccp.enterAdminContent("Admin Content");
		ccp.enterManagerOfVendor("Manager Vendor");
		log.info("customer information entered");
	}

	@When("click on Save button")
	public void click_on_Save_button() 
	{
		ccp.clickOnSave();
		log.info("clicked on save btn");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg)
	{
		String bodyTagText=driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expectedConfirmationMsg))
		{
			Assert.assertTrue(true); // pass asel tr
		}
		else
		{
			Assert.assertTrue(false); // fail asel tr
		}
	}
	//////////////////////customer search by emailadd//////////////////////////
	@When("Enter customer EMail")
	public void enter_customer_EMail() 
	{
		cl.enteremailaddress("victoria_victoria@nopCommerce.com");
		log.info("email address entered");
	}

	@When("Click on search button")
	public void click_on_search_button()
	{
		cl.clickonsearchBtn();
		log.info("clicked on search btn");
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() 
	{
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		Assert.assertTrue(cl.searchCustomerByEmail(expectedEmail));
	}
	
	@After ///// hooks//hooks listneres sarkhe astat
	public void teardown(Scenario sc)//parameterized//scenario class cha object create kla
	{
		System.out.println("Tear down method is executed..");
		if(sc.isFailed()==true) //scenario fail zala tr true return milel//sce pass zala false return hoga 
		{
			TakesScreenshot tc = (TakesScreenshot) driver; // convert web driver object to Takescreenshot
			File src = tc.getScreenshotAs(OutputType.FILE); // call getscreenshotAs method to create image file.
			try {
				FileHandler.copy(src, new File("C:\\Users\\Pramod Nawale\\eclipse-workspace\\BDD\\Screenshot\\fail.png"));//move image file to new destination
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}






