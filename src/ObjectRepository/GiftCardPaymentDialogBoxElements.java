package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardPaymentDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetGiftCardBarcode(WebDriver driver)
	{
		element =driver.findElement(By.id("giftCardBarcode"));
		return element;
	}
	public static WebElement GetBalanaceButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnGetBalance"));
		return element;
	}
	public static WebElement GetPayWithGiftCardButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnPayment"));
		return element;
	}

}
