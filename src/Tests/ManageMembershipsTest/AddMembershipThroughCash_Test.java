package Tests.ManageMembershipsTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddMembershipDialogBoxElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.SignWaiverPageElements;
import ObjectRepository.SimpleCashPaymentDialogBox;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddMembershipThroughCash_Test {
	  public static WebDriver driver=null;
	  public static boolean actualResult=false;
	  public static String EmailID="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void AddMembership_cashPayment() throws Exception
	  {
		  int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, CreateMemberTest.EmailID);
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
			  
			  PaymentTransactionDialogBoxElements.GetCashButton(driver).click();
			  Thread.sleep(2000);
			  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));		  
			  System.out.println("iframe length = " + iframeElements.size());		  
			  driver.switchTo().frame(0);
			  
			  System.out.println("total due = "+ SimpleCashPaymentDialogBox.GetTotalDueField(driver).getAttribute("value"));
			  SimpleCashPaymentDialogBox.GetCashReceivedField(driver).sendKeys(SimpleCashPaymentDialogBox.GetTotalDueField(driver).getAttribute("value"));
			  SimpleCashPaymentDialogBox.GetSubmitButton(driver).click();		  
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
