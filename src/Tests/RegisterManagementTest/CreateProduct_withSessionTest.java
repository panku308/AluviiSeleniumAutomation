package Tests.RegisterManagementTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditProductDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.ProductModifierInsideCashierRegisterElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import Tests.CreateEventManagementTest.CreateSchedule_withSessionTest;
import Tests.CreateWorkFlowTest.CreateWorkflowTest;
import baseSetup.TestSetup;
import util.DriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateProduct_withSessionTest extends TestSetup {

	// public static WebDriver driver=null;
	String expectedResult="", actualResult="";
	public static String ProductName1="";
	public static String ProductName2="";
	public static int SessionProduct=0;

	/* @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }*/
	@Test
	public void AddProductTest1()throws Exception
	{
		WebDriver driver = DriverManager.getDriver();
		ProductName1="product" + System.currentTimeMillis();
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		DashboardPageElements.GetRegisterManagementLink(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		Thread.sleep(3000);
		RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product").click();
		Thread.sleep(3000);
		CommonFunctions.SwitchToContentFrame(driver);

		AddProductDialogBoxElements.GetProductName(driver).sendKeys(ProductName1);

		AddProductDialogBoxElements.GetCategory(driver).click();		  
		Thread.sleep(5000);
		if(CreateCategoryTest.CategoryName!=null && !CreateCategoryTest.CategoryName.equals("")) {
			CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetLastPageButton(driver));
			System.out.println("After category lastpage button");
			CategoryDialogBoxElements.GetLastPageButton(driver).click();
			Thread.sleep(5000);
			CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName));
			Thread.sleep(2000);
			CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName).click();
			Thread.sleep(2000);
		}
		else
		{
			CategoryDialogBoxElements.GetStaticCategoryName(driver).click();
			Thread.sleep(2000);
		}


		AddProductDialogBoxElements.GetProductDescription(driver).sendKeys("Product description " + System.currentTimeMillis());
		AddProductDialogBoxElements.GetPricingTab(driver).click();
		Thread.sleep(3000);

		AddProductDialogBoxElements.SetUnitPrice(driver, CommonFunctions.CreateProduct_unitPrice);
		AddProductDialogBoxElements.GetSalesTaxTab(driver).click();
		Thread.sleep(3000);
		AddProductDialogBoxElements.GetSalesTax_LocationNameColumnSettingsIcon(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, CreateLocationDepartmentSiteTest.Location);
		Thread.sleep(2000);
		AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		Thread.sleep(2000);
		AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		Thread.sleep(2000);
		AddProductDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateTaxOptionTest.TaxOptionName);
		//AddProductDialogBoxElements.SelectfirstOptionFromTaxOptionDropdown(driver);
		Thread.sleep(2000);

		AddProductDialogBoxElements.GetOtherTab(driver).click();

		AddProductDialogBoxElements.getCheckbox_ThisProductIsASession(driver).click();

		AddProductDialogBoxElements.selectSite(driver).click();

		AddProductDialogBoxElements.selectSiteOption(driver, CreateLocationDepartmentSiteTest.Site).click();

		AddProductDialogBoxElements.selectSchedule(driver).click();

		AddProductDialogBoxElements.selectScheduleOption(driver, CreateSchedule_withSessionTest.ScheduleSessionName).click();

		AddProductDialogBoxElements.selectWorkflowBuilder(driver).click();

		AddProductDialogBoxElements.selectWorkflowBuilderOption(driver, CreateWorkflowTest.WorkflowName).click();  


		AddProductDialogBoxElements.GetAddButton(driver).click();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();

		RegisterManagementDashboardPageElements.getColumn_ProductName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, ProductName1);

		actualResult = RegisterManagementDashboardPageElements.getProductNameFilteredValue(driver).getText();
		assertEquals(actualResult, ProductName1);

		System.out.println(ProductName1);


	}
	@Test
	public void AddProductTest2()throws Exception
	{
		WebDriver driver = DriverManager.getDriver();
		ProductName2="product" + System.currentTimeMillis();
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		DashboardPageElements.GetRegisterManagementLink(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		Thread.sleep(3000);
		RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product").click();
		Thread.sleep(3000);
		CommonFunctions.SwitchToContentFrame(driver);

		AddProductDialogBoxElements.GetProductName(driver).sendKeys(ProductName2);

		AddProductDialogBoxElements.GetCategory(driver).click();		  
		Thread.sleep(5000);
		if(CreateCategoryTest.CategoryName!=null && !CreateCategoryTest.CategoryName.equals("")) {
			CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetLastPageButton(driver));
			System.out.println("After category lastpage button");
			CategoryDialogBoxElements.GetLastPageButton(driver).click();
			Thread.sleep(5000);
			CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName));
			Thread.sleep(2000);
			CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName).click();
			Thread.sleep(2000);
		}
		else
		{
			CategoryDialogBoxElements.GetStaticCategoryName(driver).click();
			Thread.sleep(2000);
		}


		AddProductDialogBoxElements.GetProductDescription(driver).sendKeys("Product description " + System.currentTimeMillis());
		AddProductDialogBoxElements.GetPricingTab(driver).click();
		Thread.sleep(3000);

		AddProductDialogBoxElements.SetUnitPrice(driver, CommonFunctions.CreateProduct_unitPrice);
		AddProductDialogBoxElements.GetSalesTaxTab(driver).click();
		Thread.sleep(3000);
		AddProductDialogBoxElements.GetSalesTax_LocationNameColumnSettingsIcon(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, CreateLocationDepartmentSiteTest.Location);
		Thread.sleep(2000);
		AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		Thread.sleep(2000);
		AddProductDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateTaxOptionTest.TaxOptionName);
		//AddProductDialogBoxElements.SelectfirstOptionFromTaxOptionDropdown(driver);
		Thread.sleep(2000);

		AddProductDialogBoxElements.GetOtherTab(driver).click();

		AddProductDialogBoxElements.getCheckbox_ThisProductIsASession(driver).click();

		AddProductDialogBoxElements.selectSite(driver).click();

		AddProductDialogBoxElements.selectSiteOption(driver, CreateLocationDepartmentSiteTest.Site).click();

		AddProductDialogBoxElements.selectSchedule(driver).click();

		AddProductDialogBoxElements.selectScheduleOption(driver, CreateSchedule_withSessionTest.ScheduleSessionName).click();

		AddProductDialogBoxElements.selectWorkflowBuilder(driver).click();

		AddProductDialogBoxElements.selectWorkflowBuilderOption(driver, CreateWorkflowTest.WorkflowName).click();  


		AddProductDialogBoxElements.GetAddButton(driver).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		RegisterManagementDashboardPageElements.getColumn_ProductName(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, ProductName2);

		actualResult = RegisterManagementDashboardPageElements.getProductNameFilteredValue(driver).getText();
		assertEquals(actualResult, ProductName2);

		System.out.println(ProductName2);


		Actions action = new Actions(driver);
		action.moveToElement(RegisterManagementDashboardPageElements.getProductNameFilteredValue(driver)).doubleClick();
		action.perform();

		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetOtherTab(driver).click();
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetEditButton(driver).click();
		
		//driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='k-content-frame' and @title='']")));
		Thread.sleep(5000);
		EditProductDialogBoxElements.GetCreateNewGroupButton(driver).click();
		Thread.sleep(10000);
		EditProductDialogBoxElements.GetSelectGroupDropdown(driver).click();
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetSelectGroupDropdownOption(driver).click();
		Thread.sleep(10000);
		
		EditProductDialogBoxElements.getQualifiedProducts(driver, ProductName1).click();
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetAddButton(driver).click();		
		Thread.sleep(2000);
		EditProductDialogBoxElements.getQualifiedProducts(driver, ProductName2).click();
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetAddButton(driver).click();
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetSaveGroupButton(driver).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);
		EditProductDialogBoxElements.GetSaveButton(driver).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		SessionProduct=1;

	}

}
