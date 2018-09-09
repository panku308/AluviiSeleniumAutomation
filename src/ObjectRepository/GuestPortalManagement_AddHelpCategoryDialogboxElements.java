package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortalManagement_AddHelpCategoryDialogboxElements {
	
	private static WebElement element = null;

	public static WebElement GetCaetgoryNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("CategoryName"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}	

}
