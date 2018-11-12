package Tests.CreateEventManagementTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import GlobalFiles.CommonFunctions;
import ObjectRepository.AddAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateAssignmentTest extends TestSetup {

	//public static WebDriver driver=DriverManager.getDriver();

	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/
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
		AddAssignmentsEventManagementDialogBoxElements.setCategory(driver, CreateCategoryTest.CategoryName).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getLocationButton(driver).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setLocation(driver, CreateLocationDepartmentSiteTest.Location).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getSiteButton(driver).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setSiteOption(driver, CreateLocationDepartmentSiteTest.Site).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getTaxOptionButton(driver).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setTaxOption(driver, CreateTaxOptionTest.TaxOptionName).click();
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.getCapacity(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		AddAssignmentsEventManagementDialogBoxElements.setCapacity(driver).sendKeys(CommonFunctions.createAssignment_capacity);
		AddAssignmentsEventManagementDialogBoxElements.setExclusiveUse(driver).sendKeys(Keys.SPACE);
		AddAssignmentsEventManagementDialogBoxElements.getscheduleOptionButton(driver).click();
		Thread.sleep(3000);
		AddAssignmentsEventManagementDialogBoxElements.setScheduleOption(driver, CreateScheduleTest.ScheduleName).click();
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
		Thread.sleep(15000);
		EditAssignmentsEventManagementDialogBoxElements.getSelectPriceRuleButton(driver).click();
		Thread.sleep(5000);
		EditAssignmentsEventManagementDialogBoxElements.setPriceRule(driver, CommonFunctions.DepositPriceRule).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getPriceRuleSaveButton(driver).click();
		Thread.sleep(3000);
		EditAssignmentsEventManagementDialogBoxElements.getSelectPriceRuleButton(driver).click();
		Thread.sleep(5000);
		EditAssignmentsEventManagementDialogBoxElements.setPriceRule(driver, CommonFunctions.BasePriceRule).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getPriceRuleSaveButton(driver).click();
		Thread.sleep(2000);		
		
		driver.switchTo().defaultContent();
		EditAssignmentsEventManagementDialogBoxElements.getCloseButton(driver).click();
		
		CommonFunctions.map.put("Assignment", AssignmentName);
		
		System.out.println(AssignmentName);

	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/
}
