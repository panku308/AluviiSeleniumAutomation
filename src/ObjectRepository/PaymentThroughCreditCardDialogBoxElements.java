package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentThroughCreditCardDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetCardTypeDD(WebDriver driver)
	{
		
		element =driver.findElement(By.id("payment_type"));
		return element;
	}
	public static WebElement GetNameOnCardElement(WebDriver driver)
	{
		
		element =driver.findElement(By.id("UMname"));
		return element;
	}
	public static WebElement GetCardNumberElement(WebDriver driver)
	{
		
		element =driver.findElement(By.id("cardNumberUSA"));
		return element;
	}
	public static WebElement GetCardExpirationDateField(WebDriver driver)
	{
		
		element =driver.findElement(By.id("UMexpir"));
		return element;
	}
	public static WebElement GetCVVField(WebDriver driver)
	{
		
		element =driver.findElement(By.id("UMcvv2"));
		return element;
	}
	
	public static WebElement GetProcessPaymentButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnsubmit"));
		return element;
	}

}
