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
		 /* CreateLocationDepartmentSiteTest.Location="TestLocation1542028273556";
		  CreateLocationDepartmentSiteTest.Department="TestDepartment1542028330005";
		  CreateLocationDepartmentSiteTest.Site="TestSite1542028379183";
		  CreateeEntranceEntitlementTest.EntranceEntitlement="Entitlement-1542028463541";
		  CreateTaxOptionTest.TaxOptionName="TestTax1542028429577";*/
		  
		  Thread.sleep(3000);
		  //CommonFunctions.minimizeChatWindow(DriverManager.getDriver());
		  CommonFunctions.changeLanguageToEnglish(DriverManager.getDriver());
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
