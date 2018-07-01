package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMembershipDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetDynamicPassLink(WebDriver driver, String passName)
	{
		element =driver.findElement(By.xpath("//div[@id = 'guestMemberships_listview']//div[ text() = '"+passName+"']"));
		return element;
	}
	public static WebElement GetStaticPassLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'guestMemberships_listview']/div[1]"));
		return element;
	}
	public static WebElement GetSendToCheckoutButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSendToCheckOut"));
		return element;
	}

}
