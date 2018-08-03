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
import ObjectRepository.AddPriceRuleDialogBoxElements;
import ObjectRepository.AddScheduleEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreatePriceRuleTest extends TestSetup {

public static String priceRuleName="";
	@Test
	public static void createPriceRule()throws Exception
	{
		
			
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Price Rules").click();
			Thread.sleep(2000);
			EventManagementPageElements.getPriceRulesSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getPriceRulesSelectOptionDropdownList(driver, "Add Price Rule").click();
			Thread.sleep(2000);
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			 priceRuleName = "Deposit_"+System.currentTimeMillis();
			String displayAndDesc = "TestData_"+System.currentTimeMillis();
			
			
			AddPriceRuleDialogBoxElements.getPriceRuleNameField(driver).sendKeys(priceRuleName);
			AddPriceRuleDialogBoxElements.getDisplayNameField(driver).sendKeys(displayAndDesc);
			AddPriceRuleDialogBoxElements.getRuleTypeButton(driver).click();
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.selectRuleType(driver, "Deposit").click();
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getPercentage(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setPercentage(driver).sendKeys("50");
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getDescriptionField(driver).sendKeys(displayAndDesc);
			AddPriceRuleDialogBoxElements.getSaveButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PriceRuleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, priceRuleName);
			
			Assert.assertEquals(EventManagementPageElements.getPriceRuleNameFilteredValue(driver).getText(), priceRuleName);
			
		
			CommonFunctions.map.put("PriceRule", priceRuleName);
	}

	}
