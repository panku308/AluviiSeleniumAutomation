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
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;

public class CreateEmployeeTest extends TestSetup{

	
	@Test()
	public static void createEmployee()throws Exception
	{
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPageElements.GetHRManagementLink(driver).click();		  
		HRManagementPageElements.getManageEmployeeTab(driver).click();
		HRManagementPageElements.openSelectOptions(driver).click();
		Thread.sleep(2000);
		HRManagementPageElements.selectOptions(driver, "Add Employee").click();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		//System.out.println("iframe length = " + iframeElements.size());
		//driver.switchTo().frame(0);
		CommonFunctions.SwitchToContentFrame(driver);

		String emailToBeRegistered="TestEmail"+System.currentTimeMillis()+"@aluvii.com";
		//System.out.println(emailToBeRegistered);
		String passwordToBeRegistered="Admin@123";
		//System.out.println(passwordToBeRegistered);
		String firstName="TestFirstName"+System.currentTimeMillis();
		String lastName="TestLastName"+System.currentTimeMillis();
		
		
		
		AddEmployeeDialogBox.getEmployeeEmail(driver).sendKeys(emailToBeRegistered);
		AddEmployeeDialogBox.getFirstName(driver).sendKeys(firstName);
		AddEmployeeDialogBox.getLastName(driver).sendKeys(lastName);
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

		//driver.switchTo().frame(0);
		CommonFunctions.SwitchToContentFrame(driver);
		EditEmployeeDialogBox.getLoginActivityMenuLink(driver).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);


		int menuSize=1;
		do
		{

			//driver.switchTo().frame(0);
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			EditEmployeeDialogBox.getAddLoginActivityButton(driver).click();
			Thread.sleep(2000);
			//driver.switchTo().frame(0);
			CommonFunctions.SwitchToContentFrame(driver);
			Thread.sleep(2000);
			AddLoginActivityDialogBox.getSelectActivityMenu(driver).click();
			Thread.sleep(2000);

			if(AddLoginActivityDialogBox.getActivityMenu(driver).getText().contains("(Activity)"))
			{

				Thread.sleep(2000);
				AddLoginActivityDialogBox.getActivityMenu(driver).click();

				Thread.sleep(2000);
				AddLoginActivityDialogBox.getAddActivityButton(driver).click();
				Thread.sleep(2000);

				menuSize++;

			}
			else
			{
				Thread.sleep(2000);
				AddLoginActivityDialogBox.getActivityMenu(driver).click();
				Thread.sleep(2000);				
				AddLoginActivityDialogBox.getCancelActivityButton(driver).click();
				Thread.sleep(2000);
				break;
			}

			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}while(menuSize<=30);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		CommonFunctions.SwitchToContentFrame(driver);
		Thread.sleep(2000);

		EditEmployeeDialogBox.getSetPasswordMenuLink(driver).click();
		EditEmployeeDialogBox.getNewPasswordInputBox(driver).sendKeys(passwordToBeRegistered);
		EditEmployeeDialogBox.getConfirmPasswordInputBox(driver).sendKeys(passwordToBeRegistered);
		EditEmployeeDialogBox.getUpdatePasswordButton(driver).click();

		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		//EditEmployeeDialogBox.getPopupCloseButton(driver).click();
		action.moveToElement(EditEmployeeDialogBox.getPopupCloseButton(driver)).click().build().perform();

		//logout;
		Thread.sleep(3000);
		DashboardPageElements.getUserMenu(driver).click();
		Thread.sleep(3000);
		action.moveToElement(DashboardPageElements.getLogoutButton(driver));
		action.click().build().perform();
		Thread.sleep(2000);

		//Login
		CommonFunctions.Login(driver, emailToBeRegistered, passwordToBeRegistered);		
		Thread.sleep(2000);
		Assert.assertEquals(DashboardPageElements.getAddedActivityMenuSize(driver), menuSize);
		Thread.sleep(2000);

		//logout;
		Thread.sleep(3000);
		DashboardPageElements.getUserMenu(driver).click();
		Thread.sleep(3000);
		action.moveToElement(DashboardPageElements.getLogoutButton(driver));
		action.click().build().perform();
		Thread.sleep(2000);

		CommonFunctions.map.put("EmployeeEmail", emailToBeRegistered);
		CommonFunctions.map.put("EmployeePass", passwordToBeRegistered);
		CommonFunctions.map.put("EmployeeFirstName", firstName);
		CommonFunctions.map.put("EmployeeLastName", lastName);

	}
}
