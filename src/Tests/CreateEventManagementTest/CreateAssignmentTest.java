package Tests.CreateEventManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import GlobalFiles.CommonFunctions;
import ObjectRepository.AddAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import baseSetup.TestSetup;
import util.DriverManager;

public class CreateAssignmentTest extends TestSetup {

	//public static WebDriver driver=DriverManager.getDriver();

	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/

	@Test()
	public static void createAssignment()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Assignments").click();
			Thread.sleep(2000);
			EventManagementPageElements.getAssignmentsSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getAssignmentsSelectOptionDropdownList(driver, "Add Assignment").click();
			Thread.sleep(2000);
			
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			String AssignmentName="TestAssignment_"+System.currentTimeMillis();
			AddAssignmentsEventManagementDialogBoxElements.getAssignmentNameField(driver).sendKeys(AssignmentName);
			AddAssignmentsEventManagementDialogBoxElements.getCategoryButton(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setCategory(driver, CommonFunctions.map.get("Category")).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getLocationButton(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setLocation(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getSiteButton(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setSiteOption(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getTaxOptionButton(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setTaxOption(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getCapacity(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setCapacity(driver).sendKeys("25");
			AddAssignmentsEventManagementDialogBoxElements.setExclusiveUse(driver).sendKeys(Keys.SPACE);
			AddAssignmentsEventManagementDialogBoxElements.getscheduleOptionButton(driver).click();
			Thread.sleep(3000);
			AddAssignmentsEventManagementDialogBoxElements.setScheduleOption(driver, CommonFunctions.map.get("Schedule")).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setViewOnEventPortal(driver).sendKeys(Keys.SPACE);
			AddAssignmentsEventManagementDialogBoxElements.GetAddButton(driver).click();
			
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_AssignmentName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, AssignmentName);
			
			Assert.assertEquals(EventManagementPageElements.getAssignmentNameFilteredValue(driver).getText(), AssignmentName);
			
			Thread.sleep(2000);
			
			
			CommonFunctions.map.put("Assignment", AssignmentName);

		
	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/
}
