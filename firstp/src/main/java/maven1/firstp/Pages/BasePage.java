package maven1.firstp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import maven1.firstp.Pages.FOIb.HomePage;
import maven1.firstp.Pages.FOIb.LoginPage;
import maven1.firstp.Pages.FOIb.RegisterPage;

public class BasePage {
	
	private static WebDriver driver = null;
	
	public BasePage() //default constructor
	{}
	public BasePage(WebDriver driver)
	{
		BasePage.driver = driver;
	}
	
	public RegisterPage NavigateToRegisterPage()
	{
		this.driver.navigate().to("http://newtours.demoaut.com/mercuryregister.php");
		return new RegisterPage(driver);
	}
	
	
	public HomePage GetHomePage()
	{
		return new HomePage(driver);
	}
	
	public LoginPage GetLoginPage()
	{
		return new LoginPage(driver);
	}
	
	public RegisterPage GetRegisterPage()
	{
		return new RegisterPage(driver);
	}
}
