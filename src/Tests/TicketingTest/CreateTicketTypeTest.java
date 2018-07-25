package Tests.TicketingTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddEnteranceEntitlementDialogboxElements;
import ObjectRepository.AddTicketTypeDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.TicketingDashboardPageElements;

public class CreateTicketTypeTest {
	public static WebDriver driver=null;
	
	  public static String actualResult="";
	  public static String TicketTypeName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void CreateTicketType()throws Exception
	  {
		  TicketTypeName="TicketType-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetTicketingLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetTicketingLink(driver).click();
		  Thread.sleep(5000);
		  TicketingDashboardPageElements.GetTicketTypesTab(driver).click();
		  Thread.sleep(3000);
		  TicketingDashboardPageElements.GetTicketTypesTab_SelectOptionDD(driver).click();		  
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Ticket Type").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddTicketTypeDialogBoxElements.GetTicketTypeNameField(driver).sendKeys(TicketTypeName);
		  AddTicketTypeDialogBoxElements.setEndDate(driver);
		  AddTicketTypeDialogBoxElements.GetNumberOfDaysInputField(driver).sendKeys("365");
		  AddTicketTypeDialogBoxElements.GetTicketTypeDescription(driver).sendKeys("Desc-" + System.currentTimeMillis());
		  AddTicketTypeDialogBoxElements.GetTicketNotes(driver).sendKeys("Note-"+System.currentTimeMillis());
		  AddTicketTypeDialogBoxElements.GetTicketTemplateDD(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, CreateTicketTemplateTest.TicketTemplateName).click();
		  AddTicketTypeDialogBoxElements.GetNextButton(driver).click();
		  Thread.sleep(5000);
		  AddTicketTypeDialogBoxElements.GetCompositionOptionsDD(driver).click();
		  
		  
		  Thread.sleep(2000);
		  AddTicketTypeDialogBoxElements.SelectFirstOptionFromCompositionDD(driver);
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddEnteranceEntitlementDialogboxElements.GetStaticEnteranceEntitlementName(driver).click();
		  Thread.sleep(3000);
		  driver.switchTo().parentFrame();
		  AddTicketTypeDialogBoxElements.GetNextButton(driver).click();
		  Thread.sleep(3000);
		  AddTicketTypeDialogBoxElements.GetNextButton(driver).click();
		  Thread.sleep(3000);
		  AddTicketTypeDialogBoxElements.GetSubmitButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  TicketingDashboardPageElements.GetTicketTypesTab_TypeIDColumn(driver).click();
		  Thread.sleep(3000);
		  TicketingDashboardPageElements.GetTicketTypesTab_TypeIDColumn(driver).click();
		  Thread.sleep(5000);
		  assertEquals(TicketingDashboardPageElements.GetTicketTypesTab_FirstRowTypeNameColumn(driver).getText().trim(), TicketTypeName);
	  }
	  
	
}
