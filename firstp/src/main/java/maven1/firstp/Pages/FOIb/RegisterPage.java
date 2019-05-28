package maven1.firstp.Pages.FOIb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import maven1.firstp.Core.CustomObjects.TextBox;
import maven1.firstp.Core.CustomObjects.BaseElement.Element;
import maven1.firstp.Core.CustomObjects.BaseElement.IElement;
import maven1.firstp.Core.Other.Factory;
import maven1.firstp.Pages.BasePage;

public class RegisterPage extends BasePage {
	
	private WebDriver driver = null;
	
	@FindBy(how = How.NAME, using="firstName")
	private TextBox textbox_FirstName;
	
	@FindBy(how = How.NAME, using="lastName")
	private TextBox textbox_LastName;
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		Factory.initElements(driver,this);
	}
	
	
	public RegisterPage enterFirstName(String firstName)
	{
		textbox_FirstName.sendKeys(500,firstName);
		return this;
	}
	public RegisterPage enterLastName(String lastName)
	{
		textbox_LastName.sendKeys(lastName);
		return this;
	}

}
