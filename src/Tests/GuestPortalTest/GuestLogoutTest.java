package Tests.GuestPortalTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.GuestPortal_DashboardPageElements;

public class GuestLogoutTest {
	public static WebDriver driver=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {		
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 @Test
	 public static void Logout() throws InterruptedException
	 {
		 CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, GuestPortal_DashboardPageElements.GetUsernameMenu(driver));
		 Thread.sleep(2000);
		 GuestPortal_DashboardPageElements.GetLogoutLink(driver).click();
		 Thread.sleep(10000);
		 assertEquals(driver.getCurrentUrl(), "https://stagingqa.aluvii.com/guest/");
		 driver.close();
		 driver.quit();
	 }
	
}
