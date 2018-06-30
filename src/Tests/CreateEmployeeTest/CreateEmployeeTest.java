package Tests.CreateEmployeeTest;

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
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import ObjectRepository.EditEmployeeDialogBox;

public class CreateEmployeeTest {

	public static WebDriver driver=null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}

	@Test
	public static void createEmployee()throws Exception
	{
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DashboardPageElements.GetHRManagementLink(driver).click();		  
			HRManagementPageElements.getManageEmployeeTab(driver).click();
			HRManagementPageElements.openSelectOptions(driver).click();
			Thread.sleep(2000);
			HRManagementPageElements.selectOptions(driver, "Add Employee").click();

			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println("iframe length = " + iframeElements.size());
			driver.switchTo().frame(0);

			String emailToBeRegistered="TestEmail"+System.currentTimeMillis()+"@aluvii.com";
			System.out.println(emailToBeRegistered);
			String passwordToBeRegistered="Admin@123";
			System.out.println(passwordToBeRegistered);

			AddEmployeeDialogBox.getEmployeeEmail(driver).sendKeys(emailToBeRegistered);
			AddEmployeeDialogBox.getFirstName(driver).sendKeys("TestFirstName");
			AddEmployeeDialogBox.getLastName(driver).sendKeys("TestLastName");
			Thread.sleep(2000);
			AddEmployeeDialogBox.getSave(driver).click();

			Thread.sleep(2000);

			driver.switchTo().defaultContent();		  

			Thread.sleep(2000);

			HRManagementPageElements.getEmailColumn(driver).click();
			CommonFunctions.filterTable(driver,emailToBeRegistered);
			String isRegisteredEmail=HRManagementPageElements.getEmail(driver).getText();

			Assert.assertEquals(isRegisteredEmail, emailToBeRegistered);

			Actions action = new Actions(driver);
			Action doubleClick = action.doubleClick(HRManagementPageElements.getEmail(driver)).build();
			doubleClick.perform();

			Thread.sleep(2000);

			driver.switchTo().frame(0);
			EditEmployeeDialogBox.getLoginActivityMenuLink(driver).click();
			EditEmployeeDialogBox.getAddLoginActivityButton(driver).click();

			Thread.sleep(2000);

			driver.switchTo().frame(0);
			AddLoginActivityDialogBox.getSelectActivityMenu(driver).click();
			Thread.sleep(2000);
			AddLoginActivityDialogBox.getDesiredActivityMenu(driver, "Administration (Activity)").click();
			Thread.sleep(2000);
			AddLoginActivityDialogBox.getAddActivityButton(driver).click();

			driver.switchTo().defaultContent();

			Thread.sleep(2000);

			driver.switchTo().frame(0);
			EditEmployeeDialogBox.getSetPasswordMenuLink(driver).click();
			EditEmployeeDialogBox.getNewPasswordInputBox(driver).sendKeys(passwordToBeRegistered);
			EditEmployeeDialogBox.getConfirmPasswordInputBox(driver).sendKeys(passwordToBeRegistered);
			EditEmployeeDialogBox.getUpdatePasswordButton(driver).click();

			driver.switchTo().defaultContent();

			Thread.sleep(2000);

			EditEmployeeDialogBox.getPopupCloseButton(driver).click();

			//logout;
			Thread.sleep(2000);
			action.moveToElement(DashboardPageElements.getUserMenu(driver)).clickAndHold();
			Thread.sleep(2000);
			action.moveToElement(DashboardPageElements.getLogoutButton(driver)).click().build().perform();
			Thread.sleep(2000);

			//Login
			CommonFunctions.Login(driver, emailToBeRegistered ,passwordToBeRegistered);
			Assert.assertTrue(DashboardPageElements.getSidebarMenu(driver, "Administration").isDisplayed());
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
