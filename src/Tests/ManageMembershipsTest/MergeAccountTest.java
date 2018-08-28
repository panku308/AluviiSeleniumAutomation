package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddGuestDialogBoxElements;
import ObjectRepository.CreateNewAccountDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditNewAccountDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.MergeAccountsDialogBoxElements;
import ObjectRepository.SplitAccountDialogBoxElements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class MergeAccountTest {

	public static WebDriver driver=null;

	//public static String fname="fname1535264961598";


	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;

	}
	@Test
	public void MergeMemberAccounts() throws Exception
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);

		int columnIndex;

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "First Name");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();
		System.out.println(CreateMemberTest.fname);
		CommonFunctions.filterTable(driver, CreateMemberTest.fname);

		ManageMembershipsPageElements.getFilteredColumns(driver, 2, 0).click();
		Thread.sleep(2000); 

		ManageMembershipsPageElements.getFilteredColumns(driver, 2, 1).click();
		Thread.sleep(2000);

		ManageMembershipsPageElements.GetAccountOptionDropdown(driver).click();
		Thread.sleep(2000); 
		ManageMembershipsPageElements.GetMergeAccountsLink(driver).click();
		Thread.sleep(5000);		

		CommonFunctions.SwitchToContentFrame(driver);
		Thread.sleep(4000);

		MergeAccountsDialogBoxElements.getAccount2Data(driver, "Email Address").click();
		Thread.sleep(2000);

		MergeAccountsDialogBoxElements.getAccount2Data(driver, "Phone Number").click();
		Thread.sleep(2000);

		MergeAccountsDialogBoxElements.GetMergeAccountsButton(driver).click();

		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		//SplitAccount Email Is Not Present Validation

		/*Thread.sleep(2000);
		ManageMembershipsPageElements.getClearFilterButton(driver).click();
		Thread.sleep(5000);

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();
		Thread.sleep(2000);
		System.out.println(SplitAccountTest.EmailID);
		CommonFunctions.filterTable(driver, SplitAccountTest.EmailID);

		Thread.sleep(2000);

		Assert.assertNull(ManageMembershipsPageElements.getFilteredColumn(driver, columnIndex).getText());*/

		//Create Account Email Is Present Validation

		Thread.sleep(2000);
		ManageMembershipsPageElements.getClearFilterButton(driver).click();
		Thread.sleep(5000);

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		Thread.sleep(2000);

		Assert.assertEquals(ManageMembershipsPageElements.getFilteredColumn(driver, columnIndex).getText(), 
				CreateMemberTest.EmailID);

		Thread.sleep(2000);

		//Both Accounts details validation under a same account

		ManageMembershipsPageElements.getFilteredColumn(driver, 1).click();
		Thread.sleep(3000);

		Assert.assertTrue(ManageMembershipsPageElements.isMergedAccountPresent(driver, CreateMemberTest.fname+" "+CreateMemberTest.lname));
		Thread.sleep(2000);
		//Assert.assertTrue(ManageMembershipsPageElements.isMergedAccountPresent(driver, CreateMemberTest.lname));


	}

}
