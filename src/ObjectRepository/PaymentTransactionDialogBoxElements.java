package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentTransactionDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetCashButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnMakeACashPayment"));
		return element;
	}
	public static WebElement GetCreditCardButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnMakeAnElectronicPayment"));
		return element;
	}
	public static WebElement GetGiftCardButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnGiftCardPayment"));
		return element;
	}
	public static WebElement GetDiscountButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnAddADiscount"));
		return element;
	}
	public static WebElement GetMoreButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("divMoreOption"));
		return element;
	}
	public static WebElement GetTaxExemptButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnTaxExempt"));
		return element;
	}
	public static WebElement GetCompletePaymentButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnCompletePayment"));
		return element;
	}
}
