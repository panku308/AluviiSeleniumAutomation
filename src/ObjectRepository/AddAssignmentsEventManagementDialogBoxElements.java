package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAssignmentsEventManagementDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getAssignmentNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtVenName"));
		return element;
	}
	
	public static WebElement getCategoryButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Category']/../..//*[text()='Select Category']"));
		return element;
	}
	
	public static WebElement setCategory(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlCategory_listbox']//li[text()='"+name+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement getLocationButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Location']/../..//*[text()='Select Location']"));
		return element;
	}
	
	public static WebElement setLocation(WebDriver driver, String option)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlLocation_listbox']//li[text()='"+option+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement getTaxOptionButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='TaxOptionList_taglist']/..//input"));
		//element =driver.findElement(By.xpath("//*[text()='Tax Option']/../..//*[text()='Select Tax']"));
		return element;
	}
	
	public static WebElement setTaxOption(WebDriver driver, String option)
	{
		List<WebElement> element;
		//element =driver.findElements(By.xpath("//*[@id='TaxOptionId_listbox']//li[text()='"+option+"']"));
		element =driver.findElements(By.xpath("//*[@id='TaxOptionList_listbox']//li[text()='"+option+"']"));
		return element.get(element.size()-1);
		
	}
	public static WebElement getSiteButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='SiteIdList_taglist']/..//input"));
		return element;
	}
	
	public static WebElement setSiteOption(WebDriver driver, String option)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='SiteIdList_listbox']//li[text()='"+option+"']"));
		return element.get(element.size()-1);
	}
	public static WebElement getscheduleOptionButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Schedule']/../..//*[text()='Select Schedule']"));
		return element;
	}
	
	public static WebElement setScheduleOption(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlSchedule_listbox']//li[contains(text(),'"+name+"')]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getCapacity(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Capacity')]/../..//input[1]"));
		return element;
	}
	
	public static WebElement setCapacity(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Capacity')]/../..//input[2]"));
		return element;
	}
	
	public static WebElement setExclusiveUse(WebDriver driver)
	{
		element =driver.findElement(By.id("cbxExcl"));
		return element;
	}
	public static WebElement setViewOnEventPortal(WebDriver driver)
	{
		element =driver.findElement(By.id("EventAssignment-IsValidForEventPortal"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@value='Add']"));
		return element;
	}

	
}
