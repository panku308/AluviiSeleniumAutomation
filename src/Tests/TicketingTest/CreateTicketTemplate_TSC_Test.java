package Tests.TicketingTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddTicketTemplateDialog;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.TicketingDashboardPageElements;

public class CreateTicketTemplate_TSC_Test {
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String TicketTemplateName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateTSCTicketTemplate() throws Exception
	  {
		  TicketTemplateName = "TSCTemplate-"+System.currentTimeMillis();
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
		  driver.switchTo().frame(0);
		  AddTicketTemplateDialog.GetTicketTemplateNameField(driver).sendKeys(TicketTemplateName);
		  AddTicketTemplateDialog.GetPrintFormatDD(driver).click();
		  Thread.sleep(2000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "TSC").click();
		  AddTicketTemplateDialog.GetNextButton(driver).click();
		  Thread.sleep(3000);
		  String TicketBody = "setup{Width=25.4|Height=247.142|PrintSpeed=4|PrintDensity=8|SensorType=1|VerticalGapHeight=0|ShiftDistance=0}\n" + 
		  		"\n" + 
		  		"text{ x=175 | y=700 | height=30 | rotation=90 | windowsfontstyle=Bold  | underlined=false | windowsFont=Arial | Content=Stomping Grounds  [[Guest Call Name]]  }\n" + 
		  		"\n" + 
		  		"\n" + 
		  		"text{ x=90 | y=1200 | height=35 | rotation=90 | windowsfontstyle=Bold  | underlined=false | windowsFont=Arial | Content=[[Ticket Notes]]}\n" + 
		  		"\n" + 
		  		"text{ x=140 | y=1200 | height=45 | rotation=90 | windowsfontstyle=Bold  | underlined=true | windowsFont=Arial | Content=2 Hour Pass}\n" + 
		  		"\n" + 
		  		"text{ x=50 | y=1200 | height=30 | rotation=90 | windowsfontstyle=Normal  | underlined=false | windowsFont=Arial | Content=Expires Today}"; 
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
