package Tests.CreateEventManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddPackageDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateProduct_withSessionTest;
import util.DriverManager;

public class CreateWaterfallPackageTest {
	
	public static WebDriver driver=null;
	public static String packageName="";
	public static String WaterfallProductName="", WaterFallAssignment="";
	public static String WaterfallAssignmentTime1="03:00 AM";
	public static String WaterfallAssignmentTime2="03:00 AM";
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public static void createPackage()throws Exception
	{
			/*			 
			WaterfallProductName=CreateProduct_withSessionTest.ProductName1;
			WaterFallAssignment= CreateAssignmentTest.AssignmentName;			
			*/
		
			WaterfallProductName="Session_Product1537436876005";
			WaterFallAssignment= "TestAssignment_1537436664172";
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Package").click();
			Thread.sleep(2000);
			EventManagementPageElements.getPackageSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getPackageSelectOptionDropdownList(driver, "Add Package").click();
			Thread.sleep(2000);
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			 packageName = "WaterfallPackage_"+System.currentTimeMillis();
			String description = "TestDescription_"+System.currentTimeMillis();		

			AddPackageDialogBoxElements.getPackageNameField(driver).sendKeys(packageName);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.GetIsWaterfallPackageRadioButton(driver).click();
			
			
			AddPackageDialogBoxElements.getDisplayPrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setDisplayPrice(driver).sendKeys("25");
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocation(driver).click();
			Thread.sleep(2000);
			//AddPackageDialogBoxElements.selectLocationOption(driver, CreateLocationDepartmentSiteTest.Location).click();
			AddPackageDialogBoxElements.selectLocationOption(driver, "TestLocation1537436176744").click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getSelectAssignmentButton(driver).click();
			Thread.sleep(2000);
			//AddPackageDialogBoxElements.setAssignmentFromList(driver, CreateAssignmentTest.AssignmentName).click();
			AddPackageDialogBoxElements.setAssignmentFromList(driver, "TestAssignment_1537436664172").click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getShortDescriptionField(driver).sendKeys(description);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			//AddPackageDialogBoxElements.setPriceRuleFromList(driver, CreatePriceRuleTest.PriceRule_TypeBasePrice).click();
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, "BasePrice_1537436523334").click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			//AddPackageDialogBoxElements.setPriceRuleFromList(driver, CreatePriceRuleTest.PriceRule_TypeDeposit).click();
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, "Deposit_1537436586808").click();
			Thread.sleep(2000);
			//driver.switchTo().frame(0);
			//driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Editable area')]")));
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getFullDescriptionField(driver).sendKeys(description);
			
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			CommonFunctions.ScrollUptoElement(driver, AddPackageDialogBoxElements.getSubmitButton(driver));//just to access the dropdowns.
			AddPackageDialogBoxElements.getSelectProductDD(driver).click();
			Thread.sleep(1000);
			//AddPackageDialogBoxElements.SelectProduct(driver,WaterfallProductName );
			AddPackageDialogBoxElements.SelectProduct(driver, "Session_Product1537436876005").click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getTaxOption(driver).click();
			Thread.sleep(2000);
			//AddPackageDialogBoxElements.SelectTaxOption(driver, CreateTaxOptionTest.TaxOptionName);
			AddPackageDialogBoxElements.SelectTaxOption(driver, "TestTax1537436340681").click();
			AddPackageDialogBoxElements.getPriceField(driver).sendKeys("5");
			AddPackageDialogBoxElements.GetUpsellProductSaveButton(driver).click();
			Thread.sleep(2000);
			
			AddPackageDialogBoxElements.getSubmitButton(driver).click();
			Thread.sleep(2000);

			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PackageName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, packageName);			
			Assert.assertEquals(EventManagementPageElements.getPackageNameFilteredValue(driver).getText(), packageName);			
			Thread.sleep(2000);
			WaterfallSetup();
			
	}
	public static void WaterfallSetup()throws Exception
	{
		CommonFunctions.ActionBuilder_PerformDoubleClickEventOnElement(driver, EventManagementPageElements.getPackageNameFilteredValue(driver));
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
		Thread.sleep(2000);
		AddPackageDialogBoxElements.getWaterFallSetupTab(driver).click();
		Thread.sleep(10000);
		AddPackageDialogBoxElements.getWaterFallSetupTab_Group0DD(driver).click();
		Thread.sleep(2000);
		AddPackageDialogBoxElements.SelectWaterFallSetupTab_Group0(driver, WaterfallProductName).click();
		
		AddPackageDialogBoxElements.getWaterFallSetupTab_Group1DD(driver).click();
		Thread.sleep(2000);
		AddPackageDialogBoxElements.SelectWaterFallSetupTab_Group1(driver, "Assignments").click();
		Thread.sleep(2000);
		AddPackageDialogBoxElements.GetWaterFallSetupTab_ManuallyAddPackageButton(driver).click();
		Thread.sleep(2000);
		
		AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTemplateGroup0(driver, WaterfallProductName+"-2").click();		
		AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTemplateGroup1(driver, WaterFallAssignment).click();
		
		String time=AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTimeGroup0(driver, WaterfallProductName+"-2").getAttribute("title");
		System.out.println(time);
		AddPackageDialogBoxElements.GetWaterFallSetupTab_SaveButton(driver).click();
		Thread.sleep(2000);
		AddPackageDialogBoxElements.GetWaterFallSetupTab_RecurringButton(driver).click();
		Thread.sleep(2000);
		AddPackageDialogBoxElements.GetWaterFallSetupTab_NextDayForwardIcon(driver).click();
		Thread.sleep(2000);
		String ProductColor = AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTemplateGroup0(driver, WaterfallProductName+"-2").getCssValue("background-color");
		String AssingmentColor = AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTemplateGroup1(driver, WaterFallAssignment).getCssValue("background-color");
		
		System.out.println(ProductColor);
		System.out.println(AssingmentColor);
		for(int i =0;i<10;i++)
		{
			AddPackageDialogBoxElements.GetWaterFallSetupTab_NextDayForwardIcon(driver).click();	
		}
		AddPackageDialogBoxElements.GetWaterFallSetupTab_AddedPackage(driver, WaterFallAssignment+ "-3:00 AM - 3:45 AM").click();
		ProductColor = AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTemplateGroup0(driver, WaterfallProductName+"-2").getCssValue("background-color");
		AssingmentColor = AddPackageDialogBoxElements.GetWaterFallSetupTab_EventTemplateGroup1(driver, WaterFallAssignment).getCssValue("background-color");
		
		System.out.println(ProductColor);
		System.out.println(AssingmentColor);
		driver.switchTo().defaultContent();
		AddPackageDialogBoxElements.GetCloseIcon(driver).click();
		
	}
	
}
