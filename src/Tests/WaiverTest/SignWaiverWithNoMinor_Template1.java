package Tests.WaiverTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.SignWaiverPageElements;

public class SignWaiverWithNoMinor_Template1 {public static WebDriver driver=null;
String WaiverName="";
int NumberOfWaiver=1;
String ActualGuestRows[]=null;
@BeforeClass
 public void beforeClass() throws InterruptedException {
	  driver = CommonFunctions.driver;
 }
@Test (priority=2)
public void SignWaiverTest() throws InterruptedException
{
	 SignWaiverPageElements.AddWaiverSign_Template1(driver, NumberOfWaiver,1,0); 
}
@Test (priority=3) 
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
