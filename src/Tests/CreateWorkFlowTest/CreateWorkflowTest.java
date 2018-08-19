package Tests.CreateWorkFlowTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddEmployeeDialogBox;
import ObjectRepository.AddLoginActivityDialogBox;
import ObjectRepository.CashControlPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import ObjectRepository.WorkflowBuilderPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateWorkflowTest extends TestSetup {

	public static String WorkflowName="";

	@Test
	public static void createWorkflow()throws Exception
	{
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPageElements.GetWorkflowLink(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetSettings_Integrate_this_session_with(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetSettings_Integrate_this_session_with_Options(driver, "Aerodium");
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetCopyWorkflowButton(driver).click();
		Thread.sleep(2000);
		/*driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);*/
		WorkflowName="TestWorkflow_"+System.currentTimeMillis();

		WorkflowBuilderPageElements.getCopyWorkflowSessions_NameField(driver).sendKeys(WorkflowName);
		Thread.sleep(2000);
		WorkflowBuilderPageElements.getCopyWorkflowSessions_SaveButton(driver).click();
		Thread.sleep(2000);


	}
}
