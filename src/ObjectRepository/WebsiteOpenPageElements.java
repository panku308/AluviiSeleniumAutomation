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
	//----------------categoriesProduct page elements start------------------------
	public static WebElement GetCaetgoryProduct(WebDriver driver, String ProductName)
	{
		element =driver.findElement(By.xpath("//a[text() ='"+ProductName+"']"));		
		return element;
	}
	public static WebElement GetCaetgoryProductAddToCartButton(WebDriver driver, String ProductName)
	{	
		String str = driver.findElement(By.xpath("//a[text() ='"+ProductName+"']")).getAttribute("href"); 
		String str1 = str.substring(str.indexOf("productId"),str.length());
		String str2 = str1.substring(str1.indexOf("=")+1,str1.length());
		element = driver.findElement(By.xpath("//span[@data-product-id='"+str2+"']"));
		
				
		return element;
	}
	//----------------categoriesProduct page elements End------------------------
	public static void SelectCategory(WebDriver driver, String categoryName)
	{
		driver.findElement(By.xpath("//li/a[text()='"+categoryName+"']")).click();
	}
	public static WebElement GetMiniCartCheckoutButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='mini-cart']//a[@id='mc-btn-checkout']"));
		return element;
	}
	public static WebElement GetGuestCheckOutButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//h3[text() = 'Guest Checkout']/following::span"));
		return element;
	}
	public static WebElement GetGuestFirstnameField(WebDriver driver)
	{
		element = driver.findElement(By.id("FirstName"));
		return element;
	}
	public static WebElement GetGuestLastNameField(WebDriver driver)
	{
		element = driver.findElement(By.id("LastName"));
		return element;
	}
	public static WebElement GetGuestEmailField(WebDriver driver)
	{
		element = driver.findElement(By.id("PrimaryEmail"));
		return element;
	}
	public static WebElement GetGuestContinueButton(WebDriver driver)
	{
		element = driver.findElement(By.id("btnContinueAsGuest"));
		return element;
	}
	public static WebElement GetPaymentSuccessMessage(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		return element;
	}
	public static WebElement GetQuantityField(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//table[@id='eCartTable']/tbody/tr/td[2]/input"));		
		return element;
	}
	
}
