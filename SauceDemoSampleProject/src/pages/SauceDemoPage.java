package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SauceDemoPage {
	By txtuname = By.xpath("//input[@id='user-name']");
	By txtpassword = By.xpath("//input[@id='password']");
	By btnlogin = By.xpath("//input[@id='login-button']");
	By lblUrequired = By.xpath("//h3[normalize-space()='Epic sadface: Username is required']");
	By lblPrequired = By.xpath("//div[@class='error-message-container error']/child::h3");
	By prodImage = By.xpath("//a[@id='item_1_img_link']");
	//By prodId = By.xpath("(//div[@class='inventory_item'])[4]");
	//(//div[@class='inventory_item'])[4]
	
	WebDriver driver;
	WebDriverWait wait;
	
	// create a constructor and pass the driver instance
	public SauceDemoPage(WebDriver driver) { 
		this.driver = driver;
		//wait = new WebDriverWait(driver, 10);
	}
	
	// Checking page is navigated with the expected title
	public void verifyPageTitle() {
		String actual = driver.getTitle();
		String expected = "Swag Labs";
		Assert.assertEquals(actual, expected);
	}
	
	//Verification of Login Page with Valid Username and Password
	public void verifyLoginValidValid(String username, String password) {
		WebElement txtuser = driver.findElement(txtuname);
		WebElement txtpass = driver.findElement(txtpassword);
		txtuser.clear();
		txtuser.sendKeys(username);
		txtpass.clear();
		txtpass.sendKeys(password);
		driver.findElement(btnlogin).click();
		
		String actualURL = "https://www.saucedemo.com/inventory.html";
		String expectedURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	//Verification of Username required
	public void verifyUsernameRequired() {
		driver.findElement(txtuname).sendKeys("");
		driver.findElement(txtpassword).sendKeys("");
		driver.findElement(btnlogin).click();
		
		String expectedErrorMsg = "Epic sadface: Username is required";
		String  actualErrorMsg = driver.findElement(lblUrequired).getText();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	
	//Verification of Password required
	public void verifyPasswordRequired(String username) {
		driver.findElement(txtuname).sendKeys(username);
		driver.findElement(txtpassword).sendKeys("");
		driver.findElement(btnlogin).click();
				
		String expectedErrorMsg  = "Epic sadface: Password is required";
		String actualErrorMsg = driver.findElement(lblPrequired).getText();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	
	//Click on the Product by given id
	public void clickOnProductGivenId(int id) {
		WebElement prodId = driver.findElement(By.xpath("//div[@class='inventory_item']["+ id +"]/div/a"));
		System.out.println(prodId);
		prodId.click();
	}
	
	

}
