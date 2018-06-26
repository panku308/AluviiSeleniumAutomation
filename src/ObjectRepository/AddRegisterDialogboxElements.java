package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRegisterDialogboxElements {
private static WebElement element = null;
	
	public static WebElement GetRegisterNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("CustomRegisterName"));
		return element;
	}
	public static WebElement GetLocationDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-lg']//span[.='Select Location']"));
		return element;
	}
	public static WebElement GetThermalReceiptDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-lg']//span[.='Select Thermal Receipt']"));
		return element;
	}
	public static WebElement GetAdvancedReceiptDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-lg']//span[.='Select Advanced Thermal Receipt']"));
		return element;
	}
	public static WebElement GetEmailReceiptDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-lg']//span[.='Select Email Receipt']"));
		return element;
	}
	public static WebElement GetEmailConfigurationDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-lg']//span[.='Select Configuration']"));
		return element;
	}
	public static void SelectFirstOptionFromLocationDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='LocationId_listbox']//li[1]")).click();
	}
	public static void SelectFirstOptionFromThermalReceiptDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='ThermalId_listbox']//li[1]")).click();
	}
	public static void SelectFirstOptionFromAdvancedReceiptDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='AdvancedThermalId_listbox']//li[1]")).click();
	}
	public static void SelectFirstOptionFromEmailReceiptDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='EmailId_listbox']//li[1]")).click();
	}
	public static void SelectFirstOptionFromEmailConfigurationDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='EmailConfigurationType_listbox']//li[1]")).click();
	}
	public static WebElement GetAddCategoryButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddCategory"));
		return element;
	}
	public static WebElement GetSaveChangesButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}

}
