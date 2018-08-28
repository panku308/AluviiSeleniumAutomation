package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddGuestDialogBoxElements;
import ObjectRepository.CreateNewAccountDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EditNewAccountDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
import ObjectRepository.ManageMembershipsPageElements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AddGuestToMemberAccountTest {

	public static WebDriver driver=null;
	public static String fname="", lname="";
	
	//public static String EmailID="selenium1535202738241@gmail.com";


	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;

	}
	@Test
	public void AddGuest() throws Exception
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);

		int columnIndex;

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		String email="testguestmember" + System.currentTimeMillis() +"@gmail.com";
		fname=CreateMemberTest.fname;
		lname = CreateMemberTest.lname;

		ManageMembershipsPageElements.getFilteredColumn(driver, 1).click();
		Thread.sleep(2000); 
		
		ManageMembershipsPageElements.getAddGuestButton(driver).click();
		Thread.sleep(2000); 
		
		CommonFunctions.SwitchToContentFrame(driver);
		
		AddGuestDialogBoxElements.GetFirstnameField(driver).sendKeys(fname);
		
		AddGuestDialogBoxElements.GetLastname(driver).sendKeys(lname);
		
		AddGuestDialogBoxElements.GetPrimayEmailField(driver).sendKeys(email);
		
		AddGuestDialogBoxElements.GetPhoneNumberField(driver).sendKeys("8015566689");
		
		AddGuestDialogBoxElements.Get_Add_StreetField(driver).sendKeys("Add"+System.currentTimeMillis());
		
		AddGuestDialogBoxElements.Get_Add_ZipCodeField(driver).sendKeys("94097");
		
		AddGuestDialogBoxElements.Get_Add_CityField(driver).sendKeys("Orem");
		
		AddGuestDialogBoxElements.Get_Add_StateField(driver).sendKeys("UT");
		
		AddGuestDialogBoxElements.GetBirthDateField(driver).sendKeys("10/01/1990");
		
		AddGuestDialogBoxElements.Get_Add_Button(driver).click();
		Thread.sleep(3000); 
		
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		ManageMembershipsPageElements.getClearFilterButton(driver).click();
		Thread.sleep(5000);

		columnIndex = ManageMembershipsPageElements.getDesiredColumnIndex(driver, "Email");

		ManageMembershipsPageElements.getDesiredAccountColumn(driver, columnIndex).click();

		CommonFunctions.filterTable(driver, CreateMemberTest.EmailID);

		Thread.sleep(2000);
		
		ManageMembershipsPageElements.getFilteredColumn(driver, 1).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(ManageMembershipsPageElements.isPresent(driver, fname));
		Thread.sleep(2000);
		Assert.assertTrue(ManageMembershipsPageElements.isPresent(driver, lname));
		
	}

}
