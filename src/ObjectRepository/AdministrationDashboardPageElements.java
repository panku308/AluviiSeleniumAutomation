package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdministrationDashboardPageElements {
private static WebElement element = null;
	
	public static WebElement GetConfigurationTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Configuration"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayProcessorDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='topmargin-10']//span[@aria-owns='GatewayProcessorId_listbox']/span/span[1]"));
                                                    		
		
		return element;
	}
	public static WebElement getLocation_subTaxOptionTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Tax Option"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayActionURLField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtActionUrl"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayOnlineKeyField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtOnlineKey"));
		return element;
	}
	public static WebElement GetConfigTab_SaveChangesButton(WebDriver driver)
	{
		element =driver.findElement(By.id("updateApplicationConifguration"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayOnlinePin(WebDriver driver)
	{
		element =driver.findElement(By.id("txtOnlinePin"));
		return element;
	}
	public static WebElement GetConfigTab_USAePaySandboxRadiobutton(WebDriver driver)
	{
		element =driver.findElement(By.id("GatewayMode1"));
		return element;
	}
	
	public static WebElement getLocationTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Location"));
		return element;
	}
	
	public static WebElement getLocation_subLocationTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='tabstrip_location']/ul/li[1]/a"));
		return element;
	}
	
	public static WebElement getLocation_subDepartmentTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Department"));
		return element;
	}
	
	public static WebElement getLocation_subSiteTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Site"));
		return element;
	}
	public static WebElement getLocationSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip_location-1']//*[text()='Select Option']"));
		return element;
	}
	public static WebElement getDepartmentSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip_location-2']//*[text()='Select Option']"));
		return element;
	}
	public static WebElement getSiteSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip_location-3']//*[text()='Select Option']"));
		return element;
	}
	public static WebElement getTaxOptionSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip_location-4']//*[text()='Select Option']"));
		return element;
	}
	public static WebElement getLocationSelectOptionDropdownList(WebDriver driver, String list)
	{
	
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlLocationOptions_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement getDepartmentSelectOptionDropdownList(WebDriver driver, String list)
	{
	
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlDepartmentOptions_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement getSiteSelectOptionDropdownList(WebDriver driver, String list)
	{
	
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlSiteOptions_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement getTaxSelectOptionDropdownList(WebDriver driver, String list)
	{
	
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlTaxOptionOptions_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getColumn_LocationName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='gridLocation']//*[text()='Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getLocationNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='gridLocation']//td[2]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_DepartmentName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='gridDepartment']//*[text()='Department Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getDepartmentNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='gridDepartment']//td[2]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_SiteName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='gridSite']//*[text()='Site Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getSiteNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='gridSite']//td[2]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_TaxOptionName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='gridTaxOption']//*[text()='Tax Option Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getTaxOptionNameNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='gridTaxOption']//td[2]"));
		return element.get(element.size()-1);
	}
	
}
