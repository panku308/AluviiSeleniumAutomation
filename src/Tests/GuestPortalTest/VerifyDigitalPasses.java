package Tests.GuestPortalTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.GuestPortal_DashboardPageElements;
import ObjectRepository.GuestPortal_DigitalPassesPageElements;

public class VerifyDigitalPasses {
	public static WebDriver driver=null;
	 
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {		
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 public static void VerifyDigitalPassesOnGuestAccount() throws InterruptedException
	  {
		  CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, GuestPortal_DashboardPageElements.GetMyDigitalPassesLink(driver));
		  Thread.sleep(2000);
		  GuestPortal_DashboardPageElements.GetMembershipPasses(driver).click();
		  Thread.sleep(2000);
		  if(GuestPortal_DigitalPassesPageElements.GetMyDigitalPassesLink(driver).isEnabled())
		  {
			  assertTrue(true);
		  }
		  else
		  {
			  assertFalse(false);
		  }
	  }

}
