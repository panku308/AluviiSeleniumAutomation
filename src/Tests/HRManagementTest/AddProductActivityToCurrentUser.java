package Tests.HRManagementTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddLoginActivityDialogBox;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.HRManagementPageElements;
import Tests.RegisterManagementTest.CreateRegisterTest;
import Tests.RegisterManagementTest.CreateSimpleRegisterTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddProductActivityToCurrentUser {
	public static WebDriver driver=null;
	public static String expectedResult="", actualResult="";
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public static void  AddProductActivityToUser()throws Exception
	{

		DashboardPageElements.GetHRManagementLink(driver).click();
		Thread.sleep(2000);

		HRManagementPageElements.getEmailColumn(driver).click();
		CommonFunctions.filterTable(driver,CommonFunctions.UserName);
		String isRegisteredEmail=HRManagementPageElements.getEmail(driver).getText();

		Assert.assertEquals(isRegisteredEmail, CommonFunctions.UserName);

		Actions action = new Actions(driver);
		Action doubleClick = action.doubleClick(HRManagementPageElements.getEmail(driver)).build();
		doubleClick.perform();

		Thread.sleep(5000);

		CommonFunctions.SwitchToContentFrame(driver);
		EditEmployeeDialogBox.getLoginActivityMenuLink(driver).click();
		Thread.sleep(5000);
		EditEmployeeDialogBox.getAddLoginActivityButton(driver).click();

		Thread.sleep(4000);

		CommonFunctions.SwitchToContentFrame(driver);
		AddLoginActivityDialogBox.getSelectActivityMenu(driver).click();
		Thread.sleep(2000);
		try {
			AddLoginActivityDialogBox.getDesiredActivityMenu(driver, CreateRegisterTest.LoginActivity).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			Thread.sleep(2000);
			AddLoginActivityDialogBox.getDesiredActivityMenu(driver, CreateSimpleRegisterTest.LoginActivity).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		AddLoginActivityDialogBox.getAddActivityButton(driver).click();

		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		EditEmployeeDialogBox.getPopupCloseButton(driver).click();
	}


}
