package Tests.GuestPortalTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.GuestPortal_CreateAccountDialogBoxElements;
import ObjectRepository.GuestPortal_DashboardPageElements;
import ObjectRepository.GuestPortal_LoginPageElements;

public class VerifyCreateAccountButtonTest {
	
	public static WebDriver driver=null;
	 
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		 CommonFunctions.SetupGuestEnvironment(CommonFunctions.GuestURL, "chrome");
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 @Test
	 public static void VerifyCreateAccountButton() throws InterruptedException
	 {
		 GuestPortal_LoginPageElements.GetClickHere(driver).click();
		 Thread.sleep(5000);
		 CommonFunctions.SwitchToContentFrame(driver);
		 boolean actualResult=false;
		 try
		 {
			 GuestPortal_CreateAccountDialogBoxElements.GetCreateAccountButton(driver).isDisplayed();
			 actualResult=true;
		 }
		 catch(Exception e)
		 {
			 actualResult=false;
		 }
		 Thread.sleep(2000);
		 driver.switchTo().defaultContent();
		 GuestPortal_CreateAccountDialogBoxElements.GetCloseButton(driver).click();
		 
		 
		 if(CommonFunctions.ShowCreateAccountButton==true)
		 {
			assertEquals(actualResult, true); 
		 }
		 
		 else if (CommonFunctions.ShowCreateAccountButton==false)
		 {
			 assertEquals(actualResult, false); 
		 }
		 driver.close();
		 driver.quit();
		 
		 
	 }

}
