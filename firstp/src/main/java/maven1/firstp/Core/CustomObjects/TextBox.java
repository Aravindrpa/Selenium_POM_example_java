package maven1.firstp.Core.CustomObjects;

import org.openqa.selenium.WebElement;

import maven1.firstp.Core.CustomObjects.BaseElement.Element;

public class TextBox extends Element {
	
	private WebElement element;
	
	public TextBox(WebElement element) {
		super(element);
		this.element = element;
	}
	
//	@Override
//	public void sendKeys(int delayInMilliSeconds,CharSequence... keysToSend) {
//		
//		System.out.println("In TB");
//		
//			for(int i=0;i<keysToSend.length-1;i++)
//			{
//				try {
//					Thread.sleep(delayInMilliSeconds);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				this.element.sendKeys(keysToSend[i]);
//			}
//			
//		}
}
