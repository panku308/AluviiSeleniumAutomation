package Tests.GuestPortalTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.GuestPortalManagementPageElements;
import ObjectRepository.GuestPortal_DashboardPageElements;
import ObjectRepository.GuestPortal_GuestAccountPageElements;

public class VerifyGuestEditImageTest {
	

	public static WebDriver driver=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {		
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 @Test
	 public static void EditGuestImageTest()throws Exception
	 {
		 GuestPortal_DashboardPageElements.GetDashboardLink(driver).click();
		 Thread.sleep(5000);
		 CommonFunctions.ScrollUptoElement(driver, GuestPortal_DashboardPageElements.GetUpdateAccountInfoButton(driver));
		 Thread.sleep(2000);
		 GuestPortal_DashboardPageElements.GetUpdateAccountInfoButton(driver).click();
		 Thread.sleep(5000);
		 GuestPortal_GuestAccountPageElements.GetManageMembersLink(driver).click();
		 Thread.sleep(2000);
		 GuestPortal_GuestAccountPageElements.GetManageMembers_AccountMemberDD(driver).click();
		 Thread.sleep(2000);
		 CommonFunctions.SelectOptionFromDropdownList(driver, "minorFname1536113494944 lname1536113373628");
		 Thread.sleep(2000);
		 
		 /*try {
		  * GuestPortal_GuestAccountPageElements.GetManageMembers_EditImageIcon(driver).click();
		 Thread.sleep(1000);
			 CommonFunctions.SwitchToContentFrame(driver);
			 GuestPortal_GuestAccountPageElements.GetManageMembers_SelectFilesButton(driver).isDisplayed();
			 GuestPortal_GuestAccountPageElements.GetManageMembers_SelectFilesButton(driver).click();
			 Thread.sleep(3000);
			  CommonFunctions.UploadFile(System.getProperty("user.dir") + "\\resources\\index.jpg");
			  Thread.sleep(10000);
			  driver.switchTo().parentFrame();
			  assertTrue(true);
			 
		 }
		 catch(Exception e)
		 {
			 assertFalse(false);
		 }*/
		 try
		 {
			 GuestPortal_GuestAccountPageElements.GetManageMembers_DisabledEditImageIcon(driver).click();
			 Thread.sleep(1000);
			 GuestPortal_GuestAccountPageElements.GetManageMembers_SuccessFailureMessage(driver).isDisplayed();
			 String act= GuestPortal_GuestAccountPageElements.GetManageMembers_SuccessFailureMessage(driver).getText();
			 assertEquals(act, "Image can be changed in 10 more days.");
		 }
		 catch(Exception e)
		 {
			 assertFalse(false);
		 }
	 }
	 
}
