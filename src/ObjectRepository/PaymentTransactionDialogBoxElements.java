package ObjectRepository;

import javax.sql.rowset.spi.TransactionalWriter;

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
	public static WebElement GetMoreOptoin_StoredValue(WebDriver driver)
	{
		element =driver.findElement(By.id("spn_StoredValue"));
		return element;
	}
	public static WebElement GetMoreOptoin_PrepaidCouopon(WebDriver driver)
	{
		element =driver.findElement(By.id("spn_1"));
		return element;
	}
	public static  WebElement GetTransactionTitle(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindow_wnd_title"));
		return element;
	} 
	public static String GetTransactionID(WebDriver driver)
	{
		String TransactionID="", TransactionTitle = GetTransactionTitle(driver).getText().trim();
		TransactionID = TransactionTitle.substring(TransactionTitle.indexOf("#")+1, TransactionTitle.length());
		return TransactionID;
	}
	public static WebElement getTotalDueField(WebDriver driver)
	{
		
		element =driver.findElement(By.id("grandTotal"));
		return element;
	}
}
