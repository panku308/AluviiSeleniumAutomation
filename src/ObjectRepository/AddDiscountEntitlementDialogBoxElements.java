package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDiscountEntitlementDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("DiscountEntitlementName"));
		return element;
	}
	public static WebElement selectProductType(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Product']"));
		return element;
	}

	public static WebElement selectProductTypeOption(WebDriver driver, String option)
	{			
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='Product']/..//li[contains(text(),'"+option+"')]"));
		return element.get(element.size()-1);
	}
	public static WebElement setDiscountType(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//*[contains(text(),'"+option+"')]//*[@id='DiscountType']"));
		return element;
	}
	public static WebElement getDiscountPercentageField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='divDiscountPercentage']//input[1]"));
		return element;
	}

	public static WebElement setDiscountPercentageField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='divDiscountPercentage']//input[2]"));
		return element;
	}
	public static WebElement getDiscountDollarField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='divDiscountDollar']//input[1]"));
		return element;
	}

	public static WebElement setDiscountDollarField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='divDiscountDollar']//input[2]"));
		return element;
	}
	public static WebElement getExtDescField(WebDriver driver)
	{
		element =driver.findElement(By.id("DiscountEntitlementExternalDesc"));
		return element;
	}
	public static WebElement getSelectDiscountItemButton(WebDriver driver)
	{
		element =driver.findElement(By.id("imgDiscountItem"));
		return element;
	}
	public static WebElement setDiscountItem(WebDriver driver)
	{
		element =driver.findElement(By.xpath("(//*[text()='Category Name']/../../../../../../following-sibling::div//tr//a)[1]"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@name='Create Entitlement']"));
		return element;
	}

}
