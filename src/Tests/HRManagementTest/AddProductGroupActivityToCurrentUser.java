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
import Tests.RegisterManagementTest.CreateRegisterWithProductGroupTest;
import Tests.RegisterManagementTest.CreateRegisterWithProductTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddProductGroupActivityToCurrentUser extends TestSetup{
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	 
	  @Test
	  public static void  AddProductActivityToUser()throws Exception
	  {
		  WebDriver driver=DriverManager.getDriver();
		  
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
			
			
			AddLoginActivityDialogBox.getDesiredActivityMenu(driver, CreateRegisterWithProductGroupTest.LoginActivity).click();
			Thread.sleep(2000);
			
			
			AddLoginActivityDialogBox.getAddActivityButton(driver).click();

			driver.switchTo().defaultContent();

			Thread.sleep(2000);

			EditEmployeeDialogBox.getPopupCloseButton(driver).click();
	  }
	
	
}
