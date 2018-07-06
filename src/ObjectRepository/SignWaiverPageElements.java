package ObjectRepository;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import GlobalFiles.CommonFunctions;

public class SignWaiverPageElements {
private static WebElement element = null;
public static String GuestFnameLname []=null;
public static String SignWaiverEmailID="";
	
	public static WebElement GetEmailIDField(WebDriver driver)
	{
		element =driver.findElement(By.id("EmailAddress"));
		return element;
	}
	public static WebElement GetPhoneNumberField(WebDriver driver)
	{
		element =driver.findElement(By.id("PhoneNumber"));
		return element;
	}
	public static WebElement GetStreetAddressField(WebDriver driver)
	{
		element =driver.findElement(By.id("StreetAddress"));
		return element;
	}
	public static WebElement GetCityField(WebDriver driver)
	{
		element =driver.findElement(By.id("City"));
		return element;
	}
	public static WebElement GetStateField(WebDriver driver)
	{
		element =driver.findElement(By.id("State"));
		return element;
	}
	public static WebElement GetZipCodeField(WebDriver driver)
	{
		element =driver.findElement(By.id("ZipCode"));
		return element;
	}
	public static WebElement GetAddGuestButton(WebDriver driver)
	{
		element =driver.findElement(By.id("addGuest"));
		return element;
	}
	public static WebElement GetAddCancelButton(WebDriver driver)
	{
		element =driver.findElement(By.id("cancelWaiver"));
		return element;
	}
	public static WebElement GetIMFinishedButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("imFinished"));
		return element;
	}
	// Parent fields
	
	public static WebElement GetFirstNameField(WebDriver driver, int GuestNumber)
	{
		
		element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/form/div/div[3]/div["+GuestNumber+"]/div[2]/div/div[1]/div[1]/div/label/following::input"));
		return element;
	}
	public static WebElement GetLastNameField(WebDriver driver, int GuestNumber)
	{
		
		element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/form/div/div[3]/div["+GuestNumber+"]/div[2]/div/div[1]/div[2]/div/label/following::input"));
		return element;
	}
	public static WebElement GetYearDropdown(WebDriver driver, int GuestNumber)
	{
		element =driver.findElement(By.id("guestyear"+GuestNumber));
		return element;
	}
	public static WebElement GetMonthDropdown(WebDriver driver,int GuestNumber)
	{
		element =driver.findElement(By.id("guestmonth"+GuestNumber));
		return element;
	}
	public static WebElement GetDayDropdown(WebDriver driver, int GuestNumber)
	{
		element =driver.findElement(By.id("guestday"+GuestNumber));
		return element;
	}
	public static WebElement GetSignatureField(WebDriver driver, int GuestNumber)
	{
		element =driver.findElement(By.id("signature-canvas-"+GuestNumber));
		return element;
	}
	public static void AddWaiverSign(WebDriver driver, int WaiverCount, int AdultParentOrChildCount, int ChildOrAdultCount) throws InterruptedException
	{
		 int ParentOrAdultCount = AdultParentOrChildCount;
		  int l_ChildOrAdultCount = ChildOrAdultCount;
		  int WaiverBirthYear = 0,  WaiverBirtMonth=0,  WaiverBirthDate=0;		  
		  Date d = new Date();
		  WaiverBirtMonth = d.getMonth();
		  WaiverBirthDate = d.getDate();
		if(WaiverCount==(AdultParentOrChildCount+ChildOrAdultCount) && AdultParentOrChildCount>=0)
		{
			  String actualResult="";
			 
			  GuestFnameLname = new String[WaiverCount];
			  WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).click();
			  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
			  Thread.sleep(3000);
			  
			  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "View Waiver Form").click();
			  Thread.sleep(5000);
			  
			  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			  driver.switchTo().window(windowHandles.get(1));
			  SignWaiverEmailID = "Email"+ System.currentTimeMillis() +"@gmail.com";
			  SignWaiverPageElements.GetEmailIDField(driver).sendKeys(SignWaiverEmailID);
			  SignWaiverPageElements.GetPhoneNumberField(driver).sendKeys("1234567890");
			  SignWaiverPageElements.GetStreetAddressField(driver).sendKeys("Street1");
			  SignWaiverPageElements.GetCityField(driver).sendKeys("New York");
			  SignWaiverPageElements.GetStateField(driver).sendKeys("New York");
			  SignWaiverPageElements.GetZipCodeField(driver).sendKeys("12345");
			  
			  Actions builder = null;
			  Action drawAction = null;
			  
			  for (int i=1;i<=WaiverCount;i++)
			  {
				  if(ParentOrAdultCount>0)
				  {
					  WaiverBirthYear = d.getYear()+1900-30;
					  
					  ParentOrAdultCount--;
					  
				  }
				  else if(ParentOrAdultCount==0 && l_ChildOrAdultCount>0)
				  {
					  WaiverBirthYear = d.getYear()+1900-15;
					  l_ChildOrAdultCount--;
				  }
				  String fname = "fname" + System.currentTimeMillis();
				  String lname = "lname" + System.currentTimeMillis();
				  GuestFnameLname[i-1]= fname + " " +lname;
				  SignWaiverPageElements.GetFirstNameField(driver,i).sendKeys(fname);
				  SignWaiverPageElements.GetLastNameField(driver,i).sendKeys(lname);	
				  
				  
				  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiverPageElements.GetYearDropdown(driver,i) , String.valueOf(WaiverBirthYear));
				  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiverPageElements.GetMonthDropdown(driver,i) ,String.valueOf(WaiverBirtMonth));
				  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiverPageElements.GetDayDropdown(driver,i) , String.valueOf(WaiverBirthDate));
				  
				  builder = new Actions(driver);
				  drawAction = builder.moveToElement(SignWaiverPageElements.GetSignatureField(driver,i),100,15).clickAndHold().moveByOffset(120, 30).moveByOffset(80, 40).release().build();
				  drawAction.perform();
				  if(i<WaiverCount)
				  {
					  SignWaiverPageElements.GetAddGuestButton(driver).click();  
				  }
				    
			  }
			  		  
			  SignWaiverPageElements.GetIMFinishedButton(driver).click();
			  Thread.sleep(5000);
			  
			  actualResult = WaiverFinalPageElements.GetSigningSuccessMsg(driver).getText();
			  CommonFunctions.printString("Actual Result " + actualResult);
			  assertEquals(actualResult.trim(), "Success!   Thank you for signing! Your waiver(s) have been submitted.");
			  
			  
			  actualResult = WaiverFinalPageElements.GetMsgSendSuccessMsg(driver).getText();
			  CommonFunctions.printString("Actual Result " + actualResult);
			  assertEquals(actualResult.trim(), "Successfully Sent!   A copy of your signed waiver(s) have been sent to your inbox.");
			  
			  driver.close();
			  driver.switchTo().window(windowHandles.get(0));
			  //WaiverManagementPageElements.GetIDColumn(driver).click();
		}
		else
		{
			assertEquals(false, true);
		}
		  
	}
	
}
