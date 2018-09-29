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

public class CreateScheduleWithMultipleSubSchedule {

public static WebDriver driver = null;
	public static String subScheduleName[]=new String[2]; 
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	public static String ScheduleName="";
	@Test
	public static void createSchedule()throws Exception
	{
			
	
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
			
			 ScheduleName="TestSchedule"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getScheduleNameField(driver).sendKeys(ScheduleName);
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
			subScheduleName[0]="TestSubSchedule-MonToFri-"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getSubScheduleNameField(driver,0).sendKeys(subScheduleName[0]);
			AddScheduleEventManagementDialogBoxElements.getStartTime(driver,0).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setStartTime(driver, "2:00 PM",0).click();
			
			AddScheduleEventManagementDialogBoxElements.getEndTime(driver,0).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setEEndTime(driver, "10:00 PM",0).click();
			
			AddScheduleEventManagementDialogBoxElements.GetScheduleEditButton(driver,0).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.GetWeeklyRadioButton(driver,0).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.GetMondayCheckbox(driver,0).click();
			AddScheduleEventManagementDialogBoxElements.GetTuesdayCheckbox(driver,0).click();
			AddScheduleEventManagementDialogBoxElements.GetWednesdayCheckbox(driver,0).click();
			AddScheduleEventManagementDialogBoxElements.GetThrudsdayCheckbox(driver,0).click();
			AddScheduleEventManagementDialogBoxElements.GetFridayCheckbox(driver,0).click();
			
			
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.getAddSubScheduleButton(driver).click();
			Thread.sleep(2000);
			subScheduleName[1]="TestSubSchedule-SatToSun-"+System.currentTimeMillis();
			AddScheduleEventManagementDialogBoxElements.getSubScheduleNameField(driver,1).sendKeys(subScheduleName[1]);
			AddScheduleEventManagementDialogBoxElements.getStartTime(driver,1).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setStartTime(driver, "10:00 AM",1).click();
			
			AddScheduleEventManagementDialogBoxElements.getEndTime(driver,1).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.setEEndTime(driver, "10:00 PM",1).click();
			
			AddScheduleEventManagementDialogBoxElements.GetScheduleEditButton(driver,1).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.GetWeeklyRadioButton(driver,1).click();
			Thread.sleep(2000);
			AddScheduleEventManagementDialogBoxElements.GetSaturdayCheckbox(driver, 1).click();
			AddScheduleEventManagementDialogBoxElements.GetSundayCheckbox(driver, 1).click();
			
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
			Assert.assertTrue(EditScheduleEventManagementDialogBoxElements.checkSubScheduleName(driver, subScheduleName[0]));
			Assert.assertTrue(EditScheduleEventManagementDialogBoxElements.checkSubScheduleName(driver, subScheduleName[1]));
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getEditScheduleCloseButton(driver).click();
			
			Thread.sleep(2000);
			
			CommonFunctions.map.put("Schedule", ScheduleName);
		
	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/
}
