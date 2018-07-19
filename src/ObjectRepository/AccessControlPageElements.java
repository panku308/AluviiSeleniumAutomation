package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessControlPageElements {

private static WebElement element = null;
	
	
	public static WebElement GetAccessTypeDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='AccessType_listbox']"));
		return element;
	}
	public static WebElement GetSearchBarcodeField(WebDriver driver)
	{
		element =driver.findElement(By.id("BarcodeNumber"));
		return element;
	}
	public static WebElement GetScanButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnScan"));
		return element;
	}
	public static WebElement GetAllowCheckSumCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.id("chkAllowCheckSum"));
		return element;
	}
	public static WebElement GetApprovedOrDeniedMessage(WebDriver driver)
	{
		element =driver.findElement(By.id("ApprovedOrDenied"));
		return element;
	}
	public static List GetLiTagsOfAccessTypeDD(WebDriver driver)
	{
		List<WebElement> liTag =driver.findElements(By.xpath("//ul[@id='AccessType_listbox']/li"));
		return liTag;
	}
	public static WebElement GetBarcodeExpMessage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='ScriptArea']"));
		return element;
	}
}
