package Tests.ManageMembershipsTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AccessControlPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.MembershipPackagesPageElements;
import ObjectRepository.SelectEntitlementDialogboxInsideManageMembershipElements;
import Tests.MembershipPackagesTest.CreateeEntranceEntitlementTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class PunchPassScanTest {
	  public static WebDriver driver=null;
	  public static boolean actualResult=false;
	  public static String ExpCount="", ActCount="";
	  public static String Barcode="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void Verify10PunchPassScan()throws Exception
	  {
		  int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, CreateMemberTest.EmailID);
		 // int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, "shawnmiles13@gmail.com");
		  if(i==1)
		  {
			  assertTrue(true);
			  ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
			  Thread.sleep(4000);
			  String ScanCountLeft = ManageMembershipsPageElements.GetMembershipPackageExp(driver, 1).getText();
			  ScanCountLeft = ScanCountLeft.substring(4, ScanCountLeft.length()-5);
			  ManageMembershipsPageElements.GetActionButton(driver, 1).click();
			  Thread.sleep(2000);
			  ManageMembershipsPageElements.GetActionValidatOrScanOption(driver, 1).click();
			  Thread.sleep(10000);
			  CommonFunctions.SwitchToContentFrame(driver);
			  SelectEntitlementDialogboxInsideManageMembershipElements.GetEntitlementButton(driver).click();
			  Thread.sleep(2000);
			  SelectEntitlementDialogboxInsideManageMembershipElements.GetYesButton(driver).click();
			  Thread.sleep(5000);
			  driver.switchTo().defaultContent();
			  ExpCount = String.valueOf(Integer.valueOf(ScanCountLeft)-1);
			  ActCount = ManageMembershipsPageElements.GetMembershipPackageExp(driver, 1).getText();
			  ActCount = ActCount.substring(4, ActCount.length()-5);
			  assertEquals(ActCount, ExpCount);
			  Scan10PunchPassOnAccessControl();
			  
		  }
		  else
		  {
			  assertFalse(false);
		  }
	  }
	  
	  public static  void Scan10PunchPassOnAccessControl() throws InterruptedException
	  {
		  ManageMembershipsPageElements.GetAccountGuest_BarcodesLink(driver).click();
		  Thread.sleep(2000);
		  Barcode = ManageMembershipsPageElements.GetAccountGuest_BarcodeField(driver).getText() ;
		  	CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetAccessControlLink(driver));
			Thread.sleep(2000);
			DashboardPageElements.GetAccessControlLink(driver).click();
			Thread.sleep(3000);
			
			AccessControlPageElements.GetAccessTypeDD(driver).click();
			Thread.sleep(2000);
			String optionName=CreateeEntranceEntitlementTest.EntranceEntitlement;
			CommonFunctions.SelectOptionFromDropdownList(driver,optionName);					
			AccessControlPageElements.GetSearchBarcodeField(driver).sendKeys(Barcode);
			AccessControlPageElements.GetScanButton(driver).click();
			Thread.sleep(5000);
			assertEquals(AccessControlPageElements.GetApprovedOrDeniedMessage(driver).getText().trim(), "Approved");
			String	ExpResult = "Welcome to the facility! Hope you enjoy your time";
			String ActResult=AccessControlPageElements.GetBarcodeExpMessage(driver).getText().trim();
			assertEquals(ActResult,ExpResult);
		
	  }
	
}
