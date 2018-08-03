package Tests.TicketingTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddTicketTemplateDialog;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.TicketingDashboardPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateTicketTemplate_BOCA_Test {
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String TicketTemplateName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateBOCATicketTemplate() throws Exception
	  {
		  TicketTemplateName = "BOCATemplate-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetTicketingLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetTicketingLink(driver).click();
		  Thread.sleep(5000);
		  TicketingDashboardPageElements.GetTicketTemplatesTab(driver).click();
		  Thread.sleep(2000);
		  TicketingDashboardPageElements.GetTicketTemplatesTab_SelectOptionDD(driver).click();		  
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Ticket Template").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddTicketTemplateDialog.GetTicketTemplateNameField(driver).sendKeys(TicketTemplateName);
		  AddTicketTemplateDialog.GetPrintFormatDD(driver).click();
		  Thread.sleep(2000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "BOCA").click();
		  AddTicketTemplateDialog.GetNextButton(driver).click();
		  Thread.sleep(3000);
		  String TicketBody = "<PL1150><RU><RC5,935><HW2,2><F8>[[Ticket Name]]\n" + 
				  "<RC325,90><LT4><BX65,850>\n" + 
				  "<RC405,715><LT4><BX50,225>\n" + 
				  "<RC405,630><LT4><BX50,85>\n" + 
				  "<RC405,360><LT4><BX50,270>\n" + 
				  "<RC445,935><HW2,1><F2>$25.00\n" + 
				  "<RC470,710><HW1,1><F2>Reg\n" + 
				  "<RC470,673><HW1,1><F2>Emp\n" + 
				  "<RC20,1100><X2><OL15>^[[Barcode Number]]^\n" + 
				  "<RC305,945><F6><HW1,1>    Aluvii Demo Ticket\n" + 
				  "<RC240,935><F3><HW1,1><EI>Ask us about our 20% off Show Special<DI>\n" + 
				  "<RC200,935><F3><HW1,1>This ticket has has no monetary value.\n" + 
				  "<RC160,945><F3><HW1,1>See more info on the back.\n" + 
				  "<RC120,935><F3><HW1,1>\n" + 
				  "<RC445,350><HW2,1><F2>\n" + 
				  "<RC470,935><HW1,1><F2>Value\n" + 
				  "<RC470,625><HW1,1><F2>Ticket\n" + 
				  "<RC445,620><HW2,1><F2>Aluvii\n" + 
				  "<RC470,355><HW1,1><F2>Invoice\n" + 
				  "<RC470,185><HW1,1><F2>\n" + 
				  "<RC405,190><LT4><BX50,170>\n" + 
				  "<RC470,490><HW1,1><F9>\n" + 
				  "<RC470,180><HW2,1><F2><EI>No Cash Value<DI>\n" + 
				  "<RC435,180><HW2,1><F2><EI>Non Refundable<DI><p>";
		  AddTicketTemplateDialog.GetBOCATicketBodyField(driver).sendKeys(TicketBody);     
		  
		  
		  AddTicketTemplateDialog.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  TicketingDashboardPageElements.GetTicketTemplatesTab_IDColumn(driver).click();
		  Thread.sleep(3000);
		  TicketingDashboardPageElements.GetTicketTemplatesTab_IDColumn(driver).click();
		  Thread.sleep(5000);
		  assertEquals(TicketingDashboardPageElements.GetTicketTemplatesTab_FirstRowTemplateNameColumn(driver).getText().trim(), TicketTemplateName);
	  }

}
