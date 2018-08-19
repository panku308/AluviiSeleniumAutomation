package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleCashPaymentDialogBox {
	
	private static WebElement element = null;
	public static WebElement GetTotalDueField(WebDriver driver)
	{
		element =driver.findElement(By.id("TotalDue"));
		return element;
	}
	public static WebElement GetCashReceivedField(WebDriver driver)
	{
		element =driver.findElement(By.id("TransactionTotal"));
		//element =driver.findElement(By.id("grandTotal"));
		return element;
	}
	public static WebElement GetChangeNeededField(WebDriver driver)
	{
		element =driver.findElement(By.id("ChangeNeedded"));
		return element;
	}
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnFinalizeTransaction"));
		return element;
	}
	
	
	

}
