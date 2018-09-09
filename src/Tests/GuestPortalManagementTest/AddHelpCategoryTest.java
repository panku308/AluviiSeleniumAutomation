package Tests.GuestPortalManagementTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.GuestPortalManagementPageElements;
import ObjectRepository.GuestPortalManagement_AddHelpCategoryDialogboxElements;


public class AddHelpCategoryTest {
	public static WebDriver driver=null;
	 public static String HelpCategoryName="";
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
		  Thread.sleep(5000);
	  }
	@Test
	public static void AddHelpCategory() throws Exception
	{
		HelpCategoryName = "Help Category"+System.currentTimeMillis();
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetGuestProtalMangementLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetGuestProtalMangementLink(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpCategory(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpCategory_SelectOptionDD(driver).click();
		Thread.sleep(2000);
		CommonFunctions.SelectOptionFromDropdownList(driver, "Add Category");
		Thread.sleep(2000);
		CommonFunctions.SwitchToContentFrame(driver);
		GuestPortalManagement_AddHelpCategoryDialogboxElements.GetCaetgoryNameField(driver).sendKeys(HelpCategoryName);
		Thread.sleep(1000);
		GuestPortalManagement_AddHelpCategoryDialogboxElements.GetSaveButton(driver).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpCategory(driver).click();
		Thread.sleep(2000);*/
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpCategory_CategoryNameColumnSettingIcon(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, HelpCategoryName);
		Thread.sleep(2000);
		assertEquals(GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpCategory_CategoryNameFirstRow(driver).getText(),HelpCategoryName);
		
	}
	
	
}
