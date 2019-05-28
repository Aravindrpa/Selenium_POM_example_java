package maven1.firstp.Tests.UITests;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import maven1.firstp.Core.CustomObjects.BaseElement.Element;
import maven1.firstp.Core.Other.Factory;
import maven1.firstp.Pages.BasePage;
import maven1.firstp.Tests.BaseTest;

public class UITest1 extends BaseTest {
	
//	@FindBy(how = How.NAME, using="firstName")
//	private Element textbox_FirstName;
//	
//	@FindBy(how = How.NAME, using="lastName")
//	private Element textbox_LastName;
//	
//	  @Test
//	  public void Test() 
//	  {
//		   Factory.initElements(super.driver, this);
//	  }
		
	  
	  @Test
	  public void RegisterUser() 
	  {
		  new BasePage(super.driver)
		  .NavigateToRegisterPage()
		  .enterFirstName("Aravind")
		  .enterLastName("Raj");  
	  }
}
