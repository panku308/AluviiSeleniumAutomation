package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.CreateNewAccountDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditNewAccountDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.ManageMembershipsPageElements;
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
public class SplitAccountTest {

	public static WebDriver driver=null;
	
	public static String EmailID=" ";


	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;

	}
	@Test
	public void SplitMemberAccounts() throws Exception
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);

		int columnIndex;

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		EmailID="testsplitguestmember" + System.currentTimeMillis() +"@gmail.com";

		ManageMembershipsPageElements.getFilteredColumn(driver, 1).click();
		Thread.sleep(2000); 
		
		ManageMembershipsPageElements.getSplitAccountButton(driver).click();
		Thread.sleep(2000); 		
		
		CommonFunctions.SwitchToContentFrame(driver);
		Thread.sleep(4000);
		
		Actions action=new Actions(driver);
		action.dragAndDrop(SplitAccountDialogBoxElements.getGuestAccount(driver), 
				SplitAccountDialogBoxElements.getNewAccountArea(driver)).build().perform();
		
		Thread.sleep(2000);
		
		SplitAccountDialogBoxElements.GetNextButton_ManageGuestsonNewAccountWindow(driver).click();
		Thread.sleep(2000);
		SplitAccountDialogBoxElements.GetNextButton_SelectAccountOwnerWindow(driver).click();
		Thread.sleep(2000);
		SplitAccountDialogBoxElements.GetPrimayEmailField(driver).sendKeys(EmailID);
		SplitAccountDialogBoxElements.GetSubmitButton_NewAccountInfoWindow(driver).click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		ManageMembershipsPageElements.getClearFilterButton(driver).click();
		Thread.sleep(5000);

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, EmailID);

		Thread.sleep(2000);
		
		Assert.assertEquals(ManageMembershipsPageElements.getFilteredColumn(driver, 
				ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Account Name")).getText(), 
				AddGuestToMemberAccountTest.fname+" "+AddGuestToMemberAccountTest.lname);
	}

}
