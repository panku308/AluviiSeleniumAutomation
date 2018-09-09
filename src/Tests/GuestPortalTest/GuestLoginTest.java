package Tests.GuestPortalTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import util.DriverManager;

public class GuestLoginTest {
	public static WebDriver driver=null;
	 
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		 CommonFunctions.SetupGuestEnvironment(CommonFunctions.GuestURL, "chrome");
		  driver = CommonFunctions.GuestPortaldriver;
		  Thread.sleep(5000);
	  }
	 @Test()
	  public static void Login() throws InterruptedException {
		 CommonFunctions.GuestLogin(driver,CommonFunctions.GuestUserName,CommonFunctions.GuestPassword);
		 assertEquals(driver.getCurrentUrl(), CommonFunctions.GuestURL+"dashboard/dashboard"); 
	  }
	
}
