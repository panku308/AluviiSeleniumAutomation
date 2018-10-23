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
	public static void SearchBookings(WebDriver driver, String fromDate, String toDate) throws InterruptedException
	{
		GetFromDateTextField(driver).clear();
		GetFromDateTextField(driver).sendKeys(fromDate);
		Thread.sleep(1000);
		GetToDateTextField(driver).click();
		GetToDateTextField(driver).clear();
		GetToDateTextField(driver).sendKeys(toDate);
		GetSearchButtonField(driver).click();		
		
	}
	

}
