package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTaxOptionDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getTaxOptionName(WebDriver driver)
	{
		element =driver.findElement(By.id("TaxOptionName"));
		return element;
	}
	public static WebElement selectLocation(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']"));
		return element;
	}

	public static WebElement selectLocationOption(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']/..//li[contains(text(),'"+option+"')]"));
		return element;
	}
	public static WebElement getTaxRate(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Tax Rate')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setTaxRate(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Tax Rate')]/following-sibling::span//input[2]"));
		return element;
	}
	public static WebElement getDescField(WebDriver driver)
	{
		element =driver.findElement(By.id("TaxOptionDescription"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}

}
