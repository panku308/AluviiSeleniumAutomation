package Tests.CreateEventManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

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
import ObjectRepository.AddCategoryEventManagementDialogBoxElements;
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
public class CreateCategoryTest extends TestSetup {

	//public static WebDriver driver=DriverManager.getDriver();

	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/
	public static String CategoryName="";

	@Test
	public static void createCategory()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Other Settings").click();
			Thread.sleep(2000);
			EventManagementPageElements.getOtherSettingsSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getOtherSettingsSelectOptionDropdownList(driver, "Add Category").click();
			Thread.sleep(2000);
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			 CategoryName="TestCategory_"+System.currentTimeMillis();
			
			AddCategoryEventManagementDialogBoxElements.getCategoryNameField(driver).sendKeys(CategoryName);
			AddCategoryEventManagementDialogBoxElements.getCategoryDescField(driver).sendKeys("Test Category Description");
			AddCategoryEventManagementDialogBoxElements.GetAddButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_CategoryName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, CategoryName);
			
			Assert.assertEquals(EventManagementPageElements.getCategoryNameFilteredValue(driver).getText(), CategoryName);
			
			Thread.sleep(2000);
			
			CommonFunctions.map.put("Category", CategoryName);

		
	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/
}
