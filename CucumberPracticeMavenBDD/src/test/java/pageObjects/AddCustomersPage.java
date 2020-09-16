package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomersPage {
	public WebDriver idriver;

	public AddCustomersPage(WebDriver rdriver) {
		idriver=rdriver;
		PageFactory.initElements(idriver, this);
	}
	//Another way of implementing POM model except using @Findby
	By customersMenu=By.xpath("(//span[contains(text(),'Customers')])[1]");
	By customerMenuItem=By.xpath("(//span[contains(text(),'Customers')])[2]");
	By addNewButton=By.xpath("//a[contains(@class,'btn bg-blue')]");
	By email=By.xpath("//input[contains(@id,'Email')]");
	By password=By.xpath("//input[contains(@id,'Password')]");
	By firstName=By.xpath("//input[contains(@id,'FirstName')]");
	By lastname=By.xpath("//input[contains(@id,'LastName')]");
	By genderMale=By.xpath("//input[contains(@id,'Gender_Male')]");
	By genderFemale=By.xpath("//input[contains(@id,'Gender_Female')]");
	By dateOfBirth=By.xpath("//input[contains(@id,'DateOfBirth')]");
	By companyName=By.xpath("//input[contains(@id,'Company')]");
	
	//Company Role List Item
	By customerRoles=By.xpath("(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]");
	By adminstratorCustomerRole=By.xpath("//li[contains(text(),'Administrators')]");
	By forumModularCustomerRole=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By guestCustomerRole=By.xpath("//li[contains(text(),'Guests')]");
	By vendorCustomerRole=By.xpath("//li[contains(text(),'Vendors')]");
	
	By managerVendor=By.xpath("//*[@id='VendorId']");
	By adminComment=By.xpath("//*[@name='AdminComment']");
	By saveButton=By.xpath("//button[@name='save']");
	
	//Action Methods
	
	public String pageTitle() {
		return idriver.getTitle();
	}
	public void clickCustomersMenu() {
		idriver.findElement(customersMenu).click();
	}
	public void clickCustomerItem() {
		idriver.findElement(customerMenuItem).click();
	}
	public void clickAddCustomer() {
		idriver.findElement(addNewButton).click();
	}
	public void setEmail(String emailID) {
		idriver.findElement(email).sendKeys(emailID);
	}
	public void setPassword(String pwd) {
		idriver.findElement(password).sendKeys(pwd);
	}
	public void setFirstName(String first) {
		idriver.findElement(firstName).sendKeys(first);
	}
	public void setLastName(String last) {
		idriver.findElement(lastname).sendKeys(last);
	}
	public void setCompanyName(String company) {
		idriver.findElement(companyName).sendKeys(company);
	}
	public void setAdminComment(String comment) {
		idriver.findElement(adminComment).sendKeys(comment);
	}
	public void setDOB(String dob) {
		idriver.findElement(dateOfBirth).sendKeys(dob);
	}
	
	public void setGender(String genderName) {
		if (genderName.equals("Male")) {
			idriver.findElement(genderMale).click();
		}
		if (genderName.equals("Female")) {
			idriver.findElement(genderFemale).click();
		}
	}
	
	public void setMangerOfVendor(String vendor) {
		Select obj=new Select(idriver.findElement(managerVendor));
		obj.selectByVisibleText(vendor);
	}
	public void setCustomerRole(String role) {
		
		idriver.findElement(customerRoles).click();
		WebElement selectedrole = null;
		
		if (role.equals("Administrators")) {
			selectedrole=idriver.findElement(adminstratorCustomerRole);
		}
		if (role.equals("Forum Moderators")) {
			selectedrole=idriver.findElement(forumModularCustomerRole);
		}
		if (role.equals("Guests")) {
			selectedrole=idriver.findElement(guestCustomerRole);
		}
		if (role.equals("Vendors")) {
			selectedrole=idriver.findElement(vendorCustomerRole);
		}
		//selectedrole.click();
		JavascriptExecutor js=(JavascriptExecutor)idriver;
		js.executeScript("arguments[0].click();", selectedrole);
	}
	
	public void clickOnSave() {
		idriver.findElement(saveButton).click();
	}

}
