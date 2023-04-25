package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {
	
	public static WebDriver driver;
	static String url = "https://www.saucedemo.com/";
	public static ExtentTest logger;
	public static ExtentReports report;
	public static 

	@BeforeClass(alwaysRun=true)
	void setup(ITestContext context) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
	}
	
	/* @AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}*/

}
