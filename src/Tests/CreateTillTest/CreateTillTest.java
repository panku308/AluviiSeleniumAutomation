package Tests.CreateTillTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddEmployeeDialogBox;
import ObjectRepository.AddLoginActivityDialogBox;
import ObjectRepository.CashControlPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import ObjectRepository.EditEmployeeDialogBox;

public class CreateTillTest {

	public static WebDriver driver=null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		Thread.sleep(5000);
	}

	@Test
	public static void createEmployee()throws Exception
	{
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			CommonFunctions.Login(driver, "TestEmail464@aluvii.com", "Admin@123");
			DashboardPageElements.GetCashControlLink(driver).click();		  
			CashControlPageElements.getOpenTillTab(driver).click();
			CashControlPageElements.openSelectOptions(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectOptions(driver, "Create Till").click();

			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			//System.out.println("iframe length = " + iframeElements.size());
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			

			CashControlPageElements.selectLocation(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectLocationOption(driver, "Adventure").click();
			Thread.sleep(2000);
			CashControlPageElements.selectDepartment(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectDepartmentOption(driver, "Retail").click();
			Thread.sleep(2000);
			CashControlPageElements.selectSite(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectSiteOption(driver, "Gift Shop").click();
			Thread.sleep(4000);			
			CashControlPageElements.employeeAssigned(driver).click();
			Thread.sleep(2000);			
			
			CashControlPageElements.employeeAssignedList(driver, "TestFirstName29853 TestLastName8342").click();
			Thread.sleep(2000);
			
			CashControlPageElements.setInitialValue(driver).sendKeys("00");
			
			CashControlPageElements.saveCreateTill(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			CashControlPageElements.GetDashboardLink(driver).click();
			Thread.sleep(2000);
			Assert.assertEquals(DashboardPageElements.getCurrentTillStatus(driver).getText(), "Active");
			
			DashboardPageElements.GetCashControlLink(driver).click();
			CashControlPageElements.getAssigendToColumn(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver,"TestFirstName29853 TestLastName8342");
			Thread.sleep(2000);
			CashControlPageElements.getFilteredRow(driver).click();
			
			Thread.sleep(2000);
			CashControlPageElements.openSelectOptions(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.selectOptions(driver, "Close Till").click();
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			CashControlPageElements.getCloseTillButton(driver).click();
			Thread.sleep(2000);
			CashControlPageElements.getConfirmCloseTillButton(driver).click();
			
			Thread.sleep(2000);
			CashControlPageElements.GetDashboardLink(driver).click();
			Thread.sleep(2000);
			Assert.assertEquals(DashboardPageElements.getCurrentTillStatus(driver).getText(), "No Till");
			
			
			
			
			Thread.sleep(10000);

		}catch(Exception e)
		{
			Thread.sleep(10000);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}
}