package Tests.CreateEventManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
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
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreatePackageTest extends TestSetup {
	public static String packageName="";

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
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			 packageName = "TestPackage_"+System.currentTimeMillis();
			String description = "TestDescription_"+System.currentTimeMillis();		

			AddPackageDialogBoxElements.getPackageNameField(driver).sendKeys(packageName);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getDisplayPrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setDisplayPrice(driver).sendKeys("300");
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocation(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocationOption(driver, CreateLocationDepartmentSiteTest.Location).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getSelectAssignmentButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setAssignmentFromList(driver, CreateAssignmentTest.AssignmentName).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getShortDescriptionField(driver).sendKeys(description);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, CommonFunctions.BasePriceRule).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, CommonFunctions.DepositPriceRule).click();
			Thread.sleep(2000);
			//driver.switchTo().frame(0);
			//driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Editable area')]")));
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getFullDescriptionField(driver).sendKeys(description);
			
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			AddPackageDialogBoxElements.getSubmitButton(driver).click();
			Thread.sleep(2000);

			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PackageName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, packageName);
			
			Assert.assertEquals(EventManagementPageElements.getPackageNameFilteredValue(driver).getText(), packageName);
			
			Thread.sleep(2000);
			
			
			System.out.println(packageName);
			
		}catch(Exception e)
		{
			Thread.sleep(10000);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	}
