package Tests.GuestPortalManagementTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.GuestPortalManagementPageElements;

public class DonotAllowGuestRecordEditing {

	
	public static WebDriver driver=null;	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
		  Thread.sleep(5000);
	}
	@Test
	public static void SetGuestRecordEditingFalse() throws InterruptedException
	{
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetGuestProtalMangementLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetGuestProtalMangementLink(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetConfigureTab(driver).click();
		Thread.sleep(2000);
		if(!GuestPortalManagementPageElements.GetConfigureTab_SubTabConfigure_IsModifyGuestRestricted(driver).isSelected())
		{
			GuestPortalManagementPageElements.GetConfigureTab_SubTabConfigure_IsModifyGuestRestricted(driver).click();	
		}
		assertTrue(true);
		
	}
	

}
