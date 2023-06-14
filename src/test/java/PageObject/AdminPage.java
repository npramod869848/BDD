package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
		public WebDriver ldriver;

		//constructor
		public AdminPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(ldriver, this);
		}
		//Find web elements on the web page
		@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
		WebElement Customers_Menu;
		
		@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
		WebElement Customers_Menuitem;

		
		
		//Actions Methods for web elements
		public void clickOnCustomersMenu() 
		{
			Customers_Menu.click();
		}
	
		public void clickOnCustomersMenuItem()
		{
			Customers_Menuitem.click();
		}
		
		public String getPageTitle()
		{
			return ldriver.getTitle();
		}

}
