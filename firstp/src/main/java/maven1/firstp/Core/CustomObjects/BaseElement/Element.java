package maven1.firstp.Core.CustomObjects.BaseElement;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public abstract class Element implements IElement {
	
	private final WebElement element;

    public Element(final WebElement element) {
        this.element = element;
    }
        
	public void sendKeys(int delayInMilliSeconds,String keysToSend) {
		
		System.out.println("In Element");
		char[] chars = keysToSend.toCharArray();
		
		for(int i=0;i<chars.length;i++)
		{
			try {
				Thread.sleep(delayInMilliSeconds);
				element.sendKeys(Character.toString(chars[i]));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		element.click();
	}
	
	@Override
	public void submit() {
		// TODO Auto-generated method stub
		element.submit();
	}
	
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		element.sendKeys(keysToSend);
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		element.clear();
	}
	
	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return element.getTagName();
	}
	
	@Override
	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return element.getAttribute(name);
	}
	
	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return element.isSelected();
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return element.getText();
	}
	
	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return element.findElements(by);
	}
	
	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return element.findElement(by);
	}
	
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}
	
	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return element.getLocation();
	}
	
	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return element.getSize();
	}
	
	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return element.getRect();
	}
	
	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return element.getCssValue(propertyName);
	}
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return element.getScreenshotAs(target);
	}


	
	/*@Override
	public WebElement findElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<WebElement> findElements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ElementLocator createLocator(Field field) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

}
