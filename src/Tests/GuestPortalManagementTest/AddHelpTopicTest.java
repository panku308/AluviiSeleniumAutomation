package Tests.GuestPortalManagementTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.GuestPortalManagementPageElements;
import ObjectRepository.GuestPortalManagement_AddHelpTopicDialogboxElements;


public class AddHelpTopicTest {
	public static WebDriver driver=null;
	 public static String HelpTopic="", HelpAnswer="";
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
		  Thread.sleep(5000);
	  }
	@Test
	public static void AddHelpTopic() throws Exception
	{
		HelpTopic = "Help Topic"+System.currentTimeMillis();
		HelpAnswer = "Yes"+System.currentTimeMillis();
		
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetGuestProtalMangementLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetGuestProtalMangementLink(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpTopic(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpTopic_SelectOptionDD(driver).click();
		Thread.sleep(2000);
		CommonFunctions.SelectOptionFromDropdownList(driver, "Add Help Topic");
		Thread.sleep(2000);
		CommonFunctions.SwitchToContentFrame(driver);
		GuestPortalManagement_AddHelpTopicDialogboxElements.GetHelpCategoryDD(driver).click();
		Thread.sleep(2000);
		CommonFunctions.SelectOptionFromDropdownList(driver, AddHelpCategoryTest.HelpCategoryName);
		GuestPortalManagement_AddHelpTopicDialogboxElements.GetHelpQuestion(driver).sendKeys(HelpTopic);
		CommonFunctions.SwitchToContentFrameClassK_Content(driver);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(HelpAnswer);
		Thread.sleep(2000);
		
		//GuestPortal_AddHelpTopicDialogboxElements.GetHelpExplanationField(driver).sendKeys("Yes");
		driver.switchTo().parentFrame();
		GuestPortalManagement_AddHelpTopicDialogboxElements.GetSaveButton(driver).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpTopic_HelpQuestionColumnSettingIcon(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, HelpTopic);
		Thread.sleep(2000);
		assertEquals(GuestPortalManagementPageElements.GetHelpManagementTab_SubTab_GuestHelpTopic_HelpQuestionFirstRow(driver).getText(), HelpTopic);
		
	}
	
	
}
