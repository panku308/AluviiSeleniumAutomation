package Tests.RegisterManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddDiscountPackageDialogBoxElements;
import ObjectRepository.AddDiscountRuleDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageDiscountCodesDialogBoxElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import util.DriverManager;

public class CreateDiscountInPercentageForAssignment {
	

	public static String discountPercentage="0.5";



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
			
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.getDiscountRuleName(driver).sendKeys(discountRuleName);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.getDiscountProductType(driver).click();
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.setDiscountProductType(driver, "EventAssignment").click();
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.getDiscountType_InPercentageRadioButton(driver).click();
			AddDiscountRuleDialogBoxElements.getDiscountField(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.setDiscount(driver).sendKeys(discountPercentage);
			Thread.sleep(2000);
			AddDiscountRuleDialogBoxElements.selectDiscountItemButton(driver).click();
			Thread.sleep(3000);
			//need to add product name related line.
			AddDiscountRuleDialogBoxElements.selectProduct(driver, CommonFunctions.AssignmentName).click();
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
			
			CommonFunctions.SwitchToContentFrame(driver);
			
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getDiscountPackageName(driver).sendKeys(discountPackageName);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getUsesAllowedPerTransactionField(driver).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.setUsesAllowedPerTransaction(driver).sendKeys("1000");
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getPackageDescriptionField(driver).sendKeys(packageDescription);
			Thread.sleep(2000);
			
			String fromDate=CommonFunctions.getPresentDate();
			String toDate=fromDate.replaceAll("2018", "2019");
	
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getDateofFirestUseField(driver).sendKeys(fromDate);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getExpirationDateField(driver).sendKeys(toDate);
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.GetAddButton(driver).click();
			Thread.sleep(3000);
			
			CommonFunctions.SwitchToContentFrame(driver);
			
			Thread.sleep(2000);
			AddDiscountPackageDialogBoxElements.getColumn_DiscountRuleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, CommonFunctions.map.get("DiscountRule"));
			Thread.sleep(3000);
			AddDiscountPackageDialogBoxElements.selectDiscountRule(driver).click();			
			
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			CommonFunctions.SwitchToContentFrame(driver);
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
			CommonFunctions.SwitchToContentFrame(driver);
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
