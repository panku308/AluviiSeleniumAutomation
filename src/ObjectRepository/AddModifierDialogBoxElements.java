package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddModifierDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetModifierName(WebDriver driver)
	{
		element =driver.findElement(By.id("ModifierName"));
		return element;
	}
	public static WebElement GetModifierTypeDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='ModifierType_listbox']"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.id("AddModifierDetails"));
		return element;
	}
	public static WebElement GetClearAllFiltersOption(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@value='Clear All Filters']"));
		return element;
	}
	public static WebElement GetModifierValueColumn(WebDriver driver,int row)
	{
		//element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[2]/input[@id='ModifierDetailValue']"));
		element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[2]"));
		return element;
	}
	public static WebElement GetPriceAdjustmentColumn(WebDriver driver,int row)
	{
		//element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[3]/input[@id='PriceAdjustment']"));
		element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[3]"));
		return element;
	}
	public static WebElement GetProductOrGroupColumn(WebDriver driver,int row)
	{
		//element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[4]//span[text()='Select Product Or Group']"));
		element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[4]"));
		return element;
	}
	public static WebElement GetQuantityColumn(WebDriver driver,int row)
	{
		//element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[5]/input[@id='Quantity']"));
		element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[5]"));
		return element;
	}
	public static WebElement GetAddOrRemoveColumn(WebDriver driver,int row)
	{
		//element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[6]//span[text()='Add']"));
		element =driver.findElement(By.xpath("//div[@id='modifierDetailGrid']//table/tbody/tr["+row+"]/td[6]"));
		return element;
	}
	public static void SelectFirstOptionFromProductOrGroupDropdown(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='ProductName_listbox']//li[1]")).click();
	}
	public static void SelectDynamicOptionFromProductOrGroupDropdown(WebDriver driver,String str)
	{
		driver.findElement(By.xpath("//*[@id='ProductName_listbox']//li[text()='"+str+"']")).click();
	}
	public static void SelectDynamicOptionFromAddOrRemoveDD(WebDriver driver, String str)
	{
		driver.findElement(By.xpath("//*[@id='AddOrRemove_listbox']//li[text()='"+str+"']")).click();
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}
	
}
