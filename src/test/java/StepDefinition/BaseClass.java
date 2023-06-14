package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AdminPage;
import PageObject.CreateCustomerPage;
import PageObject.CustomerListPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;

//BC IS parent class.// Stepdefinition is child class
public class BaseClass {
	public WebDriver driver;   //driver and loginpage che object tayar kalet.
	public LoginPage lp;
	public CreateCustomerPage ccp; // page cha object tayar kela
	public AdminPage ap;
	public CustomerListPage cl;
	public static Logger log;
	public ReadConfig readConfig; //class name then object name
	
//	public String generateEmailId()  //  pratekveli email che number change honar.
//	{
//		return(RandomStringUtils.randomAlphabetic(5));
//	}
}
