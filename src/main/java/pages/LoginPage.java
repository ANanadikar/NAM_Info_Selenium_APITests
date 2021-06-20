package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class LoginPage extends base {
	
	
	@FindBy(xpath="//input[@id='loginEmail']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(id="loginSubmitButton")
	WebElement submit;
	
	@FindBy(xpath="//span[text()='Username and/or password invalid']")
	WebElement errormsg;
	
	@FindBy(xpath="//img[@class='qa-login--img-hrs_logo']")
	WebElement hrslogo;
	
	@FindBy(xpath="//a[@href='javascript: void(0);']")
	WebElement forgotpwd;
	
	@FindBy(xpath="//a[@href='http://www.healthrecoverysolutions.com/privacy-policy']")
	WebElement termscondition;
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String logintoApp(String un,String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		Thread.sleep(4000);
		return errormsg.getText();		 

	}
	
	public WebElement signinbtn()
	{
		
		return submit;
		
	}
	
	
	public WebElement HRSlogo() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hrslogo);
		return hrslogo;
		
	}
	
	public WebElement forgotpwdlink()
	{
		
		return forgotpwd;
		
	}
	
	
	public WebElement termsconditions() throws InterruptedException
	
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termscondition);
		return termscondition;
		
	}
	
	
}
