package Tests.RegisterManagementTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateRegisterTest {
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String RegisterName="";
	  public static String LoginActivity="";
	  public static String Location="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
		  
	  }
	  @Test 
	  public static void AddRegisterTest()throws Exception
	  {
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
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  driver.switchTo().frame(0);
		  AddRegisterDialogboxElements.GetRegisterNameField(driver).sendKeys(RegisterName);
		  
		  AddRegisterDialogboxElements.GetLocationDD(driver).click();
		  Thread.sleep(2000);
		  //AddRegisterDialogboxElements.SelectFirstOptionFromLocationDD(driver);
		  AddRegisterDialogboxElements.SelectDynamicaLocation(driver, CreateLocationDepartmentSiteTest.Location);
		  //Location = AddRegisterDialogboxElements.GetSelectedLocationValue(driver);
		  
		  AddRegisterDialogboxElements.GetThermalReceiptDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromThermalReceiptDD(driver);
		  
		  AddRegisterDialogboxElements.GetAdvancedReceiptDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromAdvancedReceiptDD(driver);
		  
		  AddRegisterDialogboxElements.GetEmailReceiptDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromEmailReceiptDD(driver);
		  
		  AddRegisterDialogboxElements.GetEmailConfigurationDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromEmailConfigurationDD(driver);
		  
		  AddRegisterDialogboxElements.GetAddCategoryButton(driver).click();		  
		  Thread.sleep(2000);
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  
		  AddCategoryDialogboxInsideAddRegisterPageElements.GetCategoryDD(driver).click();
		  Thread.sleep(2000);
		  AddCategoryDialogboxInsideAddRegisterPageElements.SelectValueFromCategoryDD(driver, CreateCategoryTest.CategoryName);
		  //AddCategoryDialogboxInsideAddRegisterPageElements.SelectValueFromCategoryDD(driver, "category_1532270092594");
		  Thread.sleep(2000);
		  AddCategoryDialogboxInsideAddRegisterPageElements.GetAddCategoryButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().parentFrame();
		  AddRegisterDialogboxElements.GetAddProductButton(driver).click();
		  Thread.sleep(2000);
		  //CommonFunctions.MoveControToFrame(driver);
		  iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  AddProductDialogboxInsideAddRegisterPageElements.GetProductDD(driver).click();
		  Thread.sleep(2000);
		  AddProductDialogboxInsideAddRegisterPageElements.SelectValueFromProductDD(driver, CreateProductTest.ProductName, "product");
		  //AddProductDialogboxInsideAddRegisterPageElements.SelectValueFromProductDD(driver, "product1532270149533", "product");
		  Thread.sleep(2000);
		  AddProductDialogboxInsideAddRegisterPageElements.GetAddProductButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().parentFrame();
		  // Add product group
		  try {
			  AddRegisterDialogboxElements.GetAddProductButton(driver).click();
			  Thread.sleep(2000);			  
			  driver.switchTo().frame(0);
			  AddProductDialogboxInsideAddRegisterPageElements.GetProductDD(driver).click();
			  Thread.sleep(2000);
			  AddProductDialogboxInsideAddRegisterPageElements.SelectValueFromProductDD(driver, CreateProductGroupTest.ProductGroupName, "group");
			  Thread.sleep(2000);
			  AddProductDialogboxInsideAddRegisterPageElements.GetAddProductButton(driver).click();
			  Thread.sleep(2000);
			  driver.switchTo().parentFrame();
		  }catch(Exception e)
		  {
			  AddProductDialogboxInsideAddRegisterPageElements.GetProductDD(driver).click();
			  Thread.sleep(2000);
			  AddProductDialogboxInsideAddRegisterPageElements.GetCancelButton(driver).click();
			  Thread.sleep(2000);
			  driver.switchTo().parentFrame();
			  System.out.println(e);
		  }
		  AddRegisterDialogboxElements.GetSaveChangesButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  
		  
		  RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_IDColumn(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_IDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_FirstRowRegisterNameCloumn(driver).getText();
		  LoginActivity =  CreateLocationDepartmentSiteTest.Location+"- "+ RegisterName+" (Register)";		  
		  assertEquals(actualResult, RegisterName);
		  
	  }
	 
}
