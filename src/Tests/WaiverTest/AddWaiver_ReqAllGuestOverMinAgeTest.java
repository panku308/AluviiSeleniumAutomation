package Tests.WaiverTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddWaiverDialogBoxElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.SignWaiverPageElements;
import ObjectRepository.WaiverManagementPageElements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddWaiver_ReqAllGuestOverMinAgeTest {
	 public static WebDriver driver=null;
	 String WaiverName="";
	 int NumberOfWaiver=3;
	 
	 String ActualGuestRows[]=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	 @Test (priority=4)
	  public void AddWaiver_ReqAllGuestOverMinAge()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  Thread.sleep(2000);
		  WaiverManagementPageElements.OpenWaiverManagementPage(driver);
		  AddWaiverDialogBoxElements.AddWaiver(driver, WaiverName, 2);
	  }
	 @Test(priority=5)
	 public void SignWaiverTest() throws InterruptedException
	 {
		 SignWaiverPageElements.AddWaiverSign(driver, NumberOfWaiver, 1,2); 
	 }
	 @Test (priority=6)
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
