package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;

public class Steps extends TestBase{
	
	
		
	@Given("^User Launch Chrome Browser$")
	public void user_Launch_Chrome_Browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",".///Drivers/chromedriverupdated1.exe");
		driver=new ChromeDriver();
		loginpage=new LoginPage(driver);
		addCustomer=new AddCustomersPage(driver);
	   //throw new PendingException();
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String arg1) throws Throwable {
		driver.get(arg1);
	    
	}

	@When("^User Enters Email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_Enters_Email_as_and_password_as(String arg1, String arg2) throws Throwable {
		 loginpage.setUsername(arg1);
		   loginpage.setpassword(arg2);
	    
	}

	@When("^User Clicks on Login$")
	public void user_Clicks_on_Login() throws Throwable {
		loginpage.clickLogin();
	    
	}

	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard() throws Throwable {
		addCustomer=new AddCustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCustomer.pageTitle());
	}

	@When("^User clicks on Customers Menu$")
	public void user_clicks_on_Customers_Menu() throws Throwable {
		Thread.sleep(3000);
	   addCustomer.clickCustomersMenu();
	    
	}

	@When("^clicks on customers Menuitem$")
	public void clicks_on_customers_Menuitem() throws Throwable {
		Thread.sleep(3000);
	    addCustomer.clickCustomerItem();
	    
	}

	@When("^clicks on Add New button$")
	public void clicks_on_Add_New_button() throws Throwable {
	    addCustomer.clickAddCustomer();
	    
	}

	@Then("^User can view Add new Customer Page$")
	public void user_can_view_Add_new_Customer_Page() throws Throwable {
	  Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomer.pageTitle());
	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() throws Throwable {
		String emailID=randomString()+"@gmail.com"; //randomString() gives random email ID defined in TestBase.java
		   addCustomer.setEmail(emailID);
		   addCustomer.setPassword("test123");
		   addCustomer.setFirstName("Suresh");
		   addCustomer.setLastName("Das");
		   addCustomer.setGender("Male");
		   addCustomer.setDOB("02/10/1996"); 	//Format is DD/MM/YYY
		   addCustomer.setCompanyName("Carvosis");
		   	addCustomer.setCustomerRole("Administrators");
		   	addCustomer.setAdminComment("For Cucumber Testing");
		   	addCustomer.setMangerOfVendor("Vendor 1");
		   	 
	}

	@When("^clicks on Save Button$")
	public void clicks_on_Save_Button() throws Throwable {
		Thread.sleep(5000);
	   addCustomer.clickOnSave();
	   Thread.sleep(2000);
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String arg1) throws Throwable {
	   Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(arg1));  
	}

	@Then("^close Browser$")
	public void close_Browser() throws Throwable {
		 driver.close();
	  	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String arg1) throws Throwable {
		 if (driver.getPageSource().contains("Login was unsucessful")) {
				driver.close();
				Assert.assertTrue(false);
			}
			   else {
				   Assert.assertEquals(arg1, driver.getTitle());
			   }
	}

	@When("^User clicks on Logout link$")
	public void user_clicks_on_Logout_link() throws Throwable {
		loginpage.clicklogout();
		Thread.sleep(3000);
	  	}
}
