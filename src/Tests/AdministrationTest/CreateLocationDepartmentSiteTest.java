package Tests.AdministrationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddDepartmentDialogBoxElements;
import ObjectRepository.AddLocationDialogBoxElements;
import ObjectRepository.AddSiteDialogBoxElements;
import ObjectRepository.AdministrationDashboardPageElements;
import ObjectRepository.DashboardPageElements;
import util.DriverManager;

public class CreateLocationDepartmentSiteTest {
	public static String Location="", Department="", Site="";
	
	@Test(priority=1)
	public static void createLocation()throws Exception
	{
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPageElements.GetAdminstrationLink(driver).click();		  
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocationTab(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocation_subLocationTab(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocationSelectOptionDropdownButton(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocationSelectOptionDropdownList(driver, "Add Location").click();
		
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		
		String LocationName="TestLocation"+System.currentTimeMillis();
		Location = LocationName;
		String Phone="8812345678";
		String Address="123 Main St.";
		String Zip="12345";
		String City="Miami";

		AddLocationDialogBoxElements.GetNameField(driver).sendKeys(LocationName);
		Thread.sleep(2000);
		AddLocationDialogBoxElements.GetPhoneField(driver).sendKeys(Phone);
		Thread.sleep(2000);
		AddLocationDialogBoxElements.GetAddressField(driver).sendKeys(Address);
		Thread.sleep(2000);
		AddLocationDialogBoxElements.GetCityField(driver).sendKeys(City);
		Thread.sleep(2000);
		AddLocationDialogBoxElements.GetZipField(driver).sendKeys(Zip);
		Thread.sleep(2000);
		AddLocationDialogBoxElements.getSelectTimeZoneButton(driver).click();
		Thread.sleep(2000);
		AddLocationDialogBoxElements.setSelectTimeZone(driver, "Denver").click();;
		Thread.sleep(2000);
		AddLocationDialogBoxElements.GetSaveButton(driver).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.getColumn_LocationName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, LocationName);
		
		Assert.assertEquals(AdministrationDashboardPageElements.getLocationNameFilteredValue(driver).getText(), LocationName);
		
		CommonFunctions.map.put("Location", LocationName);
		
	}

	@Test(priority=2)
	public static void createDepartment()throws Exception
	{
		
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		DashboardPageElements.GetAdminstrationLink(driver).click();		  
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocationTab(driver).click();
		Thread.sleep(4000);
		AdministrationDashboardPageElements.getLocation_subDepartmentTab(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getDepartmentSelectOptionDropdownButton(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getDepartmentSelectOptionDropdownList(driver, "Add Department").click();
		
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		
		String DepartmentName="TestDepartment"+System.currentTimeMillis();
		Department=DepartmentName;
		String Description="Test Description";
		

		AddDepartmentDialogBoxElements.GetDepartmentNameField(driver).sendKeys(DepartmentName);
		Thread.sleep(2000);
		AddDepartmentDialogBoxElements.selectLocation(driver).click();
		Thread.sleep(2000);
		AddDepartmentDialogBoxElements.selectLocationOption(driver, CommonFunctions.map.get("Location")).click();
		Thread.sleep(2000);
		AddDepartmentDialogBoxElements.GetDescriptionField(driver).sendKeys(Description);
		Thread.sleep(2000);
		AddDepartmentDialogBoxElements.GetSaveButton(driver).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.getColumn_DepartmentName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, DepartmentName);
		
		Assert.assertEquals(AdministrationDashboardPageElements.getDepartmentNameFilteredValue(driver).getText(), DepartmentName);
		
		CommonFunctions.map.put("Department", DepartmentName);
		
		
	}
	@Test(priority=3)
	public static void createSite()throws Exception
	{
		
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		DashboardPageElements.GetAdminstrationLink(driver).click();		  
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getLocationTab(driver).click();
		Thread.sleep(4000);
		AdministrationDashboardPageElements.getLocation_subSiteTab(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getSiteSelectOptionDropdownButton(driver).click();
		Thread.sleep(2000);
		AdministrationDashboardPageElements.getSiteSelectOptionDropdownList(driver, "Add Site").click();
		
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		
		String SiteName="TestSite"+System.currentTimeMillis();
		String Description="Test Description";
		Site = SiteName;

		AddSiteDialogBoxElements.GetSiteNameField(driver).sendKeys(SiteName);
		Thread.sleep(2000);
		AddSiteDialogBoxElements.getCapacity(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		AddSiteDialogBoxElements.setCapacity(driver).sendKeys("400");
		Thread.sleep(2000);
		AddSiteDialogBoxElements.selectLocation(driver).click();
		Thread.sleep(2000);
		AddSiteDialogBoxElements.selectLocationOption(driver, CommonFunctions.map.get("Location")).click();
		Thread.sleep(2000);
		AddSiteDialogBoxElements.selectDepartment(driver).click();
		Thread.sleep(2000);
		AddSiteDialogBoxElements.selectDepartmentOption(driver, CommonFunctions.map.get("Department")).click();
		Thread.sleep(2000);
		AddSiteDialogBoxElements.GetDescriptionField(driver).sendKeys(Description);
		Thread.sleep(2000);
		AddSiteDialogBoxElements.GetSaveButton(driver).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		AdministrationDashboardPageElements.getColumn_SiteName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, SiteName);
		
		Assert.assertEquals(AdministrationDashboardPageElements.getSiteNameFilteredValue(driver).getText(), SiteName);
		
		CommonFunctions.map.put("Site", SiteName);
		
		
	}
}
