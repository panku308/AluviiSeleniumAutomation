package Tests.AdministrationTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import GlobalFiles.CommonFunctions;
import ObjectRepository.AddTaxOptionDialogBoxElements;
import ObjectRepository.AdministrationDashboardPageElements;
import ObjectRepository.DashboardPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateTaxOptionTest extends TestSetup{
	public static String TaxOptionName="";
	//TestTax1536419029340
	
	@Test
	public static void createTaxOption()throws Exception
	{
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPageElements.GetAdminstrationLink(driver).click();		  
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocationTab(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocation_subTaxOptionTab(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getTaxOptionSelectOptionDropdownButton(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getTaxSelectOptionDropdownList(driver, "Add Tax Option").click();
		
		Thread.sleep(2000);
		//driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);
		
		TaxOptionName="TestTax"+System.currentTimeMillis();

		AddTaxOptionDialogBoxElements.getTaxOptionName(driver).sendKeys(TaxOptionName);
		Thread.sleep(2000);
		AddTaxOptionDialogBoxElements.selectLocation(driver).click();
		Thread.sleep(2000);
		AddTaxOptionDialogBoxElements.selectLocationOption(driver, CreateLocationDepartmentSiteTest.Location).click();
		Thread.sleep(2000);
		AddTaxOptionDialogBoxElements.getTaxRate(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		AddTaxOptionDialogBoxElements.setTaxRate(driver).sendKeys("0.1");
		Thread.sleep(2000);
		AddTaxOptionDialogBoxElements.getDescField(driver).sendKeys("Test Description");
		Thread.sleep(2000);
		AddTaxOptionDialogBoxElements.GetSaveButton(driver).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.getColumn_TaxOptionName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, TaxOptionName);
		
		Assert.assertEquals(AdministrationDashboardPageElements.getTaxOptionNameNameFilteredValue(driver).getText(), TaxOptionName);
		
		//CommonFunctions.map.put("TaxOption", TaxOptionName);
		
	}

	
}
