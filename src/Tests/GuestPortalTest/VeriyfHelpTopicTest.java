package Tests.GuestPortalTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.GuestPortal_DashboardPageElements;
import ObjectRepository.GuestPortal_HelpPageElements;
import Tests.GuestPortalManagementTest.AddHelpCategoryTest;
import Tests.GuestPortalManagementTest.AddHelpTopicTest;

public class VeriyfHelpTopicTest {
	
	public static WebDriver driver=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {		
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 @Test
	 public static void VerifyHelpTopic() throws Exception
	 {
		
		 CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, GuestPortal_DashboardPageElements.GetUsernameMenu(driver));
		 Thread.sleep(2000);
		 GuestPortal_DashboardPageElements.GetHelpLink(driver).click();
		 Thread.sleep(2000);
		 CommonFunctions.ScrollUptoElement(driver, GuestPortal_HelpPageElements.GetHelpCategoryLink(driver, AddHelpCategoryTest.HelpCategoryName));
		 Thread.sleep(2000);
		 GuestPortal_HelpPageElements.GetHelpCategoryLink(driver, AddHelpCategoryTest.HelpCategoryName).click();
		 Thread.sleep(5000);
		 assertEquals(GuestPortal_HelpPageElements.GetHelpTopicLink(driver, AddHelpTopicTest.HelpTopic).getText(), AddHelpTopicTest.HelpTopic);
		 driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);
		 
		 Thread.sleep(5000);
		 GuestPortal_HelpPageElements.GetHelpTopicLink(driver, AddHelpTopicTest.HelpTopic).click();
		 Thread.sleep(1000);
		 assertEquals(GuestPortal_HelpPageElements.GetAnswerField(driver, AddHelpTopicTest.HelpTopic).getText(), AddHelpTopicTest.HelpAnswer);
		 
	 }
	
}
