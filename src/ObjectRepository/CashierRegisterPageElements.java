package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CashierRegisterPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetCategoryElement(WebDriver driver, String CategoryName)
	{
		
		element =driver.findElement(By.xpath("//div[@id='categoryList']//div[text()='"+CategoryName+"']"));
		return element;
	}
	public static WebElement GetCategoryProductElement(WebDriver driver, String ProductName)
	{
		
		element =driver.findElement(By.xpath("//div[@id='productContainer']//span[.='"+ProductName+"']"));
		return element;
	}
	
	public static WebElement GetPayButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnPayment"));
		return element;
	}
}
