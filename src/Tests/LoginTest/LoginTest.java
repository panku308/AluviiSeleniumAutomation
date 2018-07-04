package Tests.LoginTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
@Listeners (GlobalFiles.ReportCustomization.class) 
	public class LoginTest {
		public static WebDriver driver=null;
	  @Test
	  public void Login() throws InterruptedException {

		  
		  CommonFunctions.Login(driver,CommonFunctions.UserName,CommonFunctions.Password);
		  Thread.sleep(5000);
	  }
	  @BeforeSuite
	  public void beforeSuite() throws InterruptedException {
		  driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		  Thread.sleep(5000);
	  }
	
	  @AfterSuite
	  public void afterSuite() {
		//  driver.quit();
	  }
	
}
