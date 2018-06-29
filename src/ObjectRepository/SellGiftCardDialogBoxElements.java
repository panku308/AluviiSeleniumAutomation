package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SellGiftCardDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetGiftCardBarcode(WebDriver driver)
	{
		
		element =driver.findElement(By.id("txtBarcode"));
		return element;
	}
	public static WebElement GetGiftCardTypeDD(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//span[text() .= 'Gift Card']"));
		return element;
	}
	public static WebElement GetBarCodeTypeDD(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//span[text() .= 'Membership']"));
		return element;
	}
	public static WebElement GetGiftCardAmount(WebDriver driver)
	{
		
		element =driver.findElement(By.id("txtGiftCardAmount"));
		return element;
	}
	public static WebElement GetAddToCardButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnSubmit"));
		return element;
	}

}
