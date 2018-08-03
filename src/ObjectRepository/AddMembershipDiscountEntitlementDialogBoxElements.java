package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMembershipDiscountEntitlementDialogBoxElements {
	private static WebElement element = null;


	public static WebElement GetSelectDiscountEntitlementButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Discount Item']"));
		return element;
	}
	public static WebElement selectDiscountEntitlement(WebDriver driver, String option)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlDiscountEntitlement_listbox']//li[contains(text(),'"+option+"')]"));
		return element.get(element.size()-1);
	}
	public static WebElement GetAddDiscountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}

}
