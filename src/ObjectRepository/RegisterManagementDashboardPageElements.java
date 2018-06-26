package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterManagementDashboardPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetProductsTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Products"));
		return element;
	}
	public static WebElement GetRegistersTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip']//a[.='Registers']"));
		return element;
	}
	public static WebElement GetRegistersTab_subtab_Registers(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip-1']//a[.='Registers']"));
		return element;
	}
	public static WebElement GetProductsTab_subtab_Products(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product']//li/a[.='Products']"));
		return element;
	}
	public static WebElement GetProductsTab_subtab_Categories(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product']//li/a[.='Categories']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Products_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product-1']//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Categories_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product-2']//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetRegistersTab_SubTab_Registers_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_registers-1']//span[.='Select Option']"));
		return element;
	}
	public static WebElement SelectOptionFromSelectOptionDD(WebDriver driver, String OptName)
	{
		element =driver.findElement(By.xpath("//li[text() = '"+OptName+"']"));
		return element;
	}
	
	public static WebElement Get_ProductTable_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='productsgrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement Get_ProductTable_FirstRowProductNameCloumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='productsgrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	public static WebElement Get_ProductTab_SubTab_Categories_CategoryTable_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='categoryGrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement Get_ProductTab_SubTab_Categories_CategoryTable_FirstRowProductNameCloumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='categoryGrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	
	public static WebElement GetRegistersTab_SubTab_Registers_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='RegisterGrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement GetRegistersTab_SubTab_Registers_FirstRowRegisterNameCloumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='RegisterGrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}


}
