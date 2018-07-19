package Tests.CreateEventManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import ObjectRepository.AddPackageDialogBoxElements;
import ObjectRepository.AddPriceRuleDialogBoxElements;
import ObjectRepository.AddScheduleEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;

public class CreatePackageTest extends TestSetup {


	@Test
	public static void createPackage()throws Exception
	{
		try {
			
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Package").click();
			Thread.sleep(2000);
			EventManagementPageElements.getPackageSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getPackageSelectOptionDropdownList(driver, "Add Package").click();
			Thread.sleep(2000);
			
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			String packageName = "TestPackage_"+System.currentTimeMillis();
			String description = "TestDescription_"+System.currentTimeMillis();		

			AddPackageDialogBoxElements.getPackageNameField(driver).sendKeys(packageName);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getDisplayPrice(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setDisplayPrice(driver).sendKeys("25");
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocation(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocationOption(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getSelectAssignmentButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setAssignmentFromList(driver, CommonFunctions.map.get("Assignment")).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getShortDescriptionField(driver).sendKeys(description);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, CommonFunctions.map.get("PriceRule")).click();
			
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getFullDescriptionField(driver).sendKeys(description);
			
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(0);
			AddPackageDialogBoxElements.getSubmitButton(driver).click();
			Thread.sleep(2000);

			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PackageName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, packageName);
			
			Assert.assertEquals(EventManagementPageElements.getPackageNameFilteredValue(driver).getText(), packageName);
			
			Thread.sleep(2000);
			
			
		}catch(Exception e)
		{
			Thread.sleep(10000);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	}