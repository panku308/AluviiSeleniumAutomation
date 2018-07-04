package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssignProductModifiersDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetAddModifierToProductElement(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowAddProductModifer"));
		return element;
	}
	public static WebElement GetCreateModifierButton(WebDriver driver)
	{
		element =driver.findElement(By.id("createModifier"));
		return element;
	}
	public static WebElement GetRemoveModifierFromProductButton(WebDriver driver)
	{
		element =driver.findElement(By.id("deleteProductModifier"));
		return element;
	}
	public static WebElement GetCancelButton(WebDriver driver)
	{
		element =driver.findElement(By.id("cancel"));
		return element;
	}

}
