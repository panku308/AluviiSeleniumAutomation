package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMembershipEntranceEntitlementDialogBoxElements {
	private static WebElement element = null;


	public static WebElement GetSelectEntranceEntitlementButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Entitlement']"));
		return element;
	}
	public static WebElement selectEntranceEntitlement(WebDriver driver, String option)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlEntranceEntitlement_listbox']//li[text()='"+option+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement GetAddEntranceButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}

}
