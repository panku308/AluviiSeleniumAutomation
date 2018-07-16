package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddSiteDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetSiteNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("SiteName"));
		return element;
	}
	public static WebElement GetDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("SiteDescription"));
		return element;
	}
	
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
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
	public static WebElement selectDepartment(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Department']"));
		return element;
	}

	public static WebElement selectDepartmentOption(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Department']/..//li[contains(text(),'"+option+"')]"));
		return element;
	}
	
	public static WebElement getCapacity(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Capacity')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setCapacity(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Capacity')]/following-sibling::span//input[2]"));
		return element;
	}

}
