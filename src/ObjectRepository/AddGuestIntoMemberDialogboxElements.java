package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddGuestIntoMemberDialogboxElements {

private static WebElement element = null;
	
	 
	public static WebElement GetLoadDataButton(WebDriver driver)
	{
		element =driver.findElement(By.id("GetGuestAccountDetails"));
		return element;
	}
	
	public static WebElement GetFirstNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("FirstName"));
		return element;
	}
	public static WebElement GetLastNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("LastName"));
		return element;
	}

	public static WebElement GetBirthDate(WebDriver driver)
	{
		element =driver.findElement(By.id("BirthDate"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.name("Add"));
		return element;
	}

}
