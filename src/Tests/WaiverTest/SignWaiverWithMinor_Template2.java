package Tests.WaiverTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.SignWaiver2PageElements;

public class SignWaiverWithMinor_Template2 {
	

public static WebDriver driver=null;
String WaiverName="";
int NumberOfWaiver=2;
String ActualGuestRows[]=null;
@BeforeClass
 public void beforeClass() throws InterruptedException {
	  driver = CommonFunctions.driver;
 }
@Test (priority=2)
public void SignWaiverTest() throws Exception
{
	 SignWaiver2PageElements.AddWaiverSign_Template2(driver, NumberOfWaiver,1,1); 
}
@Test (priority=3) 
public void VerifySignedWaiverOnManageMemebershipTest() throws InterruptedException
{
	 boolean actualResult=false;
	 int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, SignWaiver2PageElements.SignWaiverEmailID);
	 if(i==1)
	 {
		 actualResult=true;
		 assertEquals(actualResult, true);
		 ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
		 Thread.sleep(4000);
		 ActualGuestRows= ManageMembershipsPageElements.GetGuestRecordRowsFromAccountTable(driver);
		 System.out.println("Actual Guest Row"  + ActualGuestRows.length);
		 if(ActualGuestRows.length==SignWaiver2PageElements.GuestFnameLname.length)
		 {
			 assertEquals(CommonFunctions.CompareSingleDimensionStringArray(ActualGuestRows, SignWaiver2PageElements.GuestFnameLname), true);
		 }
		 else
		 {
			 assertEquals(ActualGuestRows, SignWaiver2PageElements.GuestFnameLname);
		 }
		  
	 }
	 else
	 {
		 assertEquals(false, true);
	 }
	 
	}

}
