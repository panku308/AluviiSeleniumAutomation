package Tests.ManageMembershipsTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddMembershipDialogBoxElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.PrePaidCouponDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.SimpleCashPaymentDialogBox;

public class AddMembershipThroughPrepaidCoupon_Test {
	

	  public static WebDriver driver=null;
	  public static boolean actualResult=false;
	  public static String EmailID="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		  Thread.sleep(5000);
	  }
	  @Test
	  public static void AddMembership_cashPayment() throws Exception
	  {
		  CommonFunctions.Login(driver,CommonFunctions.UserName,CommonFunctions.Password);
		  Thread.sleep(5000);
		  int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, "selenium1530097693202@gmail.com");
		  if(i==1)
		  {
			  actualResult=true;
			  assertEquals(actualResult, true);
			  ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
			  Thread.sleep(4000);
			  ManageMembershipsPageElements.GetAccountGuestAddMembership(driver, 1).click();
			  Thread.sleep(2000);
			  
			  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));			  
			  System.out.println("iframe length = " + iframeElements.size());			  
			  driver.switchTo().frame(0);
			  
			  AddMembershipDialogBoxElements.GetAdventureSeasonPassLink(driver).click();
			  Thread.sleep(2000);
			  AddMembershipDialogBoxElements.GetSendToCheckoutButton(driver).click();
			  Thread.sleep(5000);
			  driver.switchTo().defaultContent();
			  ManageMembershipsPageElements.GetCheckoutTab_PaymentButton(driver).click();
			  Thread.sleep(2000);
			  
			  iframeElements = driver.findElements(By.tagName("iframe"));		  
			  System.out.println("iframe length = " + iframeElements.size());		  
			  driver.switchTo().frame(0);		
			  
			  PaymentTransactionDialogBoxElements.GetMoreButton(driver).click();
			  Thread.sleep(2000);
			  PaymentTransactionDialogBoxElements.GetMoreOptoin_PrepaidCouopon(driver).click();
			  Thread.sleep(5000);
			  
			  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));		  
			  System.out.println("iframe length = " + iframeElements.size());		  
			  driver.switchTo().frame(0);
			  
			  PrePaidCouponDialogBoxElements.GetAmountReceivedField(driver).sendKeys(PrePaidCouponDialogBoxElements.GetPaymentAmountField(driver).getAttribute("value"));
			  PrePaidCouponDialogBoxElements.GetSubmitButton(driver).click();		  
			  Thread.sleep(5000);
			  
			  driver.switchTo().parentFrame();
			  
			  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
			  Thread.sleep(5000);
			  
			  iframeElements1 = driver.findElements(By.tagName("iframe"));		  
			  System.out.println("iframe length = " + iframeElements.size());		  
			  driver.switchTo().frame(0);
			  
			  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
			  assertTrue(true);
			  driver.switchTo().defaultContent();
			  
			  
		  }
		  else
		  {
			  assertEquals(false, true);
		  }
		  
	  }
	

}
