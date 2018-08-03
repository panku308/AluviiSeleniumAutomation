package Tests.ManageMembershipsTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.ManageMembershipsPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class VerifyMembershipPackage {
	
	 public static WebDriver driver=null;
	 String ActResult="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void VerifyMemberhsipDetails()
	  {
		  ActResult = ManageMembershipsPageElements.GetMembershipPackageName(driver, 1).getText().trim();
		  assertEquals(ActResult, "10 pass");				  
	  }
}
