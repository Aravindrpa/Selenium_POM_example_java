package maven1.firstp.Core.CustomObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;

import maven1.firstp.Core.CustomObjects.BaseElement.Element;

public class TextBox extends Element {
	
	private WebElement element;
	
	public TextBox(WebElement element) {
		super(element);
		this.element = element;
	}

	//IF want to override base element method
	/*@Override
	public void sendKeys(int delayInMilliSeconds,String keysToSend)
	{
		System.out.println("testHere");
	}*/
	
	public void sendKeys(int delayInMilliSeconds,String keysToSend,String testParam)
	{
		System.out.println("TextBox Specific sendKeys - not the base element");
	}

}
