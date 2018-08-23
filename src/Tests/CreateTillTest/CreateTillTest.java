package Tests.CreateTillTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddEmployeeDialogBox;
import ObjectRepository.AddLoginActivityDialogBox;
import ObjectRepository.CashControlPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateTillTest extends TestSetup {

	@Test
	public static void createandCloseTill()throws Exception
	{
		WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			CommonFunctions.Login(driver, CommonFunctions.map.get("EmployeeEmail"), CommonFunctions.map.get("EmployeePass"));
			//CommonFunctions.Login(driver, "pankaj@aluvii.com", "Admin@123");
			DashboardPageElements.GetCashControlLink(driver).click();		  
			CashControlPageElements.getOpenTillTab(driver).click();
			CashControlPageElements.openSelectOptions(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectOptions(driver, "Create Till").click();

			//List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			//System.out.println("iframe length = " + iframeElements.size());
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			

			CashControlPageElements.selectLocation(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectLocationOption(driver, "Adventure").click();
			Thread.sleep(5000);
			CashControlPageElements.selectDepartment(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectDepartmentOption(driver, "Adventure").click();
			Thread.sleep(2000);
			CashControlPageElements.selectSite(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectSiteOption(driver, "Adventure").click();
			Thread.sleep(4000);			
			CashControlPageElements.employeeAssigned(driver).click();
			Thread.sleep(2000);			
			
			CashControlPageElements.employeeAssignedList(driver, CommonFunctions.map.get("EmployeeFirstName")+" "+CommonFunctions.map.get("EmployeeLastName")).click();
			Thread.sleep(2000);
			
			CashControlPageElements.getInitialValue(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			CashControlPageElements.setInitialValue(driver).sendKeys("100");
			
			CashControlPageElements.saveCreateTill(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			CashControlPageElements.GetDashboardLink(driver).click();
			Thread.sleep(2000);
			Assert.assertEquals(DashboardPageElements.getCurrentTillStatus(driver).getText(), "Active");
			
			DashboardPageElements.GetCashControlLink(driver).click();
			CashControlPageElements.getAssigendToColumn(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver,CommonFunctions.map.get("EmployeeFirstName")+" "+CommonFunctions.map.get("EmployeeLastName"));
			Thread.sleep(2000);
			CashControlPageElements.getFilteredRow(driver).click();
			
			Thread.sleep(2000);
			CashControlPageElements.openSelectOptions(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectOptions(driver, "Close Till").click();
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			CashControlPageElements.getCloseTillButton(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.getConfirmCloseTillButton(driver).click();
			
			Thread.sleep(2000);
			CashControlPageElements.GetDashboardLink(driver).click();
			Thread.sleep(2000);
			Assert.assertEquals(DashboardPageElements.getCurrentTillStatus(driver).getText(), "No Till");
			
			
			
			
			Thread.sleep(10000);

	}
}
