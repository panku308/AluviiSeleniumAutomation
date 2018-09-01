package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProduct_Ecommerce_DialogboxElements {


private static WebElement element = null;
	
	
	public static WebElement GetProductName(WebDriver driver)
	{
		element =driver.findElement(By.id("ProductName"));		
		return element;
	}
	public static WebElement GetSelectProductTypeDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns = 'ProductType_listbox']/span/span[2]"));		
		return element;
	}
	public static WebElement GetSelectProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns = 'ProductTypeBasedId_listbox']/span/span[2]"));		
		return element;
	}
	public static WebElement GetWebsiteDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns = 'WebsiteId_listbox']/span/span[2]"));		
		return element;
	}
	public static WebElement GetCategoryDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns = 'CategoryId_listbox']/span/span[2]"));		
		return element;
	}
	public static WebElement GetDigitalProductTypeDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns = 'DigitalProductType_listbox']/span/span[2]"));		
		return element;
	}
	public static WebElement GetDigitalProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns = 'DigitalProductId_listbox']/span/span[2]"));		
		return element;
	}
	public static WebElement GetPriceField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text() =  'Price']// following::span/span/input[1]"));		
		return element;
	}
	public static WebElement GetSalePriceField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text() =  'Sale Price']// following::span/span/input[1]"));		
		return element;
	}
	public static WebElement GetEcommerceProductUploadButton(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowPicMonkeyAPIAddEcommerceProduct"));		
		return element;
	}
	public static WebElement GetEcommerceProductThumbnailUploadButton(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowPicMonkeyAPIAddEcommerceProductThumbnail"));		
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));		
		return element;
	}
	public static WebElement GetSelectfilesButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select files...']"));
		
		return element;
	}
	public static WebElement GetOutOfStockCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text()='Out of Stock']"));		
		return element;
	}
	public static WebElement GetOnSaleCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text()='ON SALE']"));		
		return element;
	}
	public static WebElement GetIncludeTransactionFeeCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text()='Include Transaction Fee']"));		
		return element;
	}
	public static WebElement GetProductUpdateMessagae(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='divMsgProp']/h5"));		
		return element;
	}
	



}
