package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBookingDialogboxElements {
	

	
	private static WebElement element = null;
	
	public static WebElement GetFromDateTextField(WebDriver driver)
	{
		element =driver.findElement(By.id("fromDate"));		
		return element;
	}
	
	public static WebElement GetToDateTextField(WebDriver driver)
	{
		element =driver.findElement(By.id("toDate"));		
		return element;
	}

	public static WebElement GetSearchButtonField(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSearchBookings"));		
		return element;
	}

}
