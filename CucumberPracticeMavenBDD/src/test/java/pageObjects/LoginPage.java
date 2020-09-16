package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver rdriver;
	
	 @FindBy(linkText="Logout")
	 WebElement logoutlink;
	 
	 @FindBy(xpath="//input[contains(@id,'Email')]")
	 WebElement email;
	 
	 @FindBy(xpath="//input[contains(@id,'Password')]")
	 WebElement password;
	 
	 @FindBy(xpath="//input[contains(@type,'submit')]")
	 WebElement loginButton;

	public LoginPage(WebDriver idriver) {
		rdriver=idriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void setUsername(String uname) {
		email.clear();
		email.sendKeys(uname);
	}
	
	public void setpassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	 
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clicklogout() {
		logoutlink.click();
	}
	 
	 
}
