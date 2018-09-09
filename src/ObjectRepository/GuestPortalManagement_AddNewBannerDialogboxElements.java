package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortalManagement_AddNewBannerDialogboxElements {
	

	private static WebElement element = null;

	public static WebElement GetBannerNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("BannerName"));
		return element;
	}
	public static WebElement GetUploadDesktopImageButton(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowPicMonkeyAPIAddDesktop"));
		return element;
	}
	public static WebElement GetUploadMobileImageButton(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowPicMonkeyAPIAddMobile"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.name("Add"));
		return element;
	}
	public static WebElement GetSelectfilesButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select files...']"));		
		return element;
	}
	
	

}
