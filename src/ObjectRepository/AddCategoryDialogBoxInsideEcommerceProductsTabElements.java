package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCategoryDialogBoxInsideEcommerceProductsTabElements {
private static WebElement element = null;
	
	public static WebElement GetCategoryName(WebDriver driver)
	{
		element =driver.findElement(By.id("CategoryName"));
		return element;
	}
	public static WebElement GetWebsiteDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='container-popup']//span[@aria-owns='WebsiteId_listbox']/span/span[2]"));
		
		return element;
	}
	public static WebElement GetUploadButton(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowPicMonkeyAPIForAdd"));
		
		return element;
	}
	public static WebElement GetSelectfilesButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select files...']"));
		
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));		
		return element;
	}

}
