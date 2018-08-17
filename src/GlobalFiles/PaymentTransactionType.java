package GlobalFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.CardKnoxDialogBoxElements;
import ObjectRepository.GiftCardPaymentDialogBoxElements;
import ObjectRepository.PaymentThroughCreditCardDialogBoxElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.PrePaidCouponDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.SimpleCashPaymentDialogBox;
import ObjectRepository.StoredValueDialogBoxElements;
import Tests.ManageMembershipsTest.CreateMemberTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
import Tests.SellProductTest.SellGiftCard_Cash_Test;

public class PaymentTransactionType {
	
	public static void PaymentThroughStoredValue(WebDriver driver) throws Exception
	{		
		try
		{
			PaymentTransactionDialogBoxElements.GetMoreButton(driver).click();
			  Thread.sleep(2000);
			  PaymentTransactionDialogBoxElements.GetMoreOptoin_StoredValue(driver).click();
			  Thread.sleep(5000);
			  CommonFunctions.SwitchToContentFrame(driver);
		}
		catch(Exception e)
		{
			
		}
		  
		  
		  StoredValueDialogBoxElements.GetSearchUserAccountField(driver).sendKeys(CreateMemberTest.fname);
		  Thread.sleep(2000);
		  StoredValueDialogBoxElements.GetSearchIconField(driver).click();
		  Thread.sleep(2000);
		  StoredValueDialogBoxElements.GetSearchRecordElement(driver).click();
		  Thread.sleep(2000);
		  StoredValueDialogBoxElements.GetUseValueButton(driver).click();
		  Thread.sleep(5000);
		  try
		  {
			  driver.switchTo().parentFrame();
			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(10000);  
		  }
		  catch (Exception e)
		  {
			  
		  }
		  
			
	}
	public static void PaymentThroughCardKnox(WebDriver driver) throws InterruptedException
	{
		try
		{
			PaymentTransactionDialogBoxElements.GetCreditCardButton(driver).click();
			Thread.sleep(2000);
			CommonFunctions.SwitchToContentFrame(driver);
		}
		catch(Exception e)
		{
			
		}
		
		
		CardKnoxDialogBoxElements.GetCardNumberField(driver).sendKeys("4111111111111111");
		CommonFunctions.SelectOptionFromDropdownByValue(CardKnoxDialogBoxElements.GetMonthDD(driver), "12");
		CommonFunctions.SelectOptionFromDropdownByValue(CardKnoxDialogBoxElements.GetYearDD(driver), "20");
		CardKnoxDialogBoxElements.GetCVVField(driver).sendKeys("123");
		CardKnoxDialogBoxElements.GetNameOnCardField(driver).clear();
		CardKnoxDialogBoxElements.GetNameOnCardField(driver).sendKeys("test");
		CardKnoxDialogBoxElements.GetSubmitButton(driver).click();
		Thread.sleep(5000);
		try
		  {
			  driver.switchTo().parentFrame();
			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(10000);  
		  }
		  catch (Exception e)
		  {
			  
		  }
		
	}
	public static void PaymentThroughCash(WebDriver driver) throws Exception{
		try {
			PaymentTransactionDialogBoxElements.GetCashButton(driver).click();
			  Thread.sleep(5000);		  	  
			  CommonFunctions.SwitchToContentFrame(driver);
			 
		}catch(Exception e) {
			
		}
		   
		  SimpleCashPaymentDialogBox.GetCashReceivedField(driver).sendKeys(SimpleCashPaymentDialogBox.GetTotalDueField(driver).getAttribute("value"));
		  SimpleCashPaymentDialogBox.GetSubmitButton(driver).click();		  
		  Thread.sleep(5000);
		  try
		  {
			  driver.switchTo().parentFrame();			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(10000);  
		  }
		  catch (Exception e)
		  {
			  
			  
		  }
		  try
		  {
				
			  PaymentTransactionDialogBoxElements.GetSubmitButton_Booking(driver).click();
		  }
		  catch(Exception e) {
			  System.out.println();
		  }
		  
	}
	public static void PaymentThroughCreditCard(WebDriver driver) throws InterruptedException
	{
		try
		{
			PaymentTransactionDialogBoxElements.GetCreditCardButton(driver).click();
			Thread.sleep(2000);
			CommonFunctions.SwitchToContentFrame(driver);
		}
		catch(Exception e)
		{
			
		}
		
		CommonFunctions.SelectOptionFromDropdownByVisibleText(PaymentThroughCreditCardDialogBoxElements.GetCardTypeDD(driver), "Visa");
		PaymentThroughCreditCardDialogBoxElements.GetNameOnCardElement(driver).clear();
		PaymentThroughCreditCardDialogBoxElements.GetNameOnCardElement(driver).sendKeys("asdfasdf");
		PaymentThroughCreditCardDialogBoxElements.GetCardNumberElement(driver).clear();
		PaymentThroughCreditCardDialogBoxElements.GetCardNumberElement(driver).sendKeys("4111111111111111");
		PaymentThroughCreditCardDialogBoxElements.GetCardExpirationDateField(driver).clear();
		PaymentThroughCreditCardDialogBoxElements.GetCardExpirationDateField(driver).sendKeys("1219");
		PaymentThroughCreditCardDialogBoxElements.GetCVVField(driver).clear();
		PaymentThroughCreditCardDialogBoxElements.GetCVVField(driver).sendKeys("123");
		PaymentThroughCreditCardDialogBoxElements.GetProcessPaymentButton(driver).click();
		Thread.sleep(5000);
		try
		  {
			  driver.switchTo().parentFrame();
			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(10000);  
		  }
		  catch (Exception e)
		  {
			  
		  }
			
	}
	public static void PaymentThroughGiftCard(WebDriver driver) throws Exception
	{
		try
		{
			PaymentTransactionDialogBoxElements.GetGiftCardButton(driver).click();
			  Thread.sleep(2000);
			  		  
			  CommonFunctions.SwitchToContentFrame(driver);
				
		}
		catch (Exception e)
		{
			
		}
		  
		  GiftCardPaymentDialogBoxElements.GetGiftCardBarcode(driver).sendKeys(SellGiftCard_Cash_Test.GiftCardBarcode);
		  GiftCardPaymentDialogBoxElements.GetBalanaceButton(driver).click();
		  Thread.sleep(2000);
		  GiftCardPaymentDialogBoxElements.GetPayWithGiftCardButton(driver).click();		  
		  Thread.sleep(5000);
		  try
		  {
			  driver.switchTo().parentFrame();
			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(10000);  
		  }
		  catch (Exception e)
		  {
			  
		  }
	}
	public static void PaymentThroughPrepaidCoupon(WebDriver driver) throws InterruptedException
	{
		try
		{
			PaymentTransactionDialogBoxElements.GetMoreButton(driver).click();
			  Thread.sleep(2000);
			  PaymentTransactionDialogBoxElements.GetMoreOptoin_PrepaidCouopon(driver).click();
			  Thread.sleep(5000);
			  
			  		  
			  CommonFunctions.SwitchToContentFrame(driver);
				
		}
		catch (Exception e)
		{
			
		}
		  
		  PrePaidCouponDialogBoxElements.GetAmountReceivedField(driver).sendKeys(PrePaidCouponDialogBoxElements.GetPaymentAmountField(driver).getAttribute("value"));
		  PrePaidCouponDialogBoxElements.GetSubmitButton(driver).click();		  
		  Thread.sleep(10000); 
		  
		  try
		  {
			  driver.switchTo().parentFrame();
			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(10000);  
		  }
		  catch (Exception e)
		  {
			  
		  }
	}
}
