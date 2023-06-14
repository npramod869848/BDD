package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCustomerPage {
	WebDriver ldriver;

	public CreateCustomerPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	// identify webelement
	@FindBy(xpath="/html/head/title")
	WebElement pageTitle;
	
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"FirstName\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id=\"LastName\"]")
	WebElement LastName;
	
	@FindBy(xpath="//*[@id=\"Gender_Male\"]")
	WebElement Male;
	
	@FindBy(id = "Gender_Male")
	WebElement MaleGender;


	@FindBy(id = "Gender_Female")
	WebElement FeMaleGender;
	
	@FindBy(xpath="//*[@id=\"DateOfBirth\"]")
	WebElement DOB;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;
	
	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;


	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;


	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;


	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	//VendorId

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
	
	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;

	@FindBy(xpath = "/html/body/div[3]/div[1]/form/div[1]/div/button[1]")
	WebElement btnSave;
	
	// action on webelement
	public String getPageTitle()
	{
        return pageTitle.getText();
	}
	public void enteremailadd(String email)
	{
		Email.sendKeys(email);
	}
	public void enterpassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void enterfirstname(String fnm)
	{
		FirstName.sendKeys(fnm);
	}
	public void enterlastname(String lnm)
	{
		LastName.sendKeys(lnm);
	}
	public void enterGender(String gender)
	{
		if(gender.equals("Male"))
		{
			MaleGender.click();
		}
		else if(gender.equals("Female"))
		{
			FeMaleGender.click();
		}
		else//default set Male gender
		{
			MaleGender.click();
		}

	}
	public void enterdob(String dob)
	{
		DOB.sendKeys(dob);
	}
	public void entercompanyname(String comp)
	{
		txtCompanyName.sendKeys(comp);
	}
	public void enterAdminContent(String content)
	{
		txtAdminContent.sendKeys(content);
	}
	public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}
	public void clickOnSave()
	{
		btnSave.click();
	}


}
