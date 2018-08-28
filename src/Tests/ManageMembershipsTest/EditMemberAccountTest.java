package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditNewAccountDialogBoxElements;
import ObjectRepository.ManageMembershipsPageElements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class EditMemberAccountTest {

	public static WebDriver driver=null;
	
	//public static String EmailID="selenium1535202738241@gmail.com";


	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;

	}
	@Test
	public void EditMemeberTest() throws Exception
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);

		int columnIndex;

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		String changedAccountName="change_TestMember" + System.currentTimeMillis();
		String changePhoneNumber="8876587546";
		//String changeStreetAddress="change_Street"+System.currentTimeMillis();

		ManageMembershipsPageElements.getFilteredColumn(driver, 2).click();
		Thread.sleep(2000); 
		ManageMembershipsPageElements.GetAccountOptionDropdown(driver).click();
		Thread.sleep(2000); 
		ManageMembershipsPageElements.GetEditAccountLink(driver).click();
		Thread.sleep(5000);

		CommonFunctions.SwitchToContentFrame(driver);
		
		Thread.sleep(2000);

		EditNewAccountDialogBoxElements.GetAccountNameField(driver).clear();
		EditNewAccountDialogBoxElements.GetAccountNameField(driver).sendKeys(changedAccountName);

		EditNewAccountDialogBoxElements.GetPhoneNumberField(driver).clear();
		EditNewAccountDialogBoxElements.GetPhoneNumberField(driver).sendKeys(changePhoneNumber);

		EditNewAccountDialogBoxElements.GetSaveChangesButton(driver).click();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		ManageMembershipsPageElements.getClearFilterButton(driver).click();
		Thread.sleep(5000);

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		Thread.sleep(2000);
		
		/*------Changed Value Assertion----*/
		Assert.assertEquals(ManageMembershipsPageElements.getFilteredColumn(driver, 
				ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Account Name")).getText(), changedAccountName);
		
		Assert.assertTrue(ManageMembershipsPageElements.getFilteredColumn(driver, 
				ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Phone")).getText().replaceAll("-", "").equals(changePhoneNumber));
		
	}

}
