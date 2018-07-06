package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEnteranceEntitlementDialogboxElements {

	private static WebElement element = null;
	public static WebElement GetStaticEnteranceEntitlementName(WebDriver driver)
	{						
		element =driver.findElement(By.xpath("//div[contains(@id, 'Entitlement')]//div[@class='k-grid-content']//table/tbody/tr[1]/td[1]/a"));		
		return element;
	}
	public static WebElement GetDynamicEnternaceEntitlementName(WebDriver driver, String EntitlementName)
	{						
		element =driver.findElement(By.xpath("//div[@id='gridEntranceEntitlement']/div[@class='k-grid-content']//a[text() = '"+EntitlementName+"']"));
		return element;
	}
	public static WebElement GetLastPageButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridEntranceEntitlement']//a[@title='Go to the last page']"));
		return element;
	}

}
