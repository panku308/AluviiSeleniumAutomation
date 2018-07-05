package Tests.RegisterManagementTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddModifierDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateProductModifier {  
	public static WebDriver driver=null;
	public static String expectedResult="", actualResult="";
	public static String ModifierName="";
	public static String ModifierValue[] = new String[2];
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public static void CreateModifier()throws Exception
	{
		
		ModifierName = "Modifer_" + System.currentTimeMillis();
		 DashboardPageElements.GetRegisterManagementLink(driver).click();
		 Thread.sleep(5000);
		 RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		 Thread.sleep(5000);
		 RegisterManagementDashboardPageElements.GetProductsTab_subtab_Modifiers(driver).click();
		 Thread.sleep(5000);
		 RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Modifiers_SelectOptionDropdown(driver).click();
		 Thread.sleep(3000);
		 RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Modifier").click();
		 Thread.sleep(3000);
		 driver.switchTo().frame(0);
		 AddModifierDialogBoxElements.GetModifierName(driver).sendKeys(ModifierName);
		 AddModifierDialogBoxElements.GetModifierTypeDD(driver).click();
		 Thread.sleep(3000);
		 RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Single").click();
		 Thread.sleep(2000);

		 for(int i=1;i<=2;i++)
		 {
			 	 ModifierValue[i-1]="MV_"+System.currentTimeMillis();
				 AddModifierDialogBoxElements.GetAddButton(driver).click();
				 Thread.sleep(2000);				 
				 CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, AddModifierDialogBoxElements.GetModifierValueColumn(driver, i),ModifierValue[i-1]);
				 Thread.sleep(2000);			 
				 CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, AddModifierDialogBoxElements.GetPriceAdjustmentColumn(driver, i),String.valueOf(i));
				 Thread.sleep(2000);
				 
				/* CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddModifierDialogBoxElements.GetProductOrGroupColumn(driver, i));
				 Thread.sleep(5000);
				 CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddModifierDialogBoxElements.GetProductOrGroupColumn(driver, i));
				 Thread.sleep(5000);
				 
				 try
				 {
					 AddModifierDialogBoxElements.SelectFirstOptionFromProductOrGroupDropdown(driver);
					 Thread.sleep(2000);
				 }
				 catch (Exception e)
				 {
					 CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddModifierDialogBoxElements.GetProductOrGroupColumn(driver, i));
					 Thread.sleep(5000);
					 AddModifierDialogBoxElements.SelectFirstOptionFromProductOrGroupDropdown(driver);
					 Thread.sleep(2000);
				 }*/
				 
				 
				 
				 CommonFunctions.ActionBuilder_EnterValueInTextbox(driver,AddModifierDialogBoxElements.GetQuantityColumn(driver, i),"11");
				 Thread.sleep(2000);
				 
				 CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddModifierDialogBoxElements.GetAddOrRemoveColumn(driver, i));
				 Thread.sleep(5000);			 
				 CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddModifierDialogBoxElements.GetAddOrRemoveColumn(driver, i));
				 Thread.sleep(5000);
				 try
				 {
					 AddModifierDialogBoxElements.SelectDynamicOptionFromAddOrRemoveDD(driver, "Add");
					 Thread.sleep(2000);
				 }
				 catch(Exception e)
				 {
					 CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddModifierDialogBoxElements.GetAddOrRemoveColumn(driver, i));
					 Thread.sleep(5000);
					 AddModifierDialogBoxElements.SelectDynamicOptionFromAddOrRemoveDD(driver, "Add");
					 Thread.sleep(2000);
				 }
				 
			
		 }
		 AddModifierDialogBoxElements.GetSaveButton(driver).click();
		 Thread.sleep(5000);
		 driver.switchTo().defaultContent();
		 try
		 {
			 VerifyModifierRecord(driver);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
	}
	public static void VerifyModifierRecord(WebDriver driver) throws InterruptedException
	{
		RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Modifier_ModifierNameColumnSettingsIcon(driver).click();
		 Thread.sleep(2000);
		 CommonFunctions.filterTable(driver,ModifierName);
		 int i = RegisterManagementDashboardPageElements.GetSearchRecordRowCountOfModifierTable(driver);
		 if(i==1)
		 {
			 assertTrue(true);
			 assertEquals(RegisterManagementDashboardPageElements.Get_ModifierTable_FirstRowModifierNameCloumn(driver).getText().toLowerCase().trim(), ModifierName.toLowerCase().trim());
		 }
		 else
		 {
			 assertFalse(false, "number of record expected =1, actual records found = "+i);
		 }
		 
	}
}
