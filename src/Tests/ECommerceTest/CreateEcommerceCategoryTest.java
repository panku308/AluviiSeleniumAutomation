package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddCategoryDialogBoxInsideEcommerceProductsTabElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;

public class CreateEcommerceCategoryTest {
	  public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceCategoryName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateEcommerceCategory()throws Exception
	  {
		  EcommerceCategoryName = "Ecom-category-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Categories(driver).click();
		  Thread.sleep(3000);
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Categories_SelectOptionDD(driver).click();
		  Thread.sleep(2000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Category").click();
		  Thread.sleep(3000);
		  driver.switchTo().frame(0);
		  AddCategoryDialogBoxInsideEcommerceProductsTabElements.GetCategoryName(driver).sendKeys(EcommerceCategoryName);
		  AddCategoryDialogBoxInsideEcommerceProductsTabElements.GetWebsiteDD(driver).click();
		  Thread.sleep(2000);
		  System.out.println("WebsitetName = " + CreateWebsiteTest.WebsiteName);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, CreateWebsiteTest.WebsiteName).click();
		  
		  AddCategoryDialogBoxInsideEcommerceProductsTabElements.GetUploadButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().frame(0);
		  CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddCategoryDialogBoxInsideEcommerceProductsTabElements.GetSelectfilesButton(driver));
		  
		  Thread.sleep(3000);
		  CommonFunctions.UploadFile("C:\\Users\\DELL\\Downloads\\index.jpg");
		  Thread.sleep(30000);
		  driver.switchTo().parentFrame();
		  AddCategoryDialogBoxInsideEcommerceProductsTabElements.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Categories_CaetegoryNameColumnSettingsIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, EcommerceCategoryName);
		  Thread.sleep(2000);
		  assertEquals(ECommerceDashboardPageElements.GetProductsTab_SubTab_Categories_FirstRowCategoryNameColumn(driver).getText(), EcommerceCategoryName);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(5000);
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, CreateWebsiteTest.WebsiteName);  
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_FirstRowWebsiteNameColumn(driver).click();
		  ECommerceDashboardPageElements.GetWebsiteTab_SelectOptionDD(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Open Website").click();
		  Thread.sleep(10000);
		  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  WebsiteOpenPageElements.GetCategoriesDD(driver).click();
		  Thread.sleep(2000);
		  boolean actResult=false;
		  if(WebsiteOpenPageElements.GetCategoryFromCategoryList(driver, EcommerceCategoryName).isDisplayed())
		  {
			  actResult=true;
		  }
		  assertEquals(actResult,true);
		  
		  
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
	  }
}
