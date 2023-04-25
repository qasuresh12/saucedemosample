package tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.SauceDemoPage;

public class SauceDemoTest extends BasePage{
	
	@Test (priority = 1, enabled = true)
	//Verify Page Title
	public void verifyPageTitle() throws InterruptedException
	{
		SauceDemoPage demopage = new SauceDemoPage(driver);
		Thread.sleep(2000);
		demopage.verifyPageTitle();
		System.out.println("Page title validation is pass");
		logger.log(LogStatus.INFO, "Page title got successfully and compare actual and expected");
		logger.log(LogStatus.PASS, "Page title validation is pass");		
	}
	
	@Test (priority = 4, enabled = true)
	//Verification of Login Page with Valid Username and Valid Password
	@Parameters({"vusername", "vpassword"})
	public void verifyLoginValidValid(String vusername, String vpassword)
	{
		SauceDemoPage demopage = new SauceDemoPage(driver);
		demopage.verifyLoginValidValid(vusername, vpassword);
		System.out.println("Login Page with Valid Username and Password is Pass");
		logger.log(LogStatus.INFO, "Able to login with Valid Username & Valid Password");
		logger.log(LogStatus.PASS, "Login Page with Valid Username and Password is Pass");
	}
	
	@Test (priority = 2, enabled = true)
	//Verification of Username required
	public void verifyUsernameRequired()
	{
		SauceDemoPage demopage = new SauceDemoPage(driver);
		demopage.verifyUsernameRequired();
		System.out.println("Username Required test is Pass");
		logger.log(LogStatus.INFO, "Username Required Message displayed");
		logger.log(LogStatus.PASS, "Username Required test is Pass");
	}
	
	@Test (priority = 3, enabled = true)
	//Verification of Password required
	@Parameters({"vusername"})
	public void verifyPasswordRequired(String vusername)
	{
		SauceDemoPage demopage = new SauceDemoPage(driver);
		demopage.verifyPasswordRequired(vusername);
		System.out.println("Password Required test is Pass");
		logger.log(LogStatus.INFO, "Password Required Message displayed");
		logger.log(LogStatus.PASS, "Password Required test is Pass");
	}
	
	@Test (priority = 5, enabled = true)
	//Click on the Product by given id
	@Parameters({"prodId"})
	public void clickOnProductGivenId(int prodID)
	{
		SauceDemoPage demopage = new SauceDemoPage(driver);
		demopage.clickOnProductGivenId(prodID);
		logger.log(LogStatus.INFO, "Clicked on the Product by given Id");
		logger.log(LogStatus.PASS, "successfully clicked on the Product by Id");
	}
	
}
