package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPackageDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getPackageNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("PackageName"));
		return element;
	}
	
	public static WebElement getDisplayPrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Display Price *')]/following-sibling::span//input[1]"));
		return element;
	}
	
	public static WebElement setDisplayPrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Display Price *')]/following-sibling::span//input[2]"));
		return element;
	}
	
	public static WebElement selectLocation(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']"));
		return element;
	}

	public static WebElement selectLocationOption(WebDriver driver, String Location)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']/..//li[text()='"+Location+"']"));
		return element;
	}
	
	
	public static WebElement getSelectAssignmentButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='PackageAssignmentList_taglist']/..//input"));
		return element;
	}
	
	public static WebElement setAssignmentFromList(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='PackageAssignmentList_listbox']//li[contains(text(),'"+name+"')]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getPriceRuleButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='PackagePriceTierList_taglist']/..//input"));
		return element;
	}
	
	public static WebElement setPriceRuleFromList(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='PackagePriceTierList_listbox']//li[contains(text(),'"+name+"')]"));
		return element.get(element.size()-1);
	}

	
	public static WebElement getShortDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Short Package Description *']/..//input"));
		return element;
	}
	
	public static WebElement getFullDescriptionField(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("//*[text()='Full Length Description *']/..//*[@id='Description']"));
		element=driver.switchTo().activeElement();
		return element;
	}
	
	
	public static WebElement getSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Submit"));
		return element;
	}

	
}
