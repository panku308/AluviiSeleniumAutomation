package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddGuestDialogBoxInsideSellProductElements;
import ObjectRepository.AddGuestIntoMemberDialogboxElements;
import ObjectRepository.CreateNewAccountDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateMemberTest {

	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String EmailID="", fname="", lname="", Street="", State="", City="",ZipCode="", PhoneNumber="" ;
	  public static String Date="11",Month="11",Year="1984";
	
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateMemeberTest() throws Exception
	  {
		  EmailID="selenium" + System.currentTimeMillis() +"@gmail.com";
		  fname="fname"+System.currentTimeMillis();
		  lname = "lname" + System.currentTimeMillis();
		  Street="Street1";
		  State="UT";
		  City="PV";
		  ZipCode="12345";
		  PhoneNumber="1234567890";
		  String DateString = Date+"/"+Month+"/"+Year;
		  Thread.sleep(5000);
		  DashboardPageElements.GetManageMemberShipLink(driver).click();
		  Thread.sleep(5000);
		  ManageMembershipsPageElements.GetAccountOptionDropdown(driver).click();
		  Thread.sleep(2000); 
		  ManageMembershipsPageElements.GetCreateNewAccountLink(driver).click();
		  Thread.sleep(10000);
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  CommonFunctions.SwitchToContentFrame(driver);
		  CreateNewAccountDialogBoxElements.GetAccountNameField(driver).sendKeys("selenium" + System.currentTimeMillis());
		  CreateNewAccountDialogBoxElements.GetPrimayEmailField(driver).sendKeys(EmailID);
		  CreateNewAccountDialogBoxElements.GetPhoneNumberField(driver).sendKeys(PhoneNumber);	
		  PhoneNumber = "123-456-7890";
		  CreateNewAccountDialogBoxElements.Get_Add_StreetField(driver).sendKeys(Street);
		  CreateNewAccountDialogBoxElements.Get_Add_ZipCodeField(driver).sendKeys(ZipCode);
		  CreateNewAccountDialogBoxElements.Get_Add_CityField(driver).sendKeys(City);
		  CreateNewAccountDialogBoxElements.Get_Add_StateField(driver).sendKeys(State);
		  CreateNewAccountDialogBoxElements.Get_Add_NextButton(driver).click();
		  Thread.sleep(5000);
		  CreateNewAccountDialogBoxElements.GetFirstnameField(driver).sendKeys(fname);
		  CreateNewAccountDialogBoxElements.GetLastname(driver).sendKeys(lname);
		  CreateNewAccountDialogBoxElements.GetBirthDateField(driver).clear();
		  CreateNewAccountDialogBoxElements.GetBirthDateField(driver).sendKeys(DateString);
		  CreateNewAccountDialogBoxElements.GetSubmitButton(driver).click();
		  
		  Thread.sleep(30000);
		  CreateNewAccountDialogBoxElements.GetClosetButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  ManageMembershipsPageElements.GetSearchTextField(driver).clear();
		  ManageMembershipsPageElements.GetSearchTextField(driver).sendKeys(EmailID);
		  ManageMembershipsPageElements.GetSearchButtonField(driver).click();
		  Thread.sleep(5000);
		  actualResult = ManageMembershipsPageElements.GetAccountsTableFirstRowEmailColum(driver).getText();
		  assertEquals(actualResult, EmailID);
		  Thread.sleep(5000);		  
		  
	  }
	
	
	  
}
