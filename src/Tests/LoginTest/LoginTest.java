package Tests.LoginTest;

import org.testng.annotations.Test;


import GlobalFiles.CommonFunctions;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import Tests.MembershipPackagesTest.CreateeEntranceEntitlementTest;
import baseSetup.TestSetup;
import util.DriverManager;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
@Listeners (GlobalFiles.ReportCustomization.class) 
	public class LoginTest extends TestSetup {
		public static WebDriver driver=null;
		
		
	  @Test()
	  public void Login() throws InterruptedException {

		  
		  CommonFunctions.Login(DriverManager.getDriver(),CommonFunctions.UserName,CommonFunctions.Password);
		  /*CreateLocationDepartmentSiteTest.Location="TestLocation1540197966173";
		  CreateLocationDepartmentSiteTest.Department="TestDepartment1540198025629";
		  CreateLocationDepartmentSiteTest.Site="TestSite1540198078304";
		  CreateeEntranceEntitlementTest.EntranceEntitlement="Entitlement-1540198169037";
		  CreateTaxOptionTest.TaxOptionName="TestTax1540198133336";*/
		  
		  Thread.sleep(3000);
		  //CommonFunctions.minimizeChatWindow(DriverManager.getDriver());
	  }
	/*  @BeforeSuite
	  public void beforeSuite() throws InterruptedException {
		  driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		  Thread.sleep(5000);
	  }
	
	  @AfterSuite
	  public void afterSuite() {
		//  driver.quit();
	  }*/
	
}
