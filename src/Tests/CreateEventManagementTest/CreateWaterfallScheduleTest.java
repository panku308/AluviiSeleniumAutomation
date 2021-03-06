package Tests.CreateEventManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddScheduleEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import util.DriverManager;

public class CreateWaterfallScheduleTest {
public static WebDriver driver= null;

	

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	public static String ScheduleName="";
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
			
			 ScheduleName="WaterfallSchedule_"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getScheduleNameField(driver).sendKeys(ScheduleName);
			AddScheduleEventManagementDialogBoxElements.getSelectTimeZoneButton(driver).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setSelectTimeZone(driver, "Denver").click();;
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.getNormalDurationTime(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setNormalDurationTime(driver).sendKeys("45");
			
			
			AddScheduleEventManagementDialogBoxElements.getMinutesBetweenField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setMinutesBetweenField(driver).sendKeys("15");
			
			
			
			AddScheduleEventManagementDialogBoxElements.gettab(driver, "Time & Recurrences").click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.getAddSubScheduleButton(driver).click();
			Thread.sleep(2000);
			String subScheduleName="TestSubSchedule"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getSubScheduleNameField(driver,0).sendKeys(subScheduleName);
			AddScheduleEventManagementDialogBoxElements.getStartTime(driver,0).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setStartTime(driver, "10:00 AM",0).click();
			
			AddScheduleEventManagementDialogBoxElements.getEndTime(driver,0).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setEEndTime(driver, "8:00 PM",0).click();
			
			AddScheduleEventManagementDialogBoxElements.GetAddButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_ScheduleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, ScheduleName);
			
			Assert.assertEquals(EventManagementPageElements.getScheduleNameFilteredValue(driver).getText(), ScheduleName);
			
			Actions action = new Actions(driver);
			action.moveToElement(EventManagementPageElements.getScheduleNameFilteredValue(driver)).doubleClick();
			action.perform();
			
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			//driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			EditScheduleEventManagementDialogBoxElements.gettab(driver, "View Calendar").click();
			Thread.sleep(2000);
			Assert.assertTrue(EditScheduleEventManagementDialogBoxElements.checkSubScheduleName(driver, subScheduleName));
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getEditScheduleCloseButton(driver).click();
			
			Thread.sleep(2000);
			
			CommonFunctions.IsWaterfallSchedule=true;
		
	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/

}
