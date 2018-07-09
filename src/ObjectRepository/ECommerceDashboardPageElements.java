package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ECommerceDashboardPageElements {
private static WebElement element = null;
	
	public static WebElement GetWebSiteTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket']//a[text()='Website']"));
		return element;
	}
	public static WebElement GetBannersTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket']//a[text()='Banners']"));
		return element;
	}
	public static WebElement GetProductsTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket']//a[text()='Products']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Products(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-3']//div[@id='tabstrip_products']//a[text()='Products']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Products_SelectOptionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_products-1']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Products_ProductNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='productsGrid']//th[@data-title = 'Product Name']/a[1]"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Products_FirstRowProductsNameColumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='productsGrid']//div[@class='k-grid-content']//table//tbody/tr[1]/td[2]"));
		return element;
	}
	
	
	public static WebElement GetProductsTab_SubTab_Categories(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-3']//div[@id='tabstrip_products']//a[text()='Categories']"));
		return element;
	}
	
	public static WebElement GetProductsTab_SubTab_Categories_SelectOptionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_products-2']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Categories_CaetegoryNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='categoriesGrid']//th[@data-title = 'Category Name']/a[1]"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Categories_FirstRowCategoryNameColumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='categoriesGrid']//div[@class='k-grid-content']//table//tbody/tr[1]/td[2]"));
		return element;
	}
	public static WebElement GetSetupTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket']//a[text()='Setup']"));
		return element;
	}
	public static WebElement GetWebsiteTab_SelectOptionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-1']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetWebsiteTab_FirstRowWebsiteNameColumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='websiteGrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	public static WebElement GetWebsiteTab_WebsiteNameClolumnSettingIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='websiteGrid']//th[@data-title = 'Website Name']/a[1]"));
		return element;
	}
	
	

}
