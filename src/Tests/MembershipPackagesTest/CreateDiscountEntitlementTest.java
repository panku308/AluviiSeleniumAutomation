package Tests.MembershipPackagesTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import GlobalFiles.CommonFunctions;
import ObjectRepository.AddAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.AddDiscountEntitlementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.MembershipPackagesPageElements;
import baseSetup.TestSetup;
import util.DriverManager;

public class CreateDiscountEntitlementTest extends TestSetup {

	

	@Test()
	public static void createDiscountEntitlement()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetMembershipPackagesLink(driver).click();		
			
			MembershipPackagesPageElements.GetDiscountEntitlementTab(driver).click();
			Thread.sleep(2000);
			MembershipPackagesPageElements.GetDiscountEntitlementTab_SelectOption(driver).click();
			Thread.sleep(2000);
			MembershipPackagesPageElements.GetDiscountEntitlementTab_SelectOptionDropdownList(driver, "Add Discount Entitlement").click();
			Thread.sleep(2000);
			
			CommonFunctions.SwitchToContentFrame(driver);
//			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			String DiscountEntitlementName="TestDiscountEntitlement_"+System.currentTimeMillis();
			
			AddDiscountEntitlementDialogBoxElements.getNameField(driver).sendKeys(DiscountEntitlementName);
			Thread.sleep(2000);
			AddDiscountEntitlementDialogBoxElements.selectProductType(driver).click();
			Thread.sleep(2000);
			AddDiscountEntitlementDialogBoxElements.selectProductTypeOption(driver, "Category").click();
			Thread.sleep(2000);
			AddDiscountEntitlementDialogBoxElements.setDiscountType(driver, "In Percentage").click();
			Thread.sleep(3000);
			AddDiscountEntitlementDialogBoxElements.getDiscountPercentageField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddDiscountEntitlementDialogBoxElements.setDiscountPercentageField(driver).sendKeys("0.5");
			Thread.sleep(2000);
			AddDiscountEntitlementDialogBoxElements.getSelectDiscountItemButton(driver).click();
			Thread.sleep(4000);
			AddDiscountEntitlementDialogBoxElements.setDiscountItem(driver).click();
			Thread.sleep(4000);
			AddDiscountEntitlementDialogBoxElements.getExtDescField(driver).sendKeys("Test Description");
			Thread.sleep(2000);
			AddDiscountEntitlementDialogBoxElements.GetSaveButton(driver).click();
			Thread.sleep(2000);
			
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			MembershipPackagesPageElements.getColumn_DiscountEntitlementName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, DiscountEntitlementName);
			
			Assert.assertEquals(MembershipPackagesPageElements.getDiscountEntitlementNameFilteredValue(driver).getText(), DiscountEntitlementName);
			
			Thread.sleep(2000);
			
			
			CommonFunctions.map.put("Discount_Entitlement", DiscountEntitlementName);

		
	}

}
