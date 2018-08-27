package Tests.ManageMembershipsTest;
 
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddGuestIntoMemberDialogboxElements;
import ObjectRepository.ManageMembershipsPageElements;

public class AddMinorIntoGuestAccount {
	  public static String MinorGuestdata[] =null;
	  public static String MinorBirthdate[]=null, MinorBirthMonth[]=null, MinorBirthYear[]=null;
	  public static int NumberMinorGuest=1;
	  public static WebDriver driver=null;
	  public static String ActualGuestRows[]=null;
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		   driver = CommonFunctions.driver;
	  }
	  @ Test
	  public static void AddMinorGuest() throws InterruptedException
	  {
		  ManageMembershipsPageElements.ExpandMemberRow(driver, CreateMemberTest.EmailID);
		  
		  MinorGuestdata = new String[NumberMinorGuest+1];
		  MinorBirthdate=new String [NumberMinorGuest];
		  MinorBirthMonth=new String [NumberMinorGuest];
		  MinorBirthYear = new String[NumberMinorGuest];
		  MinorGuestdata[0]=CreateMemberTest.fname + " " + CreateMemberTest.lname;
		  for (int i=0;i<NumberMinorGuest;i++)
		  {
			  
			  ManageMembershipsPageElements.GetAddGuestButton(driver).click();
			  Thread.sleep(5000);
			  CommonFunctions.SwitchToContentFrame(driver);
			  Thread.sleep(5000);
			  AddGuestIntoMemberDialogboxElements.GetLoadDataButton(driver).click();
			  Thread.sleep(5000);
			  String FirstName="minorFname"+System.currentTimeMillis();
			  
			  String LastName= AddGuestIntoMemberDialogboxElements.GetLastNameField(driver).getAttribute("value");
			  AddGuestIntoMemberDialogboxElements.GetFirstNameField(driver).sendKeys(FirstName);
			  MinorGuestdata[i+1] = FirstName + " " + LastName;
			  AddGuestIntoMemberDialogboxElements.GetBirthDate(driver).clear();
			  MinorBirthdate[i]="23";
			  MinorBirthMonth[i]="10";
			  MinorBirthYear[i]="2014";
			  String dateStr=MinorBirthMonth[i]+"/"+MinorBirthdate[i]+"/"+MinorBirthYear[i];
			  AddGuestIntoMemberDialogboxElements.GetBirthDate(driver).sendKeys(dateStr);
			  AddGuestIntoMemberDialogboxElements.GetAddButton(driver).click();
			  Thread.sleep(5000);
			  driver.switchTo().defaultContent();
			  VerifyMinorGuestAdded();
		  }
	  }
	  
	  public static void VerifyMinorGuestAdded() throws InterruptedException
	  {
		
		  	 boolean actualResult=false;
		  	 int i = ManageMembershipsPageElements.GetSearchRecordRowCountOfAccountTable(driver, CreateMemberTest.EmailID);
		  	 if(i==1)
		  	 {
		  		 actualResult=true;
		  		 assertEquals(actualResult, true);
		  		 ManageMembershipsPageElements.GetExpandArrowElement(driver).click();
		  		 Thread.sleep(4000);
		  		 ActualGuestRows= ManageMembershipsPageElements.GetGuestRecordRowsFromAccountTable(driver);
		  		 
		  		 System.out.println("Actual Guest Row"  + ActualGuestRows.length);
		  		 if(ActualGuestRows.length==MinorGuestdata.length)
		  		 
		  		 {
		  			 assertEquals(CommonFunctions.CompareSingleDimensionStringArray(ActualGuestRows, MinorGuestdata), true);
		  		 }
		  		 else
		  		 {
		  			 assertEquals(ActualGuestRows,MinorGuestdata);
		  		 }
		  		  
		  	 }
		  	 else
		  	 {
		  		 assertEquals(false, true);
		  	 }
		  	 
		  	

	  }

}
