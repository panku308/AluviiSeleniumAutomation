package Tests.AccessControlTest;

import static org.testng.Assert.assertEquals;

import java.security.AccessControlContext;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AccessControlPageElements;
import ObjectRepository.DashboardPageElements;
import Tests.MembershipPackagesTest.CreateeEntranceEntitlementTest;
import org.openqa.selenium.WebElement;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class ScanAndVerifyBarcode {
	public static WebDriver driver=null;
	public static String ExpResult="Sorry, but your Ticket is not valid at current Entrance.",ActResult="";
	public static boolean isAlreadyUsed=false;
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public void BarcodeScanVerification()throws Exception
	{
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetAccessControlLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetAccessControlLink(driver).click();
		Thread.sleep(3000);
		List<WebElement> AccessTypeDDOptions = AccessControlPageElements.GetLiTagsOfAccessTypeDD(driver);
		System.out.println(AccessTypeDDOptions.size());
		for(WebElement e:AccessTypeDDOptions)
		{
			AccessControlPageElements.GetAccessTypeDD(driver).click();
			Thread.sleep(2000);
			String optionName=e.getText().trim() ;
			CommonFunctions.SelectOptionFromDropdownList(driver,optionName);
			//CommonFunctions.SelectOptionFromDropdownList(driver, CreateeEntranceEntitlementTest.EntranceEntitlement);
			AccessControlPageElements.GetSearchBarcodeField(driver).sendKeys("7F7B51D238BD4");
			AccessControlPageElements.GetScanButton(driver).click();
			Thread.sleep(5000);			
			System.out.println("("+e.getText().trim()+"), (used="+isAlreadyUsed+")");
			if(optionName.equals(CreateeEntranceEntitlementTest.EntranceEntitlement.trim()) && isAlreadyUsed==false)
			{
				assertEquals(AccessControlPageElements.GetApprovedOrDeniedMessage(driver).getText().trim(), "Approved");
				ExpResult = "Welcome to the facility! Hope you enjoy your time";
				ActResult=AccessControlPageElements.GetBarcodeExpMessage(driver).getText().trim();
				assertEquals(ActResult,ExpResult);
				ExpResult="Sorry, but it appears that you have already used your Ticket.";
				isAlreadyUsed=true;
			}
			else
			{
				assertEquals(AccessControlPageElements.GetApprovedOrDeniedMessage(driver).getText().trim(), "Denied");
				ActResult=AccessControlPageElements.GetBarcodeExpMessage(driver).getText().trim();
				assertEquals(ActResult,ExpResult);
			}
		}
		
	}
		
}
