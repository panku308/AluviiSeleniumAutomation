package Tests.ManageMembershipsTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.CreateNewAccountDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class CreateMemberTest {

	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String EmailID="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
		  
	  }
	  @Test
	  public void CreateMemeberTest() throws Exception
	  {
		  EmailID="selenium" + System.currentTimeMillis() +"@gmail.com";
		  Thread.sleep(5000);
		  DashboardPageElements.GetManageMemberShipLink(driver).click();
		  Thread.sleep(5000);
		  ManageMembershipsPageElements.GetAccountOptionDropdown(driver).click();
		  Thread.sleep(2000); 
		  ManageMembershipsPageElements.GetCreateNewAccountLink(driver).click();
		  Thread.sleep(10000);
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  driver.switchTo().frame(0);
		  CreateNewAccountDialogBoxElements.GetAccountNameField(driver).sendKeys("selenium" + System.currentTimeMillis());
		  CreateNewAccountDialogBoxElements.GetPrimayEmailField(driver).sendKeys(EmailID);
		  CreateNewAccountDialogBoxElements.GetPhoneNumberField(driver).sendKeys("8015566689");	
		  CreateNewAccountDialogBoxElements.Get_Add_StreetField(driver).sendKeys("Add"+System.currentTimeMillis());
		  CreateNewAccountDialogBoxElements.Get_Add_ZipCodeField(driver).sendKeys("94097");
		  CreateNewAccountDialogBoxElements.Get_Add_CityField(driver).sendKeys("Orem");
		  CreateNewAccountDialogBoxElements.Get_Add_StateField(driver).sendKeys("UT");
		  CreateNewAccountDialogBoxElements.Get_Add_NextButton(driver).click();
		  Thread.sleep(5000);
		  CreateNewAccountDialogBoxElements.GetFirstnameField(driver).sendKeys("fname"+System.currentTimeMillis());
		  CreateNewAccountDialogBoxElements.GetLastname(driver).sendKeys("lname"+System.currentTimeMillis());
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
		  		  
		  
	  }
	  
}
