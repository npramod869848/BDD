package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerListPage {
	public WebDriver ldriver;

	//constructor
	public CustomerListPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	//Find web elements on the web page

	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddnew;

	@FindBy(id="SearchEmail")
	WebElement emailAdd;

	@FindBy(xpath="//*[@id=\"search-customers\"]")
	WebElement searchBtn;

	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;

	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> tableRows;

//	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td")
//	List<WebElement> tableColumns;


	//*[@id="customers-grid_wrapper"]/div[1]/div/div/div[1]/div/table

	//Actions Methods for web elements

	public void clickOnAddnew() 
	{
		btnAddnew.click();
	}
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}

	public void enteremailaddress(String email)
	{
		emailAdd.sendKeys(email);
	}

	public void clickonsearchBtn()
	{
		searchBtn.click();
	}
	public boolean searchCustomerByEmail(String email)
	{
		boolean found=false;
		//total no.of rows in grid
		int ttlRows=tableRows.size();

		//total no.of colm in grid
		//int ttlColumns=tableColumns.size();

		//for loop all rows scan karne
		for(int i=1; i<=ttlRows; i++)
		{
			WebElement webElementEmail= ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[\" + i  + \"]/td[2]"));

			String actualEmailAdd= webElementEmail.getText();

			if(actualEmailAdd.equals(email))
			{
				found=true;
			}
		}
		return found;
	}

}







