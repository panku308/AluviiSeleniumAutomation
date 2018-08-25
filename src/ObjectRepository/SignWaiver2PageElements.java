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

public class SignWaiver2PageElements {
	private static WebElement element = null;
	public static String GuestFnameLname []=null;
	public static String SignWaiverEmailID="";
	public static String PhoneNumber="",BirthDate="",GuestFirstName [] =null, GuestLastName []=null;
	public static String Street="", City="", ZipCode="", State="";

		
		public static WebElement GetEmailIDField(WebDriver driver)
		{
			element =driver.findElement(By.id("EmailAddress"));
			return element;
		}
		public static WebElement GetFirstNameField(WebDriver driver,String str)
		{
			element =driver.findElement(By.id("FirstName"+str));
			return element;
		}
		public static WebElement GetLastNameField(WebDriver driver, String str)
		{
			element =driver.findElement(By.id("LastName"+str));
			return element;
		}
		public static WebElement GetBirthYearField(WebDriver driver,String str)
		{
			element =driver.findElement(By.id("guestBirthYear"+str));
			return element;
		}
		public static WebElement GetBirthMonthField(WebDriver driver,String str)
		{
			element =driver.findElement(By.id("guestBirthMonth"+str));
			return element;
		}
		public static WebElement GetBirthDateField(WebDriver driver,String str)
		{
			element =driver.findElement(By.id("guestBirthDate"+str));
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
		public static WebElement GetPhoneNumberField(WebDriver driver)
		{
			element =driver.findElement(By.id("PhoneNumber"));
			return element;
		}
		public static WebElement GetAddMinorButton(WebDriver driver)
		{
			element =driver.findElement(By.id("btnAddMinor"));
			return element;
		}
		public static WebElement GetContinueButton(WebDriver driver)
		{
			element =driver.findElement(By.id("btnContinueStepTwo"));
			return element;
		}
		public static WebElement GetMinorFirstNameField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("FirstName"+Guestcount));
			return element;
		}
		public static WebElement GetMinorLastNameField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("LastName"+Guestcount));
			return element;
		}
		public static WebElement GetMinorBirthYearField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("guestBirthYear"+Guestcount));
			return element;
		}
		public static WebElement GetMinorBirthMonthField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("guestBirthMonth"+Guestcount));
			return element;
		}
		public static WebElement GetMinorBirthDateField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("guestBirthDay"+Guestcount));
			return element;
		}		
		
		public static WebElement GetIAcknowledgeCheckBox(WebDriver driver)
		{
			element =driver.findElement(By.id("IsSignerAcknowledge"));
			return element;
		}
		public static WebElement GetEmailOptOutCheckBox(WebDriver driver)
		{
			element =driver.findElement(By.id("IsEmailForMarketing"));
			return element;
		}
		public static WebElement GetMyselfButton(WebDriver driver)
		{
			element =driver.findElement(By.xpath("//span[text()='Complete a waiver for myself']"));
			return element;
		}
		public static WebElement GetMyselfAndChildrenButton(WebDriver driver)
		{
			element =driver.findElement(By.xpath("//span[text()='Complete a waiver for myself and children']"));
			return element;
		}
		public static WebElement GetSignatureField(WebDriver driver)
		{
			element =driver.findElement(By.id("signature-canvas-1"));
			return element;
		}
		public static WebElement GetIMFinishedButton(WebDriver driver)
		{
			element =driver.findElement(By.id("btnImFinished"));
			return element;
		}
		public static void AddWaiverSign_Template2(WebDriver driver, int WaiverCount, int AdultParentOrChildCount, int ChildOrAdultCount) throws Exception
		{

			 int ParentOrAdultCount = AdultParentOrChildCount;
			 int l_ChildOrAdultCount = ChildOrAdultCount;
			 int WaiverBirthYear = 0,  WaiverBirtMonth=0,  WaiverBirthDate=0;		  
			 Date d = new Date();
			 WaiverBirtMonth = d.getMonth()+1;
			 WaiverBirthDate = d.getDate();
			if(WaiverCount==(AdultParentOrChildCount+ChildOrAdultCount) && AdultParentOrChildCount>=0)
			{
					
					Thread.sleep(5000);
				  String actualResult="";
				  GuestFnameLname = new String[WaiverCount];
				  GuestLastName = new String[WaiverCount];
				  GuestFirstName = new String[WaiverCount];
				  WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).click();
				  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
				  Thread.sleep(3000);			  
				  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "View Waiver Form").click();
				  
				  
				    
				  
				  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
				  driver.switchTo().window(windowHandles.get(1));
				  if(ChildOrAdultCount!=0)
				  {
					  SignWaiver2PageElements.GetMyselfAndChildrenButton(driver).click();  
				  }
				  else
				  {
					  SignWaiver2PageElements.GetMyselfButton(driver).click();  
				  }
				  
				  Thread.sleep(5000);
				  
				  
				  SignWaiverEmailID = "Email"+ System.currentTimeMillis() +"@gmail.com";
				  PhoneNumber = "1234567890";
				  Street = "Street1";
				  City = "New York";
				  State = "New York";
				  ZipCode = "12345";
				  
				  SignWaiver2PageElements.GetEmailIDField(driver).sendKeys(SignWaiverEmailID);
				  SignWaiver2PageElements.GetPhoneNumberField(driver).sendKeys(PhoneNumber);
				  SignWaiver2PageElements.GetStreetAddressField(driver).sendKeys(Street);
				  SignWaiver2PageElements.GetCityField(driver).sendKeys(City);
				  SignWaiver2PageElements.GetStateField(driver).sendKeys(State);
				  SignWaiver2PageElements.GetZipCodeField(driver).sendKeys(ZipCode);
				  
				  
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
					  GuestFirstName[i-1] = "fname" + System.currentTimeMillis();
					  GuestLastName [i-1] = "lname" + System.currentTimeMillis();
					  GuestFnameLname[i-1]= GuestFirstName[i-1] + " " +GuestLastName[i-1];
					  String str="";
					  if(i==1)
					  {
						  str="";					  
					  }
					  else
					  {
						  str = String.valueOf(i-1);
					  }
						  
					  
					  SignWaiver2PageElements.GetFirstNameField(driver,str).sendKeys(GuestFirstName[i-1]);
					  SignWaiver2PageElements.GetLastNameField(driver,str).sendKeys(GuestLastName[i-1]);	
					  
					  BirthDate = String.valueOf(WaiverBirthDate)+"/"+String.valueOf(WaiverBirtMonth)+"/"+String.valueOf(WaiverBirthYear);
					  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiver2PageElements.GetBirthYearField(driver,str) , String.valueOf(WaiverBirthYear));
					  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiver2PageElements.GetBirthMonthField(driver,str) ,String.valueOf(WaiverBirtMonth));
					  if(i==1)
					  {
						  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiver2PageElements.GetBirthDateField(driver, str) , String.valueOf(WaiverBirthDate));
					  }
					  else
					  {
						  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiver2PageElements.GetMinorBirthDateField(driver, str) , String.valueOf(WaiverBirthDate));  
					  }
					  
					  
					  
					  //if(i<WaiverCount)
					  if(l_ChildOrAdultCount!=0 && i!=1)
					  {
						  SignWaiver2PageElements.GetAddMinorButton(driver).click();  
					  }
					    
				  }
				  SignWaiver2PageElements.GetContinueButton(driver).click();
				  Thread.sleep(10000);
				  assertEquals( SignWaiver2PageElements.GetIAcknowledgeCheckBox(driver).isDisplayed(), true);
				  assertEquals( SignWaiver2PageElements.GetEmailOptOutCheckBox(driver).isDisplayed(), true);
				  if(!SignWaiverPageElements.GetEmailOptOutCheckBox(driver).isSelected())
				  {
					  SignWaiverPageElements.GetEmailOptOutCheckBox(driver).click();
				  }
				  if(!SignWaiverPageElements.GetIAcknowledgeCheckBox(driver).isSelected())
				  {
					  SignWaiverPageElements.GetIAcknowledgeCheckBox(driver).click();
				  }
				  builder = new Actions(driver);
				  drawAction = builder.moveToElement(SignWaiver2PageElements.GetSignatureField(driver),100,15).clickAndHold().moveByOffset(120, 30).moveByOffset(80, 40).release().build();
				  drawAction.perform();
				  
				  SignWaiver2PageElements.GetIMFinishedButton(driver).click();
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
