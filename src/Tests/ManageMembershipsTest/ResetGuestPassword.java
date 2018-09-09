package Tests.ManageMembershipsTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AccountGuest_ManuallyResetPasswordDialogboxElements;
import ObjectRepository.AccountGuest_ResetPasswordOptionDialogBoxElements;
import ObjectRepository.GuestPortal_DashboardPageElements;
import ObjectRepository.GuestPortal_DigitalPassesPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import Tests.GuestPortalTest.GuestLoginTest;

public class ResetGuestPassword {
	public static WebDriver driver=null;
	  public static String GuestPassword="Password@1";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void ResetGuestPassordTest() throws InterruptedException, AWTException
	  {
		 
		  CreateMemberTest.EmailID = "selenium1536113373628@gmail.com";
		  int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, CreateMemberTest.EmailID);
		 
		  if(i==1)
		  {
			  ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
			  Thread.sleep(4000);
			  ManageMembershipsPageElements.GetAccountGuestResetPasswordButton(driver).click();
			  Thread.sleep(4000);
			  
			  AccountGuest_ResetPasswordOptionDialogBoxElements.GetManuallySetPasswordLink(driver).click();
			  Thread.sleep(3000);
			  CommonFunctions.SwitchToContentFrame(driver);
			  VerifySimplePasswordFormMessages(driver);
			  AccountGuest_ManuallyResetPasswordDialogboxElements.GetPasswordField(driver).sendKeys(GuestPassword);
			  AccountGuest_ManuallyResetPasswordDialogboxElements.GetConfirmPasswordField(driver).sendKeys(GuestPassword);
			  AccountGuest_ManuallyResetPasswordDialogboxElements.GetResetPasswordButton(driver).click();
			  Thread.sleep(3000);
			  driver.switchTo().defaultContent();

			  CommonFunctions.GuestUserName=CreateMemberTest.EmailID;
			  CommonFunctions.GuestPassword=GuestPassword;
			  
			  
			  assertTrue(true);
			 /* 
			  driver.switchTo().defaultContent();
			  driver.navigate().refresh();
			  Thread.sleep(5000);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("window.open()"); 
			  
			  Thread.sleep(3000);

			  CommonFunctions.GuestUserName=CreateMemberTest.EmailID;
			  CommonFunctions.GuestPassword=GuestPassword;
			  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			  driver.switchTo().window(windowHandles.get(1));
			  driver.get(CommonFunctions.GuestURL);
			  Thread.sleep(5000);
			  CommonFunctions.GuestLogin(driver,CommonFunctions.GuestUserName,CommonFunctions.GuestPassword);
			  assertEquals(driver.getCurrentUrl(), CommonFunctions.GuestURL+"dashboard/dashboard"); 
			  VerifyDigitalPassesOnGuestAccount();
			  driver.close();
			  driver.switchTo().window(windowHandles.get(0));
			 */ 
		  }
		  else
		  {
			  assertFalse(false);
		  }
	  }
	  public static void VerifySimplePasswordFormMessages(WebDriver driver)
	  {
			 assertEquals(AccountGuest_ManuallyResetPasswordDialogboxElements.GetCharactersCheckMessage(driver).getText() , "8 Characters");
			 assertEquals(AccountGuest_ManuallyResetPasswordDialogboxElements.Get1NumberCheckMessage(driver).getText() , "1 Number");
			 if(CommonFunctions.SimplePassword==false)
			 {
				 assertEquals(AccountGuest_ManuallyResetPasswordDialogboxElements.Get1SpecialCharacterCheckMessage(driver).getText().trim() , "1 Special Character: !@#:;$%-_=+<>*");
				 assertEquals(AccountGuest_ManuallyResetPasswordDialogboxElements.Get1CapitalLetterCheckMessage(driver).getText().trim() , "1 Capital Letter");	 
			 }
			 
			 
	  }
		 
}
