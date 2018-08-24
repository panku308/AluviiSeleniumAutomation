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
import ObjectRepository.AddPaymentPlan;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.MembershipPackagesPageElements;
import baseSetup.TestSetup;
import util.DriverManager;

public class CreatePaymentPlan extends TestSetup {

	public static String PaymentPlanName="";

	@Test()
	public static void createDiscountEntitlement()throws Exception
	{
		
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetMembershipPackagesLink(driver).click();		
			
			MembershipPackagesPageElements.GetPaymentPlansTab(driver).click();
			Thread.sleep(2000);
			MembershipPackagesPageElements.GetPaymentPlansTab_SelectOption(driver).click();
			Thread.sleep(2000);
			MembershipPackagesPageElements.GetPaymentTab_SelectOptionDropdownList(driver, "Add Payment Plan").click();
			Thread.sleep(2000);
			
			CommonFunctions.SwitchToContentFrame(driver);
//			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			PaymentPlanName="TestPaymentPlan_"+System.currentTimeMillis();
			Thread.sleep(2000);
			AddPaymentPlan.getIncrementalPaymentPlan(driver).click();
			Thread.sleep(2000);
			AddPaymentPlan.getPaymentPlanNameField(driver).sendKeys(PaymentPlanName);
			Thread.sleep(2000);
			AddPaymentPlan.getBillingFrequencySelectOptions(driver).click();
			Thread.sleep(2000);
			AddPaymentPlan.selectBillingFrequencyOptions(driver, "Monthly").click();
			Thread.sleep(2000);
			AddPaymentPlan.getNumberOfPeriodsField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPaymentPlan.setNumberOfPeriodsField(driver).sendKeys("10");
			Thread.sleep(2000);
			AddPaymentPlan.getDayOfMonthToBillField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPaymentPlan.setDayOfMonthToBillField(driver).sendKeys("2");
			Thread.sleep(2000);
			AddPaymentPlan.getSaveButton(driver).click();
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			MembershipPackagesPageElements.getColumn_PaymentPlanName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, PaymentPlanName);
			
			Assert.assertEquals(MembershipPackagesPageElements.getPaymentPlanNameFilteredValue(driver).getText(), PaymentPlanName);
			
			//Thread.sleep(2000);
			
			
			
			

		
	}

}
