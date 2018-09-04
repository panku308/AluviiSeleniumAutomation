package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebsiteOpenPageElements {
private static WebElement element = null;
private static String ProductID="";
	
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
		ProductID=str2;
		element = driver.findElement(By.xpath("//span[@data-product-id='"+str2+"']"));
		return element;
	}
	public static WebElement GetCaetgoryProductOutofStockMessage(WebDriver driver, String ProductName)
	{	
		element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']/../following-sibling::span[@class='text-danger out-stock-msg']"));
		//element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']"));
		return element;
	}
	public static WebElement GetProductSalePrice(WebDriver driver, String ProductName)
	{	
		element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']/following::span[@class='product-price']"));
		//element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']"));
		return element;
	}
	public static WebElement GetCartTotal(WebDriver driver)
	{	
		element = driver.findElement(By.id("cartTotal"));		
		return element;
	}
	public static WebElement GetBtnClearCart(WebDriver driver)
	{	
		element = driver.findElement(By.id("btnClearCart"));		
		return element;
	}
	public static WebElement GetProductOldPrice(WebDriver driver, String ProductName)
	{	
		element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']/following::span[@class='old-price']"));
		//element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']"));
		return element;
	}
	public static WebElement GetProductPriceOnMiniCart(WebDriver driver, String ProductName)
	{	
		element = driver.findElement(By.xpath("//div[@id='mini-cart']//div[@class='mc-content']/div[@class='mc-products']/span[@class='price']"));
		//element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']"));
		return element;
	}
	public static WebElement GetTransactionFees(WebDriver driver)
	{	
		element = driver.findElement(By.xpath("//div[@id='FeeDetailPrice']//span[@class='price']"));
		//element = driver.findElement(By.xpath("//div[@id='product-list-container']//a[text() ='"+ProductName+"']"));
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
	public static WebElement GetPriceField(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//table[@id='eCartTable']/tbody/tr/td[3]/span/span"));		
		return element;
	}
	//------------------------------ Product session window elements-------------------------------
	public static WebElement GetProductSessionWindow_FirstProductQuantityField(WebDriver driver,String product)
	{
		element =driver.findElement(By.xpath("//input[contains(@id, 'txtProductGroupQuantity') and @data.productname='"+product+"']"));
		return element;
	}
	public static WebElement GetProductSessionWindow_FirstTimeSlot(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='dvTimeSlots']/div[1]/div[2]/span"));
		return element;
	}
	public static WebElement GetProductSessionWindow_AddToCartButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddToCart"));
		return element;
	}
	public static WebElement GetProductSessionWindow_FirstnameField(WebDriver driver, String ProductName, String ParticipantCount)
	{
		element =driver.findElement(By.id("txtParticipantFirstName-"+ProductID+"-"+ParticipantCount));
		return element;
	}
	public static WebElement GetProductSessionWindow_LastnameField(WebDriver driver, String ProductName, String ParticipantCount)
	{
		element =driver.findElement(By.id("txtParticipantLastName-"+ProductID+"-"+ParticipantCount));
		return element;
	}
	
	
}
