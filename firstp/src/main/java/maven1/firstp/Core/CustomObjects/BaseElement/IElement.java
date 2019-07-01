package maven1.firstp.Core.CustomObjects.BaseElement;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public interface IElement extends WebElement  {

	void sendKeys(int delayInMilliSeconds, String keysToSend);

}
