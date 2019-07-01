package maven1.firstp.Pages.FOIb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import maven1.firstp.Core.CustomObjects.TextBox;
import maven1.firstp.Core.CustomObjects.BaseElement.Element;
import maven1.firstp.Core.CustomObjects.BaseElement.IElement;
import maven1.firstp.Core.Other.Factory;
import maven1.firstp.Pages.BasePage;
import maven1.firstp.TestData.DataObjects.RegisterPageData;

public class RegisterPage extends BasePage {
	
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	private RegisterPageData pageData = null;
	
	@FindBy(how = How.NAME, using="firstName")
	private TextBox textbox_FirstName;
	
	@FindBy(how = How.NAME, using="lastName")
	private TextBox textbox_LastName;
	
	
	public RegisterPage(WebDriver driver, RegisterPageData data)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5000);
		this.pageData = data;
		Factory.initElements(driver,this);
	}
	
	
	public RegisterPage enterFirstName()
	{	
		textbox_FirstName.sendKeys(500,pageData.firstName);
		return this;
	}
	public RegisterPage enterLastName()
	{
		textbox_LastName.sendKeys(pageData.lastName);
		return this;
	}

}
