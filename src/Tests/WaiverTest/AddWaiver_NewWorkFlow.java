package Tests.WaiverTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddWaiverDialogBoxElements;
import ObjectRepository.WaiverManagementPageElements;

public class AddWaiver_NewWorkFlow {
	 
	 public static WebDriver driver=null;
	 String WaiverName="";
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	 @Test (priority=1)
	 public  void AddWaiver() throws InterruptedException
	 {
		 WaiverName = "waiver" + System.currentTimeMillis();
		  Thread.sleep(2000);
		  WaiverManagementPageElements.OpenWaiverManagementPage(driver);
		  AddWaiverDialogBoxElements.AddWaiver_NewFlow(driver, WaiverName);
	 }
}
