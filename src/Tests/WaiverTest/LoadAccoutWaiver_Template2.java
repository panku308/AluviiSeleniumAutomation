package Tests.WaiverTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.SignWaiver2PageElements;
import ObjectRepository.SignWaiverPageElements;
import Tests.ManageMembershipsTest.CreateMemberTest;

public class LoadAccoutWaiver_Template2 {

	

public static WebDriver driver=null;
String WaiverName="";
int NumberOfWaiver=1;
String ActualGuestRows[]=null, ExpectedGuestRows[]=new String[1];
@BeforeClass
 public void beforeClass() throws InterruptedException {
	  driver = CommonFunctions.driver;
 }
@Test (priority=2)
public void LoadAccountWaiver() throws Exception
{
	 SignWaiver2PageElements.LoadAccountWaiver_Teamplate2(driver,CreateMemberTest.EmailID); 
}
@Test (priority=3) 
public void VerifySignedWaiverOnManageMemebershipTest() throws InterruptedException
{
	 boolean actualResult=false;
	 int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, CreateMemberTest.EmailID);
	 if(i==1)
	 {
		 actualResult=true;
		 assertEquals(actualResult, true);
		 ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
		 Thread.sleep(4000);
		 ActualGuestRows= ManageMembershipsPageElements.GetGuestRecordRowsFromAccountTable(driver);
		 ExpectedGuestRows [0]= CreateMemberTest.fname + " "+ CreateMemberTest.lname;
		 System.out.println("Actual Guest Row"  + ActualGuestRows.length);
		 if(ActualGuestRows.length==ExpectedGuestRows.length)
		 
		 {
			 assertEquals(CommonFunctions.CompareSingleDimensionStringArray(ActualGuestRows, ExpectedGuestRows), true);
		 }
		 else
		 {
			 assertEquals(ActualGuestRows,ExpectedGuestRows);
		 }
		  
	 }
	 else
	 {
		 assertEquals(false, true);
	 }
	 
	}


}
