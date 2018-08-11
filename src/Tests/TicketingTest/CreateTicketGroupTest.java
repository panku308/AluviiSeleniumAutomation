package Tests.TicketingTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AccessControlPageElements;
import ObjectRepository.AddTicketGroupDialogBoxElements;
import ObjectRepository.AddTicketTemplateDialog;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.TicketingDashboardPageElements;
import Tests.MembershipPackagesTest.CreateeEntranceEntitlementTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateTicketGroupTest {
	public static String ExpResult="Sorry, but your Ticket is not valid at current Entrance.",ActResult="";
	public static boolean isAlreadyUsed=false;
	

	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String TicketGroupName="";
	  public static int BeforeGroupLatestTicketId=0;
	  public static int AfterGroupLatestTicketId=0;
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateTicketGroup() throws Exception
	  {
		  TicketGroupName = "TG-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetTicketingLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetTicketingLink(driver).click();
		  Thread.sleep(5000);
		  TicketingDashboardPageElements.GetTicketsTab_IdColumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  TicketingDashboardPageElements.GetTicketsTab_SortDescendingOption(driver).click();
		  Thread.sleep(5000);
		  BeforeGroupLatestTicketId = Integer.valueOf(TicketingDashboardPageElements.GetTicketTab_LatestTicketIDElement(driver).getText());
		  TicketingDashboardPageElements.GetTicketGroupsTab(driver).click();
		  Thread.sleep(2000);
		  TicketingDashboardPageElements.GetTicketGroupTab_SelectOptionDD(driver).click();		  
		  Thread.sleep(3000);
		  
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Ticket Group").click();
		  Thread.sleep(5000);
		  CommonFunctions.SwitchToContentFrame(driver);
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
		 // AddTicketGroupDialogBoxElements.SelectDynamicTicketType(driver, "TicketType-1533571346733");
		  // Entitlement-1533569809536
		  CommonFunctions.ScrollUptoElement(driver, AddTicketGroupDialogBoxElements.GetNumberOfTickets(driver));
		  for (int i=0;i<2;i++)
		  {
			 AddTicketGroupDialogBoxElements.GetNumberOfTicketsIncreaseArrow(driver).click(); 
		  }
		  
		  AddTicketGroupDialogBoxElements.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  driver.navigate().refresh();
		  Thread.sleep(10000);
		  TicketingDashboardPageElements.GetTicketGroupsTab(driver).click();
		  Thread.sleep(5000);
		  TicketingDashboardPageElements.GetTicketGroupsTab_TicketGroupNameCollomnSettings(driver).click();
		  Thread.sleep(3000);
		  CommonFunctions.filterTable(driver, TicketGroupName);
		  Thread.sleep(2000);
		  assertEquals(TicketingDashboardPageElements.GetTicketGroupTab_FirstRowTicketGroupNameColumn(driver).getText().trim(), TicketGroupName);
		  driver.navigate().refresh();
		  Thread.sleep(10000);		  
		  TicketingDashboardPageElements.GetTicketsTab(driver).click();
		  Thread.sleep(5000);
		  TicketingDashboardPageElements.GetTicketsTab_IdColumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  TicketingDashboardPageElements.GetTicketsTab_SortDescendingOption(driver).click();
		  Thread.sleep(5000);
		  AfterGroupLatestTicketId = Integer.valueOf(TicketingDashboardPageElements.GetTicketTab_LatestTicketIDElement(driver).getText());
		  assertEquals(AfterGroupLatestTicketId, BeforeGroupLatestTicketId+3);
		  VerifyTicketBarcodeScanStatus();
	  }
	  //entrance entitlement: Entitlement-1533569809536
	  // 
	  public static void VerifyTicketBarcodeScanStatus() throws InterruptedException
	  {
		  String Barcode[]= new String[3];
		 for(int i =0;i<3;i++)
		 {
			 Barcode[i]=TicketingDashboardPageElements.GetTicketTab_BarcodeValue(driver,i+1).getText();
			 System.out.println(Barcode[i]);
		 }
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetAccessControlLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetAccessControlLink(driver).click();
		Thread.sleep(3000);
		
		  for (int i = 0;i<3;i++)
		  {
			  isAlreadyUsed=false;
					AccessControlPageElements.GetAccessTypeDD(driver).click();
					Thread.sleep(2000);
					String optionName=CreateeEntranceEntitlementTest.EntranceEntitlement;
					CommonFunctions.SelectOptionFromDropdownList(driver,optionName);					
					AccessControlPageElements.GetSearchBarcodeField(driver).sendKeys(Barcode[i]);
					AccessControlPageElements.GetScanButton(driver).click();
					Thread.sleep(5000);			
					if(isAlreadyUsed==false)
					{
						assertEquals(AccessControlPageElements.GetApprovedOrDeniedMessage(driver).getText().trim(), "Approved");
						ExpResult = "Welcome to the facility! Hope you enjoy your time";
						ActResult=AccessControlPageElements.GetBarcodeExpMessage(driver).getText().trim();
						assertEquals(ActResult,ExpResult);
						ExpResult="Sorry, but it appears that you have already used your Ticket.";
						isAlreadyUsed=true;
					}
					AccessControlPageElements.GetSearchBarcodeField(driver).sendKeys(Barcode[i]);
					AccessControlPageElements.GetScanButton(driver).click();
					Thread.sleep(5000);			
					
					assertEquals(AccessControlPageElements.GetApprovedOrDeniedMessage(driver).getText().trim(), "Denied");
					ActResult=AccessControlPageElements.GetBarcodeExpMessage(driver).getText().trim();
					assertEquals(ActResult,ExpResult);
				
		  }
	  }
}
