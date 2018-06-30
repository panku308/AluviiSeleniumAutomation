package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrePaidCouponDialogBoxElements {

	
	private static WebElement element = null;
	public static WebElement GetPaymentAmountField(WebDriver driver)
	{
		element =driver.findElement(By.id("TotalDue"));
		return element;
	}
	public static WebElement GetAmountReceivedField(WebDriver driver)
	{
		element =driver.findElement(By.id("AmountRcvd"));
		return element;
	}
	public static WebElement GetNoteField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtTenderNote"));
		return element;
	}
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCompleteTransaction"));
		return element;
	}
	



}
