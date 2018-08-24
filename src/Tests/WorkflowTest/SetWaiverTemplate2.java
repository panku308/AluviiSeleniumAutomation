package Tests.WorkflowTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.WorkflowBuilderPageElements;

public class SetWaiverTemplate2 {
	 public static WebDriver driver=null;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
 @Test
 public void SetWaiverTemplate1() throws InterruptedException {CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetWorkflowLink(driver));
	Thread.sleep(2000);
	DashboardPageElements.GetWorkflowLink(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.getWorkflowTypeDD(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetWorkflowTypeDDOption(driver, "Waiver").click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.getWorkflowOptionDD(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.getWorkflowOptionDDOption(driver, "Waiver").click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetWaiverTeamplateDD(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetWaiverTeamplateDDOption(driver, "Aluvii Standard - 2").click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetReqAllGuestOverMinAgeRadioButton(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetMinAgeOfSignField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a","18"));
	Thread.sleep(2000);

	WorkflowBuilderPageElements.GetDisplayEmailOptOutDD(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetDisplayEmailOptOutDDOption(driver, "Yes").click();
	Thread.sleep(5000);
	WorkflowBuilderPageElements.GetReqSignerDD(driver).click();
	Thread.sleep(2000);
	WorkflowBuilderPageElements.GetReqSignerDDOption(driver, "Yes").click();
}
}
