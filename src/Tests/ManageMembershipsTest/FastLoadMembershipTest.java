package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditNewAccountDialogBoxElements;
import ObjectRepository.FastLoadMembershipDialogBoxElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.SimpleCashPaymentDialogBox;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class FastLoadMembershipTest {

	public static WebDriver driver=null;
	
	public static String EmailID="selenium1535798183151@gmail.com";


	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;

	}
	@Test
	public void fastLoadMembershipTest() throws Exception
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);

		int columnIndex;

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		ManageMembershipsPageElements.getFilteredColumn(driver, 1).click();
		Thread.sleep(2000); 
		
		
		ManageMembershipsPageElements.getFastLoadMembershipButton(driver).click();
		Thread.sleep(2000); 
		
		CommonFunctions.SwitchToContentFrame(driver);
		
		FastLoadMembershipDialogBoxElements.getSeasonPassButton(driver).click();
		Thread.sleep(3000);
		FastLoadMembershipDialogBoxElements.selectOwner(driver);
		Thread.sleep(2000); 
		FastLoadMembershipDialogBoxElements.getSendToCheckoutButton(driver).click();
		Thread.sleep(2000); 
		driver.switchTo().defaultContent();
		Thread.sleep(2000); 
		
		ManageMembershipsPageElements.GetCheckoutTab_PaymentButton(driver).click();
		Thread.sleep(2000); 
		CommonFunctions.SwitchToContentFrame(driver);
		Thread.sleep(2000); 
		PaymentTransactionDialogBoxElements.GetCashButton(driver).click();
		Thread.sleep(4000); 
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='Simple Cash Payment']")));
		SimpleCashPaymentDialogBox.GetCashReceivedField(driver).sendKeys("800");
		Thread.sleep(2000); 
		SimpleCashPaymentDialogBox.GetSubmitButton(driver).click();
		
		Thread.sleep(2000); 
		driver.switchTo().defaultContent();
		CommonFunctions.SwitchToContentFrame(driver);
		PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();
		Thread.sleep(5000); 
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='Fast Load Membership']")));
		ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		
		Thread.sleep(2000); 
		driver.switchTo().defaultContent();
		
		Assert.assertTrue(ManageMembershipsPageElements.IsSeasonPassAvailable(driver));
		
	}

}
