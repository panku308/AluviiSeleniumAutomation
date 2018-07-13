package Tests.RegisterManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import ObjectRepository.AddDiscountPackageDialogBoxElements;
import ObjectRepository.AddDiscountRuleDialogBoxElements;
import ObjectRepository.AddScheduleEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import ObjectRepository.ManageDiscountCodesDialogBoxElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;

public class CreateDiscountTest extends TestSetup {


	@Test(priority=1)
	public static void createDiscountRule()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetRegisterManagementLink(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscountTab(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscount_subTab_DiscountRules(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscountsTab_SubTab_DiscountRule_SelectOptionDropdown(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Rule").click();
			Thread.sleep(2000);
			
			String discountRuleName="TestDiscountRule_"+System.currentTimeMillis();
			String externalDescription="TestDescription_"+System.currentTimeMillis();
			
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.getDiscountRuleName(driver).sendKeys(discountRuleName);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.getDiscountProductType(driver).click();
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.setDiscountProductType(driver, "Product").click();
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.getDiscountField(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.setDiscount(driver).sendKeys("2");
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.selectDiscountItemButton(driver).click();
			Thread.sleep(3000);
			AddDiscountRuleDialogBoxElements.selectProduct(driver, "Adventurer Thermal").click();
			Thread.sleep(3000);
			AddDiscountRuleDialogBoxElements.getExternalDescriptionField(driver).sendKeys(externalDescription);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.GetSaveButton(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			RegisterManagementDashboardPageElements.getColumn_DiscountRuleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, discountRuleName);
			Thread.sleep(2000);
			Assert.assertEquals(RegisterManagementDashboardPageElements.getDiscountRuleNameFilteredValue(driver).getText(), discountRuleName);
			Thread.sleep(2000);
			
			CommonFunctions.map.put("DiscountRule", discountRuleName);
			Thread.sleep(2000);
			
		
	}
	
	@Test(priority=2)
	public static void createDiscountPackage()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			DashboardPageElements.GetRegisterManagementLink(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscountTab(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscount_subTab_DiscountPackage(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscountsTab_SubTab_DiscountPackage_SelectOptionDropdown(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Discount Package").click();
			Thread.sleep(2000);
			
			String discountPackageName="TestDiscountPackage_"+System.currentTimeMillis();
			String packageDescription="TestPackageDescription_"+System.currentTimeMillis();
			
			driver.switchTo().frame(0);
			
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getDiscountPackageName(driver).sendKeys(discountPackageName);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getUsesAllowedPerTransactionField(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.setUsesAllowedPerTransaction(driver).sendKeys("1000");
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getPackageDescriptionField(driver).sendKeys(packageDescription);
			Thread.sleep(2000);
			
			String fromDate=CommonFunctions.getDate();
			String toDate=fromDate.replaceAll("2018", "2019");
	
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getDateofFirestUseField(driver).sendKeys(fromDate);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getExpirationDateField(driver).sendKeys(toDate);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.GetAddButton(driver).click();
			Thread.sleep(3000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getColumn_DiscountRuleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, CommonFunctions.map.get("DiscountRule"));
			Thread.sleep(3000);
			AddDiscountPackageDialogBoxElements.selectDiscountRule(driver).click();			
			
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			AddDiscountPackageDialogBoxElements.GetSaveChangesButton(driver).click();
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			RegisterManagementDashboardPageElements.getColumn_DiscountPackageName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, discountPackageName);
			Thread.sleep(2000);
			Assert.assertEquals(RegisterManagementDashboardPageElements.getDiscountPackageNameFilteredValue(driver).getText(), discountPackageName);
			Thread.sleep(2000);
			
			RegisterManagementDashboardPageElements.getDiscountPackageNameFilteredValue(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.GetDiscountsTab_SubTab_DiscountPackage_SelectOptionDropdown(driver).click();
			Thread.sleep(2000);
			RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Manage Discount Codes").click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			String discountCode="Code"+System.currentTimeMillis();
			
			ManageDiscountCodesDialogBoxElements.getAddCodeButton(driver).click();
			Thread.sleep(2000);
			ManageDiscountCodesDialogBoxElements.getDiscountCodeField(driver).sendKeys(discountCode);
			Thread.sleep(3000);
			ManageDiscountCodesDialogBoxElements.getDiscountCodeField(driver).sendKeys(Keys.TAB);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			ManageDiscountCodesDialogBoxElements.getPopupCloseButton(driver).click();
			Thread.sleep(2000);
			
	
	}


}
