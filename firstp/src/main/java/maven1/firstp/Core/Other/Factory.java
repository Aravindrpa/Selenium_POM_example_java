package maven1.firstp.Core.Other;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import maven1.firstp.Core.CustomObjects.BaseElement.Element;

public class Factory extends PageFactory {

	public static void initElements(WebDriver driver, Object object) {
		Field[] fields = object.getClass().getDeclaredFields();

		for (Field field : fields) {
			if(field.getType().getSuperclass() == Element.class)
			{
				field.setAccessible(true);
				String fieldName = field.getName();
				String fieldLocatorValue = "";
				By fieldLocator = null;
				FindBy annotation = field.getAnnotation(FindBy.class);
				if(annotation.how() != How.UNSET)
				{
					try {
		
						switch (annotation.how()) {
						case CLASS_NAME:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.className();
							
							fieldLocator = By.className(fieldLocatorValue);
							
							break;
						case NAME:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.name();
							
							fieldLocator = By.name(fieldLocatorValue);
		
							break;
						case ID:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.id();
							
							fieldLocator = By.id(fieldLocatorValue);
		
							break;
						case CSS:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.css();
							
							fieldLocator = By.cssSelector(fieldLocatorValue);
		
							break;
						case XPATH:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.xpath();
							
							fieldLocator = By.xpath(fieldLocatorValue);
		
							break;
						case LINK_TEXT:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.linkText();
							
							fieldLocator = By.linkText(fieldLocatorValue);
		
							break;
						case PARTIAL_LINK_TEXT:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.partialLinkText();
							
							fieldLocator = By.partialLinkText(fieldLocatorValue);
		
							break;
		//				case ID_OR_NAME:
		//					if(annotation.using() != "")
		//						fieldLocatorValue = annotation.using();
		//					else
		//						fieldLocatorValue = annotation.className();
		//					
		//					fieldLocator = By.(fieldLocatorValue);
		//
		//					break;
						case TAG_NAME:
							if(annotation.using() != "")
								fieldLocatorValue = annotation.using();
							else
								fieldLocatorValue = annotation.tagName();
							
							fieldLocator = By.tagName(fieldLocatorValue);
		
							break;
						default:
							break;
						}
						
					WebElement element = driver.findElement(fieldLocator);
					Object value = field.getType()
							.getDeclaredConstructor(WebElement.class)
							.newInstance(element);
					
					field.set(object, value);
		
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
