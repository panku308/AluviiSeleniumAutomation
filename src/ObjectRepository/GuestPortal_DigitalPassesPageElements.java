package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortal_DigitalPassesPageElements {
	
	
	private static WebElement element = null;

	public static WebElement GetMyDigitalPassesLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Print All Passes']"));
		return element;
	}
	
	

}
