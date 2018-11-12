package Tests.RegisterManagementTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddCategoryDialogBoxElements;
import ObjectRepository.AddCategoryDialogboxInsideAddRegisterPageElements;
import ObjectRepository.AddProductDialogboxInsideAddRegisterPageElements;
import ObjectRepository.AddRegisterDialogboxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateSimpleRegisterTest extends TestSetup{
	public static WebDriver driver=null;
	public static String expectedResult="", actualResult="";
	public static String RegisterName="";
	public static String LoginActivity="";
	public static String Location="";
	
	@Test 
	public static void AddRegisterTest()throws Exception
	{
		driver=DriverManager.getDriver();
		RegisterName="Register_" + System.currentTimeMillis();
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		DashboardPageElements.GetRegisterManagementLink(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetRegistersTab(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetRegistersTab_subtab_Registers(driver).click();
		Thread.sleep(3000);
		RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_SelectOptionDropdown(driver).click();
		Thread.sleep(3000);
		RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Register").click();
		Thread.sleep(3000);
		CommonFunctions.SwitchToContentFrame(driver);
		AddRegisterDialogboxElements.GetRegisterNameField(driver).sendKeys(RegisterName);

		AddRegisterDialogboxElements.GetLocationDD(driver).click();
		Thread.sleep(2000);
		//AddRegisterDialogboxElements.SelectFirstOptionFromLocationDD(driver);
		AddRegisterDialogboxElements.SelectDynamicaLocation(driver, CreateLocationDepartmentSiteTest.Location);
		//Location = AddRegisterDialogboxElements.GetSelectedLocationValue(driver);
		Thread.sleep(2000);
		AddRegisterDialogboxElements.GetThermalReceiptDD(driver).click();
		Thread.sleep(2000);
		AddRegisterDialogboxElements.SelectFirstOptionFromThermalReceiptDD(driver);
		Thread.sleep(2000);
		AddRegisterDialogboxElements.GetAdvancedReceiptDD(driver).click();
		Thread.sleep(2000);
		AddRegisterDialogboxElements.SelectFirstOptionFromAdvancedReceiptDD(driver);
		Thread.sleep(2000);
		AddRegisterDialogboxElements.GetEmailReceiptDD(driver).click();
		Thread.sleep(2000);
		AddRegisterDialogboxElements.SelectFirstOptionFromEmailReceiptDD(driver);
		Thread.sleep(2000);
		AddRegisterDialogboxElements.GetEmailConfigurationDD(driver).click();
		Thread.sleep(2000);
		AddRegisterDialogboxElements.SelectFirstOptionFromEmailConfigurationDD(driver);
		Thread.sleep(2000);
		AddRegisterDialogboxElements.GetAddCategoryButton(driver).click();		  
		Thread.sleep(4000);
		//CommonFunctions.ActionBuilder_PerformDoubleClickEventOnElement(driver, AddCategoryDialogboxInsideAddRegisterPageElements.GetWindowTitle(driver));		  
		CommonFunctions.SwitchToContentFrame(driver);
		Thread.sleep(2000);
		AddCategoryDialogboxInsideAddRegisterPageElements.GetCategoryDD(driver).click();
		Thread.sleep(4000);
		//System.out.println("Category = " + CreateCategoryTest.CategoryName);
		Thread.sleep(2000);
		AddCategoryDialogboxInsideAddRegisterPageElements.SelectValueFromCategoryDD(driver, CreateCategoryTest.CategoryName);
		//AddCategoryDialogboxInsideAddRegisterPageElements.SelectValueFromCategoryDD(driver, "category_1532270092594");
		Thread.sleep(2000);
		AddCategoryDialogboxInsideAddRegisterPageElements.GetAddCategoryButton(driver).click();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		CommonFunctions.SwitchToContentFrame(driver);
		AddRegisterDialogboxElements.GetAddProductButton(driver).click();
		Thread.sleep(2000);
		//CommonFunctions.MoveControToFrame(driver);
		CommonFunctions.SwitchToContentFrame(driver);
		AddProductDialogboxInsideAddRegisterPageElements.GetProductDD(driver).click();
		Thread.sleep(2000);

		
		AddProductDialogboxInsideAddRegisterPageElements.SelectValueFromProductDD(driver, CreateProductTest.ProductName, "product");
		
		
		//AddProductDialogboxInsideAddRegisterPageElements.SelectValueFromProductDD(driver, "product1532270149533", "product");
		Thread.sleep(2000);  


		AddProductDialogboxInsideAddRegisterPageElements.GetAddProductButton(driver).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		CommonFunctions.SwitchToContentFrame(driver);


		Thread.sleep(2000);
		AddRegisterDialogboxElements.GetSaveChangesButton(driver).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		RegisterManagementDashboardPageElements.getColumn(driver, "Register Name").click();
		CommonFunctions.filterTable(driver, RegisterName);
		Assert.assertEquals(RegisterManagementDashboardPageElements.getRegisterNameFilteredValue(driver).getText(), RegisterName);

		LoginActivity =  CreateLocationDepartmentSiteTest.Location+"- "+ RegisterName+" (Register)";	
		System.out.println("Simple Register Test execution is complete");
	}

}
