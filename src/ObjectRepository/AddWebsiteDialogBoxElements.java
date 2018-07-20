package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddWebsiteDialogBoxElements {
private static WebElement element = null;
	
	public static WebElement GetWebSiteNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("WebsiteName"));
		return element;
	}
	public static WebElement GetShowCategoriesCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.id("chkShowCategories"));
		return element;
	}
	public static WebElement GetSourceWebsiteURLField(WebDriver driver)
	{
		element =driver.findElement(By.id("SourceWebsiteUrl"));
		return element;
	}
	public static WebElement GetLocationDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-md']//span[.='Select Location']"));
		return element;
	}
	public static WebElement GetEmailRecTemplateDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-md']//span[.='Select Email Receipt Template']"));
		return element;
	}
	public static WebElement GetDisplayRecTemplateDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-md']//span[.='Select Display Receipt Template']"));
		return element;
	}
	public static WebElement GetEmailConfigurationDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='col-md']//span[.='Select Configuration']"));
		return element;
	}
	public static void SelectFirstOptionFromLocationDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='LocationId_listbox']//li[1]")).click();
	}
	public static void SelectDynamicLocation(WebDriver driver, String Location)
	{
		driver.findElement(By.xpath("//*[@id='LocationId_listbox']//li[text()='"+Location+"']")).click();
	}
	public static void SelectOptionFromEmailRecTemplateDD(WebDriver driver, String option)
	{
		driver.findElement(By.xpath("//*[@id='ddEcommerceEmailReceiptTemplate_listbox']//li[text()='"+option+"']")).click();
	}
	public static void SelectOptionFromDisplayRecTemplateDD(WebDriver driver, String option)
	{
		driver.findElement(By.xpath("//*[@id='ddEcommerceDisplayReceiptTemplate_listbox']//li[text()='"+option+"']")).click();
	}
	public static void SelectOptionFromEmailConfigurationDD(WebDriver driver, String option)
	{
		driver.findElement(By.xpath("//*[@id='EmailConfigID_listbox']//li[text()='"+option+"']")).click();
	}
	public static WebElement GetNextButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSubmitWebsite"));
		return element;
	}
	public static WebElement GetColorDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[contains(@aria-label, 'Current selected color is #')]//span[@class='k-icon k-i-arrow-60-down']"));
		return element;
	}
	public static WebElement GetApplyButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[text()='Apply']"));
		return element;
	}
	public static WebElement GetColorInputTextBox(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='k-color-input']/input"));
		return element;
	}
	public static WebElement GetNext_2_Button(WebDriver driver)
	{
		element =driver.findElement(By.name("nextButton"));
		return element;
	}
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.name("saveButton"));
		return element;
	}
}
