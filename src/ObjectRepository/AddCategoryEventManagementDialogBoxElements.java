package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCategoryEventManagementDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getCategoryNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("Name"));
		return element;
	}
	public static WebElement getCategoryDescField(WebDriver driver)
	{
		element =driver.findElement(By.id("Description"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.name("Add"));
		return element;
	}

}
