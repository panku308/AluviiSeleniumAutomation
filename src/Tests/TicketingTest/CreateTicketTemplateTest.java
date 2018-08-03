package Tests.TicketingTest;



import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddTicketTemplateDialog;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.TicketingDashboardPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateTicketTemplateTest {
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String TicketTemplateName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateTicketTemplate() throws Exception
	  {
		  TicketTemplateName = "PDFTicketTemplate-"+System.currentTimeMillis();
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
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "PDF").click();
		  AddTicketTemplateDialog.GetNextButton(driver).click();
		  Thread.sleep(3000);
		  
		  driver.switchTo().frame(AddTicketTemplateDialog.GetPDFTicketBodyField(driver));     
		  
		  driver.findElement(By.cssSelector("body")).sendKeys("Ticket");
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys("[[Ticket Name]]");
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys("[[Ticket Notes]]");
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys("[[Ticket Expiration]]");
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys("[[Ticket List]]");
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys("[[Ticket Value]]");
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);		
		  driver.switchTo().parentFrame();
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
