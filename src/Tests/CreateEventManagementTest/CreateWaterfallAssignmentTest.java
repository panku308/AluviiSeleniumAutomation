package Tests.CreateEventManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import util.DriverManager;

public class CreateWaterfallAssignmentTest {


	public static WebDriver driver = null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	public static String AssignmentName="";
	@Test()
	public static void createAssignment()throws Exception
	{
		
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPageElements.GetEventManagementLink(driver).click();		

		EventManagementPageElements.getTab(driver, "Assignments").click();
		Thread.sleep(2000);
		EventManagementPageElements.getAssignmentsSelectOptionDropdownButton(driver).click();
		Thread.sleep(2000);
		EventManagementPageElements.getAssignmentsSelectOptionDropdownList(driver, "Add Assignment").click();
		Thread.sleep(2000);

		//driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);

		AssignmentName="TestAssignment_"+System.currentTimeMillis();
		AddAssignmentsEventManagementDialogBoxElements.getAssignmentNameField(driver).sendKeys(AssignmentName);
		AddAssignmentsEventManagementDialogBoxElements.getCategoryButton(driver).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setCategory(driver, CommonFunctions.map.get("Category")).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getLocationButton(driver).click();
		Thread.sleep(2000);
//		 CreateLocationDepartmentSiteTest.Location="TestLocation1537433440270";
		AddAssignmentsEventManagementDialogBoxElements.setLocation(driver, CreateLocationDepartmentSiteTest.Location).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getSiteButton(driver).click();
		Thread.sleep(2000);
	//	CreateLocationDepartmentSiteTest.Site="TestSite1537433552184";
		AddAssignmentsEventManagementDialogBoxElements.setSiteOption(driver, CreateLocationDepartmentSiteTest.Site).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getTaxOptionButton(driver).click();
		Thread.sleep(2000);
	//	CreateTaxOptionTest.TaxOptionName="TestTax1537433606785";
		AddAssignmentsEventManagementDialogBoxElements.setTaxOption(driver, CreateTaxOptionTest.TaxOptionName).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getCapacity(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setCapacity(driver).sendKeys("40");
		AddAssignmentsEventManagementDialogBoxElements.setExclusiveUse(driver).sendKeys(Keys.SPACE);
		AddAssignmentsEventManagementDialogBoxElements.getscheduleOptionButton(driver).click();
		Thread.sleep(3000);
		
		
		AddAssignmentsEventManagementDialogBoxElements.setScheduleOption(driver, CreateWaterfallScheduleTest.ScheduleName).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setViewOnEventPortal(driver).sendKeys(Keys.SPACE);
		AddAssignmentsEventManagementDialogBoxElements.GetAddButton(driver).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		EventManagementPageElements.getColumn_AssignmentName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, AssignmentName);
		Assert.assertEquals(EventManagementPageElements.getAssignmentNameFilteredValue(driver).getText(), AssignmentName);
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		action.moveToElement(EventManagementPageElements.getAssignmentNameFilteredValue(driver)).doubleClick();
		action.perform();

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);
		
		EditAssignmentsEventManagementDialogBoxElements.gettab(driver, "Pricing").click();
		Thread.sleep(7000);
		EditAssignmentsEventManagementDialogBoxElements.getSelectPriceRuleButton(driver).click();
		Thread.sleep(3000);
		EditAssignmentsEventManagementDialogBoxElements.setPriceRule(driver, CommonFunctions.map.get("PriceRule_TypeDeposit")).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getSaveButton(driver).click();
		Thread.sleep(3000);
		EditAssignmentsEventManagementDialogBoxElements.getSelectPriceRuleButton(driver).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.setPriceRule(driver, CommonFunctions.map.get("PriceRule_TypeBasePrice")).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getSaveButton(driver).click();
		Thread.sleep(2000);		
		
		EditAssignmentsEventManagementDialogBoxElements.getUpsellsTab(driver).click();
		Thread.sleep(7000);
		EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_ProductDD(driver).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_SelectProduct(driver, "Candy Bar").click();
		EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_TaxOptionButton(driver).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.setUpsellTab_TaxOption(driver,CreateTaxOptionTest.TaxOptionName).click();
		
		EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_PriceField(driver).sendKeys("2");
		EditAssignmentsEventManagementDialogBoxElements.getSaveButton(driver).click();
		
		
		driver.switchTo().defaultContent();
		EditAssignmentsEventManagementDialogBoxElements.getCloseButton(driver).click();
		
		CommonFunctions.map.put("Assignment", AssignmentName);
		
	}

	

	
}
