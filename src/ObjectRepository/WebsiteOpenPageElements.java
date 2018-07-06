package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebsiteOpenPageElements {
private static WebElement element = null;
	
	public static WebElement GetCategoriesField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='navbar-collapse']//li[3]/a"));		
		return element;
	}
	public static WebElement GetSearchField(WebDriver driver)
	{
		element =driver.findElement(By.id("searchQueryInput"));		
		return element;
	}
	public static WebElement GetShopAllProductButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[text()='SHOP ALL PRODUCTS']"));		
		return element;
	}
	public static WebElement GetReturntToWebsite(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[text()='Return to Website ']"));		
		return element;
	}
	public static WebElement GetManageMyAccountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("lnkManageMyAccount"));		
		return element;
	}
	
}
