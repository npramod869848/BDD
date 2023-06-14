package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// create object of webdriver
		WebDriver ldriver;

		//constructor

		public LoginPage(WebDriver rdriver)
		{
			ldriver=rdriver;

			PageFactory.initElements(rdriver, this);
		}


// identify webelement
 @FindBy(id="Email")
 WebElement email;

 @FindBy(id="Password")
 WebElement password;
 
 @FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
 WebElement LoginBtn;
 
 @FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
 WebElement Logout;
 
 // action on webelements
 public void enteremailaddress(String emailAdd)
 {
	 email.clear();
	 email.sendKeys(emailAdd);
 }
 public void enterpassword(String pwd)
 {
	 password.clear();
	 password.sendKeys(pwd);
 }
 public void ClickOnLoginBtn()
 {
	 LoginBtn.click();
 }
 public void ClickOnLogoutBtn()
 {
	 Logout.click();
 }
}