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
