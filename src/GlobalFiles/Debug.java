package GlobalFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.AddModifierDialogBoxElements;
import ObjectRepository.AddModifierDialogBoxInsideAssignProductModifer;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.AssignProductModifiersDialogBoxElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;

public class Debug {
	public static WebDriver driver=null;
	public static String ModifierName="";
	public static void main(String[] args) throws InterruptedException {
		 driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		 Thread.sleep(5000);
		 CommonFunctions.Login(driver,CommonFunctions.UserName,CommonFunctions.Password);
		 Thread.sleep(5000);
		 
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
			
				 AddModifierDialogBoxElements.GetAddButton(driver).click();
				 Thread.sleep(2000);				 
				 CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, AddModifierDialogBoxElements.GetModifierValueColumn(driver, i),"MV1");
				 Thread.sleep(2000);			 
				 CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, AddModifierDialogBoxElements.GetPriceAdjustmentColumn(driver, i),"2");
				 Thread.sleep(2000);
				 
				/* CommonFunctions.ActionBuilder_OpenDropdownFromGridView(driver, AddModifierDialogBoxElements.GetProductOrGroupColumn(driver, i));
				 Thread.sleep(5000);
				 CommonFunctions.ActionBuilder_OpenDropdownFromGridView(driver, AddModifierDialogBoxElements.GetProductOrGroupColumn(driver, i));
				 Thread.sleep(5000);
				 
				 try
				 {
					 AddModifierDialogBoxElements.SelectFirstOptionFromProductOrGroupDropdown(driver);
					 Thread.sleep(2000);
				 }
				 catch (Exception e)
				 {
					 CommonFunctions.ActionBuilder_OpenDropdownFromGridView(driver, AddModifierDialogBoxElements.GetProductOrGroupColumn(driver, i));
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
