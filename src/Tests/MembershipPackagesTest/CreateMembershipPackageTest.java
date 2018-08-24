package Tests.MembershipPackagesTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import GlobalFiles.CommonFunctions;
import ObjectRepository.AddAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.AddDiscountEntitlementDialogBoxElements;
import ObjectRepository.AddMembershipDiscountEntitlementDialogBoxElements;
import ObjectRepository.AddMembershipEntranceEntitlementDialogBoxElements;
import ObjectRepository.AddMembershipPackageDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.MembershipPackagesPageElements;
import Tests.AdministrationTest.CreateTaxOptionTest;
import baseSetup.TestSetup;
import util.DriverManager;

public class CreateMembershipPackageTest extends TestSetup {

	

	@Test()
	public static void createMembershipPackage()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetMembershipPackagesLink(driver).click();		
			
			MembershipPackagesPageElements.GetPackagesTab(driver).click();
			Thread.sleep(2000);
			MembershipPackagesPageElements.GetPackageTab_SelectOption(driver).click();
			Thread.sleep(2000);
			MembershipPackagesPageElements.GetPackageTab_SelectOptionDropdownList(driver, "Add Membership Package").click();
			Thread.sleep(2000);
			
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			
			String PackageName="TestPackage_"+System.currentTimeMillis();
			
			AddMembershipPackageDialogBoxElements.getPackageNameField(driver).sendKeys(PackageName);
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getTaxOption(driver).click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.setTaxOption(driver, CreateTaxOptionTest.TaxOptionName).click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getSalePrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.setSalePrice(driver).sendKeys("20");
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getLengthTypeButton(driver).click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.setLengthType(driver, "Floating Expiration").click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getMembershipLength(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.setMembershipLength(driver).sendKeys("365");
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getMembershipCheckbox(driver).click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getRenewablePrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.setRenewablePrice(driver).sendKeys("15");
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getSellabeThroughGuestPortalCheckbox(driver).click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.getSellableCheckbox(driver).click();
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.GetNextButton(driver).click();			
			Thread.sleep(4000);
			AddMembershipPackageDialogBoxElements.getAddEntranceButton(driver).click();
			Thread.sleep(4000);
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
		
			AddMembershipEntranceEntitlementDialogBoxElements.GetSelectEntranceEntitlementButton(driver).click();
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					AddMembershipEntranceEntitlementDialogBoxElements.selectEntranceEntitlement(driver,  
							CommonFunctions.map.get("Entrance_Entitlement")));
			Thread.sleep(5000);
			AddMembershipEntranceEntitlementDialogBoxElements.GetAddEntranceButton(driver).click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			
			AddMembershipPackageDialogBoxElements.getAddDiscountButton(driver).click();
			Thread.sleep(4000);
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			AddMembershipDiscountEntitlementDialogBoxElements.GetSelectDiscountEntitlementButton(driver).click();
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
					AddMembershipDiscountEntitlementDialogBoxElements.selectDiscountEntitlement(driver,  
							CommonFunctions.map.get("Discount_Entitlement")));
			Thread.sleep(5000);
			AddMembershipDiscountEntitlementDialogBoxElements.GetAddDiscountButton(driver).click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			AddMembershipPackageDialogBoxElements.GetSubmitButton(driver).click();
			Thread.sleep(4000);
			
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			MembershipPackagesPageElements.getColumn_PackageName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, PackageName);
			
			Assert.assertEquals(MembershipPackagesPageElements.getPackageNameFilteredValue(driver).getText(), PackageName);
			
			Thread.sleep(2000);
			
			
			//CommonFunctions.map.put("Assignment", DiscountEntitlementName);

		
	}

}
