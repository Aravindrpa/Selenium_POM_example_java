package maven1.firstp.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
		

	public WebDriver driver = null;
	private static String currentUserDirectory = System.getProperty("user.dir");
	private static String baseUrl="";
	
	public String GetCurrentDirectory() {
		return currentUserDirectory;
	}
	
	/*public WebDriver GetDriver() {
		return driver;
	}
	*/
	public void SetDriver(String browser, String baseUrl) {
		
		switch (browser) {
		case "chrome":
			IntiateChrome(baseUrl);
			break;

		default:
			IntiateChrome(baseUrl);
			break;
		}
	}
	
	private void IntiateChrome(String baseUrl)
	{
		System.out.println(GetCurrentDirectory());
		System.setProperty("webdriver.chrome.driver",  GetCurrentDirectory()+ "\\src\\main\\java\\maven1\\firstp\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
	}
	
	 @BeforeSuite
	  public void beforeSuite() {
		 baseUrl = "http://newtours.demoaut.com/mercurysignon.php";
		 SetDriver("chrome", baseUrl);
	  }

	  @AfterSuite
	  public void afterSuite() {
		  driver.quit();		 
	  }
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {	  
  }

  @AfterTest
  public void afterTest() {
  }

 

}
