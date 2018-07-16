package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDiscountPackageDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getDiscountPackageName(WebDriver driver)
	{
		element =driver.findElement(By.id("DiscountPackageName"));
		return element;
	}
	
	
	public static WebElement getUsesAllowedPerTransactionField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Uses Allowed Per Transaction']/..//input[1]"));
		return element;
	}
	
	public static WebElement setUsesAllowedPerTransaction(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Uses Allowed Per Transaction']/..//input[2]"));
		return element;
	}
	
	
	public static WebElement getDateofFirestUseField(WebDriver driver)
	{
		element =driver.findElement(By.id("DateOfFirstUse"));
		return element;
	}
	public static WebElement getExpirationDateField(WebDriver driver)
	{
		element =driver.findElement(By.id("ExpirationDate"));
		return element;
	}
	public static WebElement getPackageDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("PackageDescription"));
		return element;
	}
	
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.id("add"));
		return element;
	}
	
	public static WebElement getColumn_DiscountRuleName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='gridProduct']//*[text()='Discount Rule Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement selectDiscountRule(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("(//*[text()='Discount Rule Name']/../../../../../../..//div[2]//tr)//a"));
		return  element.get(element.size()-1);
	}
	
	public static WebElement GetSaveChangesButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@value='Save Changes']"));
		return element;
	}

}
