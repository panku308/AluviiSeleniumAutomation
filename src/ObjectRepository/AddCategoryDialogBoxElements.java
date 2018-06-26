package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCategoryDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetCategoryNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("CategoryName"));
		return element;
	}
	public static WebElement GetCategoryDescField(WebDriver driver)
	{
		element =driver.findElement(By.id("CategoryDescription"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.name("Add"));
		return element;
	}

}
