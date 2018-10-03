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
import Tests.RegisterManagementTest.CreateProductTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddUpsellsToAssignmentTest extends TestSetup {

	//public static WebDriver driver=DriverManager.getDriver();

	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/
	public static String AssignmentName="";
	@Test()
	public static void AddUpsellsToAssignment()throws Exception
	{

		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPageElements.GetEventManagementLink(driver).click();		

		EventManagementPageElements.getTab(driver, "Assignments").click();
		Thread.sleep(5000);
		
		EventManagementPageElements.getColumn_AssignmentName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, CreateAssignmentTest.AssignmentName);
		Assert.assertEquals(EventManagementPageElements.getAssignmentNameFilteredValue(driver).getText(), CreateAssignmentTest.AssignmentName);
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		action.moveToElement(EventManagementPageElements.getAssignmentNameFilteredValue(driver)).doubleClick();
		action.perform();

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);
		
		EditAssignmentsEventManagementDialogBoxElements.gettab(driver, "Upsells").click();
		Thread.sleep(7000);
		EditAssignmentsEventManagementDialogBoxElements.getSelectProductDD(driver).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.SelectProductOptionFromDD(driver, CreateProductTest.ProductName);
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getTaxOpionDD(driver).click();
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.SelectTaxOptionFromDD(driver, CreateTaxOptionTest.TaxOptionName);
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.getPrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		EditAssignmentsEventManagementDialogBoxElements.setPrice(driver).sendKeys("2");
		Thread.sleep(2000);
		
		EditAssignmentsEventManagementDialogBoxElements.getUpsellSaveButton(driver).click();
		Thread.sleep(2000);		
		
		driver.switchTo().defaultContent();
		EditAssignmentsEventManagementDialogBoxElements.getCloseButton(driver).click();
		
		AssignmentName=CreateAssignmentTest.AssignmentName;
		
		System.out.println(AssignmentName);

	}

	
}
