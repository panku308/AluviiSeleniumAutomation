package Tests.AdministrationTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AdministrationDashboardPageElements;
import ObjectRepository.DashboardPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class ChangeCardProcessorToKnox {
	
	public static WebDriver driver=null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public void ChangeCardProcessorToCardKnox() throws InterruptedException
	{
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetAdministrationLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetAdministrationLink(driver).click();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.GetConfigurationTab(driver).click();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.GetConfigTab_GatewayProcessorDD(driver).click();
		Thread.sleep(2000);
		CommonFunctions.SelectOptionFromDropdownList(driver, "CardKnox");
		AdministrationDashboardPageElements.GetConfigTab_GatewayActionURLField(driver).clear();
		AdministrationDashboardPageElements.GetConfigTab_GatewayActionURLField(driver).sendKeys("https://x1.cardknox.com/gateway");
		AdministrationDashboardPageElements.GetConfigTab_GatewayOnlineKeyField(driver).clear();
		AdministrationDashboardPageElements.GetConfigTab_GatewayOnlineKeyField(driver).sendKeys("AluviiDev_Test");
		Thread.sleep(2000);
		CommonFunctions.ScrollUptoElement(driver, AdministrationDashboardPageElements.GetConfigTab_SaveChangesButton(driver));
		Thread.sleep(2000);
		AdministrationDashboardPageElements.GetConfigTab_SaveChangesButton(driver).click();
		Thread.sleep(5000);
		
	}
}
