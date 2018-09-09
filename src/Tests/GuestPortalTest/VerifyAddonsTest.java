package Tests.GuestPortalTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.GuestPortal_DashboardPageElements;

public class VerifyAddonsTest {
	
	public static WebDriver driver=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {		
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 @Test
	 public static void VerifyAddons() throws InterruptedException
	 {
		 CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, GuestPortal_DashboardPageElements.GetMembershipsLink(driver));
		 Thread.sleep(2000);
		 boolean actualResult=false;
		 try
		 {
			 GuestPortal_DashboardPageElements.GetAddOnsLink(driver).isDisplayed();
			 actualResult=true;
		 }
		 catch(Exception e)
		 {
			 actualResult=false;
		 }
		 if(CommonFunctions.ShowAdons==true)
		 {
			assertEquals(actualResult, true); 
		 }
		 else if (CommonFunctions.ShowAdons==false)
		 {
			 assertEquals(actualResult, false); 
		 }
	 }
}
