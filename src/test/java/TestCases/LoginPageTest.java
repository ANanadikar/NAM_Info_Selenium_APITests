package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginPageTest extends base {
	
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		
		super();
	}
	
	
	@BeforeMethod

	public void setUp() {

		initialization();
		loginpage=new LoginPage();
	
	}
	
	
	@Test(priority=1)
	public void SeleniumTest_validate_InvalidLoginError() throws Exception 
	{
		
		String Actualmsg=loginpage.logintoApp(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals("Username and/or password invalid", Actualmsg);
		
	}
	
	
	@Test(priority=2)
	public void SeleniumTest_validate_LoginPageTitle() throws Exception  
	{
		
	String title=driver.getTitle();
	Assert.assertEquals("HRS | ClinicianConnect", title);
		
	}
	
	@Test(priority=3)
	public void SeleniumTest_validate_currentURL() throws Exception  
	{
		
	String currenturl=driver.getCurrentUrl();
	Assert.assertEquals("https://cc.healthrecoverysolutions.com/login", currenturl);
		
	}
	
	@Test(priority=4)
	public void SeleniumTest_validate_SIgnInbtnVisibility() throws Exception  
	{
		
		boolean signinbtn=loginpage.signinbtn().isDisplayed();
		
		Assert.assertEquals(true, signinbtn);
		
	}
	
	@Test(priority=5)
	public void SeleniumTest_validate_HRSlogovisibility() throws Exception  
	{
		boolean logosivibility=loginpage.HRSlogo().isDisplayed();
		Assert.assertEquals(true, logosivibility);
	
		
	}
	
	@Test(priority=6)
	public void SeleniumTest_validate_forgorpwdlinkvisibility() throws Exception  
	{
		
		boolean fpvibility=loginpage.forgotpwdlink().isDisplayed();
		Assert.assertEquals(true, fpvibility);
		
	}
	
	@Test(priority=7)
	public void SeleniumTest_validate_termsAndConditionslink() throws Exception  
	{
		
	boolean terms=loginpage.termsconditions().isDisplayed();
	Assert.assertEquals(true, terms);
		
	}
	
	
	
	@AfterMethod()
	
	public void tearDown(){
		
		driver.quit();
		
	}

}
