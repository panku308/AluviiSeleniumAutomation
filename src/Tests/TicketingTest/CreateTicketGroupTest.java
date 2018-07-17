package Tests.TicketingTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddTicketGroupDialogBoxElements;
import ObjectRepository.AddTicketTemplateDialog;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.TicketingDashboardPageElements;

public class CreateTicketGroupTest {
	

	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String TicketGroupName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateTicketTemplate() throws Exception
	  {
		  TicketGroupName = "TG-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetTicketingLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetTicketingLink(driver).click();
		  Thread.sleep(5000);
		  TicketingDashboardPageElements.GetTicketGroupsTab(driver).click();
		  Thread.sleep(2000);
		  TicketingDashboardPageElements.GetTicketGroupTab_SelectOptionDD(driver).click();		  
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Ticket Group").click();
		  Thread.sleep(5000);
		  driver.switchTo().frame(0);
		  AddTicketGroupDialogBoxElements.GetTicketGroupName(driver).sendKeys(TicketGroupName);
		  
		  driver.switchTo().frame(AddTicketGroupDialogBoxElements.GetInternalDescription((driver))); 
		  driver.findElement(By.cssSelector("body")).sendKeys("Internal description");
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);
		  driver.switchTo().frame(AddTicketGroupDialogBoxElements.GetExternalDescription((driver))); 
		  driver.findElement(By.cssSelector("body")).sendKeys("External description");
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);
		  
		  AddTicketGroupDialogBoxElements.GetTicketTypeDD(driver).click();
		  //AddTicketGroupDialogBoxElements.SelectStaticTicketType(driver);
		  AddTicketGroupDialogBoxElements.SelectDynamicTicketType(driver, CreateTicketTypeTest.TicketTypeName);
		  CommonFunctions.ScrollUptoElement(driver, AddTicketGroupDialogBoxElements.GetNumberOfTickets(driver));
		  for (int i=0;i<2;i++)
		  {
			 AddTicketGroupDialogBoxElements.GetNumberOfTicketsIncreaseArrow(driver).click(); 
		  }
		  
		  AddTicketGroupDialogBoxElements.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  TicketingDashboardPageElements.GetTicketGroupsTab_TicketGroupNameCollomnSettings(driver).click();
		  CommonFunctions.filterTable(driver, TicketGroupName);
		  Thread.sleep(2000);
		  assertEquals(TicketingDashboardPageElements.GetTicketGroupTab_FirstRowTicketGroupNameColumn(driver).getText().trim(), TicketGroupName);
	  }
}
