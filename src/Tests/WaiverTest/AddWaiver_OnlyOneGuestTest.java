package Tests.WaiverTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddWaiverDialogBoxElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.SignWaiverPageElements;
import ObjectRepository.WaiverManagementPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddWaiver_OnlyOneGuestTest {
	 public static WebDriver driver=null;
	 String WaiverName="";
	 int NumberOfWaiver=1;
	 String ActualGuestRows[]=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	 @Test (priority=7)
	  public void AddWaiver_OnlyOneGuest()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  Thread.sleep(2000);
		  WaiverManagementPageElements.OpenWaiverManagementPage(driver);
		  AddWaiverDialogBoxElements.AddWaiver(driver, WaiverName, 3);
	  }
	 @Test(priority=8)
	 public void SignWaiverTest() throws InterruptedException
	 {
		 SignWaiverPageElements.AddWaiverSign(driver, NumberOfWaiver,1,0); 
	 }
	 @Test (priority=9)
	 public void VerifySignedWaiverOnManageMemebershipTest() throws InterruptedException
	 {
		 boolean actualResult=false;
		 int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, SignWaiverPageElements.SignWaiverEmailID);
		 if(i==1)
		 {
			 actualResult=true;
			 assertEquals(actualResult, true);
			 ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
			 Thread.sleep(4000);
			 ActualGuestRows= ManageMembershipsPageElements.GetGuestRecordRowsFromAccountTable(driver);
			 System.out.println("Actual Guest Row"  + ActualGuestRows.length);
			 if(ActualGuestRows.length==SignWaiverPageElements.GuestFnameLname.length)
			 {
				 assertEquals(CommonFunctions.CompareSingleDimensionStringArray(ActualGuestRows, SignWaiverPageElements.GuestFnameLname), true);
			 }
			 else
			 {
				 assertEquals(ActualGuestRows, SignWaiverPageElements.GuestFnameLname);
			 }
			 
			 
		 }
		 else
		 {
			 assertEquals(false, true);
		 }
		 
	 }
	 
	
}
