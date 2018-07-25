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
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateCategoryTest {
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String CategoryName="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void AddCategoryTest()throws Exception
	  {
		  driver.navigate().refresh();
		  CategoryName="category_" + System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab_subtab_Categories(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Categories_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Category").click();
		  Thread.sleep(3000);
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  CommonFunctions.SwitchToContentFrame(driver);
		  
		  AddCategoryDialogBoxElements.GetCategoryNameField(driver).sendKeys(CategoryName);
		  AddCategoryDialogBoxElements.GetCategoryDescField(driver).sendKeys("categorydescription_"+System.currentTimeMillis());
		  AddCategoryDialogBoxElements.GetAddButton(driver).click();
		  
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  RegisterManagementDashboardPageElements.Get_ProductTab_SubTab_Categories_CategoryTable_IDColumn(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.Get_ProductTab_SubTab_Categories_CategoryTable_IDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = RegisterManagementDashboardPageElements.Get_ProductTab_SubTab_Categories_CategoryTable_FirstRowProductNameCloumn(driver).getText();
		  assertEquals(actualResult, CategoryName);
		  
	  }
	  
	  /*@AfterClass
	  public void afterClass() {
		  driver.quit();
			  
	  }*/
}
