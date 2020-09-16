package stepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;

public class TestBase {
	public WebDriver driver;
	public LoginPage loginpage;
	public AddCustomersPage addCustomer;
		
	//Generating  random String for Unique email ID
	public static String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}
