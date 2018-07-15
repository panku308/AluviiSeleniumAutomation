package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEntranceEntitlementDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetEntitlementName(WebDriver driver)
	{
		element =driver.findElement(By.id("EntranceEntitlementName"));
		return element;
	}
	public static WebElement GetLocationDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='LocationId_listbox']/span/span[1]"));
		return element;
	}
	public static WebElement GetDepartmentDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='DepartmentId_listbox']/span/span[1]"));
		return element;
	}
	public static WebElement GetSiteDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='SiteId_listbox']/span/span[1]"));
		return element;
	}
	public static WebElement GetMaxUses(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text()='Max Uses']//following::span/span/input[1]"));
		
		return element;
	}
	public static WebElement GetExternalDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("EntranceEntitlementExternalDesc"));
		
		return element;
	}
	public static WebElement GetInternalDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("EntranceEntitlementInternalDesc"));
		
		return element;
	}
	public static WebElement GetNextButton(WebDriver driver)
	{
		element =driver.findElement(By.name("nextButton"));		
		return element;
	}
	public static void SelectStaticLocation(WebDriver driver)
	{
		driver.findElement(By.xpath("//ul[@id='LocationId_listbox']/li[1]")).click();
	}
	public static void SelectDynamicLocation(WebDriver driver,String Location)
	{
		driver.findElement(By.xpath("//ul[@id='LocationId_listbox']/li[text()='"+Location+"']")).click();
	}
	
	public static void SelectStaticDepartment(WebDriver driver)
	{
		driver.findElement(By.xpath("//ul[@id='DepartmentId_listbox']/li[1]")).click();
	}
	public static void SelectDynamicDepartment(WebDriver driver,String Dept)
	{
		driver.findElement(By.xpath("//ul[@id='DepartmentId_listbox']/li[text()='"+Dept+"']")).click();
	}
	
	public static void SelectStaticSite(WebDriver driver)
	{
		driver.findElement(By.xpath("//ul[@id='SiteId_listbox']/li[1]")).click();
	}
	public static void SelectDynamicSite(WebDriver driver,String Site)
	{
		driver.findElement(By.xpath("//ul[@id='SiteId_listbox']/li[text()='"+Site+"']")).click();
	}
	
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.name("saveButton"));		
		return element;
	}
	
}
