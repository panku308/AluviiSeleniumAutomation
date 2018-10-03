package Tests.CreateEventManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddPackageDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import util.DriverManager;

public class CreateMultiplePackages_ExpandableParty {

	public static String ExpandablePackageName[]=new String[3];
	public static int ExpandableDisplayPrice []= new int[3];
	@Test
	public static void createPackage()throws Exception
	{
		for(int i =0;i<3;i++)
		{

			
			WebDriver driver=DriverManager.getDriver();
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
			String packageName = "";
			if(i==0)
			{
				packageName="TestPackage_Super-"+System.currentTimeMillis();
			}
			else if (i==1)
			{
				packageName="TestPackage_Mini-"+System.currentTimeMillis();
			}
			else if(i==2)
			{
				packageName="TestPackage_Expandable-"+System.currentTimeMillis();
			}
			ExpandablePackageName[i] = packageName;
			String description = "TestDescription_"+System.currentTimeMillis();		

			AddPackageDialogBoxElements.getPackageNameField(driver).sendKeys(ExpandablePackageName[i]);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getDisplayPrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setDisplayPrice(driver).sendKeys("25");
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocation(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.selectLocationOption(driver, CreateLocationDepartmentSiteTest.Location).click();
			Thread.sleep(2000);
			if(i<2)
			{
				AddPackageDialogBoxElements.getSelectAssignmentButton(driver).click();
				Thread.sleep(2000);
				AddPackageDialogBoxElements.setAssignmentFromList(driver, CreateAssignment_ExpandablePartyTest.multipleAssignmentName[0]).click();
				Thread.sleep(2000);
				AddPackageDialogBoxElements.getSelectAssignmentButton(driver).click();
				Thread.sleep(2000);
				AddPackageDialogBoxElements.setAssignmentFromList(driver, CreateAssignment_ExpandablePartyTest.multipleAssignmentName[1]).click();
				Thread.sleep(2000);
			}
			else
			{
				AddPackageDialogBoxElements.getSelectAssignmentButton(driver).click();
				Thread.sleep(2000);
				AddPackageDialogBoxElements.setAssignmentFromList(driver, CreateAssignment_ExpandablePartyTest.multipleAssignmentName[i]).click();
				Thread.sleep(2000);
			}
			
			AddPackageDialogBoxElements.getShortDescriptionField(driver).sendKeys(description);
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, CreatePriceRuleForExpandableParty.ExpandableBasePriceRuleName[i]).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.getPriceRuleButton(driver).click();
			Thread.sleep(2000);
			AddPackageDialogBoxElements.setPriceRuleFromList(driver, CreatePriceRuleTest.PriceRule_TypeDeposit).click();
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
			AddPackageDialogBoxElements.getSubmitButton(driver).click();
			Thread.sleep(2000);

			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PackageName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, ExpandablePackageName[i]);
			
			Assert.assertEquals(EventManagementPageElements.getPackageNameFilteredValue(driver).getText(), ExpandablePackageName[i]);
			
			Thread.sleep(2000);
		
		}
		
	}

	
	
	
}
