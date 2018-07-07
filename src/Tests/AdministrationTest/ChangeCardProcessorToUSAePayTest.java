package Tests.AdministrationTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AdministrationDashboardPageElements;
import ObjectRepository.DashboardPageElements;

public class ChangeCardProcessorToUSAePayTest {
	
	public static WebDriver driver=null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public void ChangeCardProcessorToUSAePay() throws InterruptedException
	{
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetAdministrationLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetAdministrationLink(driver).click();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.GetConfigurationTab(driver).click();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.GetConfigTab_GatewayProcessorDD(driver).click();
		Thread.sleep(2000);
		CommonFunctions.SelectOptionFromDropdownList(driver, "USAePay");
		AdministrationDashboardPageElements.GetConfigTab_USAePaySandboxRadiobutton(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.GetConfigTab_GatewayOnlineKeyField(driver).clear();
		AdministrationDashboardPageElements.GetConfigTab_GatewayOnlineKeyField(driver).sendKeys("GZaIjl8ExwvIxnHbifc69qB58t87Iixu");
		AdministrationDashboardPageElements.GetConfigTab_GatewayOnlinePin(driver).clear();
		AdministrationDashboardPageElements.GetConfigTab_GatewayOnlinePin(driver).sendKeys("1111");
		AdministrationDashboardPageElements.GetConfigTab_SaveChangesButton(driver).click();
		Thread.sleep(5000);
		
	}
}
