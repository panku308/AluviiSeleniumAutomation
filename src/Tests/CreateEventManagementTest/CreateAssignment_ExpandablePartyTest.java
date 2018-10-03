package Tests.CreateEventManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditAssignmentsEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateMultipleSitesForExpandableBooking;
import Tests.AdministrationTest.CreateTaxOptionTest;
import util.DriverManager;

public class CreateAssignment_ExpandablePartyTest {
	


	//public static WebDriver driver=DriverManager.getDriver();

	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/
	
	public static int AssignmentCapacity[]=new int[3];
	public static String multipleAssignmentName[] = new String[3];
	
	@Test()
	public static void createAssignment()throws Exception
	{
		
		for(int i=0;i<3;i++)
		{
			if(i<2)
			{
				AssignmentCapacity[i]=25;
			}
			else
			{
				AssignmentCapacity[i]=50;
			}
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		

			EventManagementPageElements.getTab(driver, "Assignments").click();
			Thread.sleep(2000);
			EventManagementPageElements.getAssignmentsSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getAssignmentsSelectOptionDropdownList(driver, "Add Assignment").click();
			Thread.sleep(2000);

			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);

			multipleAssignmentName[i]="TestAssignmentRoom_"+i+"_"+System.currentTimeMillis();
			AddAssignmentsEventManagementDialogBoxElements.getAssignmentNameField(driver).sendKeys(multipleAssignmentName[i]);
			AddAssignmentsEventManagementDialogBoxElements.getCategoryButton(driver).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setCategory(driver, CommonFunctions.map.get("Category")).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getLocationButton(driver).click();
			Thread.sleep(2000);
//			 CreateLocationDepartmentSiteTest.Location="TestLocation1537433440270";
			AddAssignmentsEventManagementDialogBoxElements.setLocation(driver, CreateLocationDepartmentSiteTest.Location).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getSiteButton(driver).click();
			Thread.sleep(2000);
		//	CreateLocationDepartmentSiteTest.Site="TestSite1537433552184";
			AddAssignmentsEventManagementDialogBoxElements.setSiteOption(driver, CreateMultipleSitesForExpandableBooking.MultipleSites[i]).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getTaxOptionButton(driver).click();
			Thread.sleep(2000);
		//	CreateTaxOptionTest.TaxOptionName="TestTax1537433606785";
			AddAssignmentsEventManagementDialogBoxElements.setTaxOption(driver, CreateTaxOptionTest.TaxOptionName).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.getCapacity(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setCapacity(driver).sendKeys(String.valueOf(AssignmentCapacity[i]));
			AddAssignmentsEventManagementDialogBoxElements.setExclusiveUse(driver).sendKeys(Keys.SPACE);
			AddAssignmentsEventManagementDialogBoxElements.getscheduleOptionButton(driver).click();
			Thread.sleep(3000);
			
			
			AddAssignmentsEventManagementDialogBoxElements.setScheduleOption(driver, CommonFunctions.map.get("Schedule")).click();
			Thread.sleep(2000);
			AddAssignmentsEventManagementDialogBoxElements.setViewOnEventPortal(driver).sendKeys(Keys.SPACE);
			AddAssignmentsEventManagementDialogBoxElements.GetAddButton(driver).click();


			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_AssignmentName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, multipleAssignmentName[i]);
			Assert.assertEquals(EventManagementPageElements.getAssignmentNameFilteredValue(driver).getText(), multipleAssignmentName[i]);
			Thread.sleep(2000);

			Actions action = new Actions(driver);
			action.moveToElement(EventManagementPageElements.getAssignmentNameFilteredValue(driver)).doubleClick();
			action.perform();

			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			EditAssignmentsEventManagementDialogBoxElements.gettab(driver, "Pricing").click();
			Thread.sleep(7000);
			EditAssignmentsEventManagementDialogBoxElements.getSelectPriceRuleButton(driver).click();
			Thread.sleep(3000);
			EditAssignmentsEventManagementDialogBoxElements.setPriceRule(driver, CommonFunctions.map.get("PriceRule_TypeDeposit")).click();
			Thread.sleep(2000);
			EditAssignmentsEventManagementDialogBoxElements.getSaveButton(driver).click();
			Thread.sleep(3000);
			EditAssignmentsEventManagementDialogBoxElements.getSelectPriceRuleButton(driver).click();
			Thread.sleep(2000);
			EditAssignmentsEventManagementDialogBoxElements.setPriceRule(driver, CreatePriceRuleForExpandableParty.ExpandableBasePriceRuleName[i]).click();
			Thread.sleep(2000);
			EditAssignmentsEventManagementDialogBoxElements.getSaveButton(driver).click();
			Thread.sleep(2000);		

			
			EditAssignmentsEventManagementDialogBoxElements.getUpsellsTab(driver).click();
			Thread.sleep(7000);
			EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_ProductDD(driver).click();
			Thread.sleep(2000);
			EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_SelectProduct(driver, "Candy Bar").click();
			EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_TaxOptionButton(driver).click();
			Thread.sleep(2000);
			EditAssignmentsEventManagementDialogBoxElements.setUpsellTab_TaxOption(driver,CreateTaxOptionTest.TaxOptionName).click();
			
			EditAssignmentsEventManagementDialogBoxElements.getUpsellTab_PriceField(driver).sendKeys("0.99");
			EditAssignmentsEventManagementDialogBoxElements.getSaveButton(driver).click();
		
			driver.switchTo().defaultContent();
			EditAssignmentsEventManagementDialogBoxElements.getCloseButton(driver).click();
			
		
		}
		
		
	}

	/*@AfterClass
	public void afterClass() {
		//driver.quit();

	}*/

}
