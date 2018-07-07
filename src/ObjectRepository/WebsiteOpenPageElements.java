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
	public static WebElement GetCategoriesDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='wrap']//a[contains(@href,'/store/shop/categories?')]"));		
		return element;
	}
	
	//----------------categories page elements start------------------------
	public static WebElement GetCategoryFromCategoryList(WebDriver driver, String categoryName)
	{
		element =driver.findElement(By.xpath("//div[@id='category-list-container']//span[.='"+categoryName+"']"));		
		return element;
	}
	//----------------categories page elements End--------------------------
}
