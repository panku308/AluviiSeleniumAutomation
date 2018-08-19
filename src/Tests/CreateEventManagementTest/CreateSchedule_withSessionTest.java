package Tests.CreateEventManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddEmployeeDialogBox;
import ObjectRepository.AddLoginActivityDialogBox;
import ObjectRepository.AddScheduleEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateSchedule_withSessionTest extends TestSetup {

	//public static WebDriver driver=DriverManager.getDriver();

	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/
	public static String ScheduleSessionName="";
	@Test
	public static void createSchedule()throws Exception
	{
			
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Schedules").click();
			Thread.sleep(2000);
			EventManagementPageElements.getSchedulesSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getSchedulesSelectOptionDropdownList(driver, "Add Schedule").click();
			Thread.sleep(2000);
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			 ScheduleSessionName="TestSchedule"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getScheduleNameField(driver).sendKeys(ScheduleSessionName);
			AddScheduleEventManagementDialogBoxElements.getSelectTimeZoneButton(driver).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setSelectTimeZone(driver, "Denver").click();;
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.getNormalDurationTime(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setNormalDurationTime(driver).sendKeys("120");
			
			AddScheduleEventManagementDialogBoxElements.gettab(driver, "Time & Recurrences").click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.getAddSubScheduleButton(driver).click();
			Thread.sleep(2000);
			String subScheduleSessionName="TestSubSchedule"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getSubScheduleNameField(driver).sendKeys(subScheduleSessionName);
			AddScheduleEventManagementDialogBoxElements.getStartTime(driver).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setStartTime(driver, "10:00 AM").click();
			
			AddScheduleEventManagementDialogBoxElements.getEndTime(driver).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setEEndTime(driver, "10:00 PM").click();
			
			AddScheduleEventManagementDialogBoxElements.GetAddButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_ScheduleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, ScheduleSessionName);
			
			Assert.assertEquals(EventManagementPageElements.getScheduleNameFilteredValue(driver).getText(), ScheduleSessionName);
			
			Actions action = new Actions(driver);
			action.moveToElement(EventManagementPageElements.getScheduleNameFilteredValue(driver)).doubleClick();
			action.perform();
			
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			//driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			EditScheduleEventManagementDialogBoxElements.gettab(driver, "View Calendar").click();
			Thread.sleep(2000);
			Assert.assertTrue(EditScheduleEventManagementDialogBoxElements.checkSubScheduleName(driver, subScheduleSessionName));
			
			Thread.sleep(2000);
			
			EditScheduleEventManagementDialogBoxElements.gettab(driver, "General").click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.GetEnableSession_YES_RadioButton(driver).click();
			Thread.sleep(2000);
			EditScheduleEventManagementDialogBoxElements.getSaveButton(driver).click();
			
			driver.switchTo().defaultContent();
			/*Thread.sleep(3000);
			EventManagementPageElements.getEditScheduleCloseButton(driver).click();*/
			
			Thread.sleep(2000);
			
			CommonFunctions.map.put("Schedule", ScheduleSessionName);
		
	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/
}
