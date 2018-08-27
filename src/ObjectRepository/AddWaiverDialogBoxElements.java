package ObjectRepository;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GlobalFiles.CommonFunctions;

public class AddWaiverDialogBoxElements {
private static WebElement element = null;
	
	 
	public static WebElement GetWaiverNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("WaiverName"));
		return element;
	}
	public static WebElement GetMemberShipDropDown(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[1]/div[5]/div[1]/div[2]/div[2]/span/span/span[1]"));
		element =driver.findElement(By.xpath("//div[@id='divWaiver']//span[.= 'Select Package']"));
		return element;
	}
	public static WebElement GetWaiverLanguageTextArea(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body"));
		return element;
	}	
	public static WebElement GetReqAllGuestRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverSignConfig'][@value='0'] "));
		return element;
	}
	public static WebElement GetReqAllGuestOverMinAgeRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverSignConfig'][@value='1'] "));
		return element;
	}
	public static WebElement GetReqOneGuestRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverSignConfig'][@value='2'] "));
		return element;
	}
	public static WebElement GetMinAgeDropdownUpArrow(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[1]/div[13]/div[1]/div/div[2]/span/span/span/span[1]/span"));
		element =driver.findElement(By.xpath("//span[@class='k-widget k-numerictextbox']//span[@class='k-icon k-i-arrow-60-up']"));
		return element;
	}
	public static WebElement GetMinAgeField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'divWaiver']//input[@class='k-formatted-value k-input']"));
		return element;
	}
	public static WebElement GetSubmitWaiverButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSubmit"));
		return element;
	}
	public static WebElement GetCancelButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCancel"));
		return element;
	}
	public static WebElement SelectDynamicFromMembershipPackageDD(WebDriver driver, String OptName)
	{
		element =driver.findElement(By.xpath("//li[text() = '"+OptName+"']"));
		return element;
	}
	public static WebElement SelectFirstOptionFromMembershipPackageDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//ul[@id='MembershipPackageId_listbox']/li[1]"));
		return element;
	}
	
	public static void SetMinAge(WebDriver driver)
	{
		 for (int i=0;i<CommonFunctions.AddWaiver_MinAge;i++)
		  {
			  AddWaiverDialogBoxElements.GetMinAgeDropdownUpArrow(driver).click();
		  }
	}
	
	/**
	 * 
	 * @param driver
	 * @param WaiverName
	 * @param ConfigRadioButtonOption : 1= Require all guests to sign the waiver., 2= Require all guests over the minimum age to sign the waiver, 3=Only require one guest signature. (Must be over the minimum age requirement)

	 * 
	 * @throws InterruptedException
	 */
	public static void AddWaiver(WebDriver driver, String WaiverName, int ConfigRadioButtonOption) throws InterruptedException
	{
		 WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Waiver").click();
		  Thread.sleep(5000);
		  
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  
		  System.out.println("iframe length = " + iframeElements.size());
		  
		  driver.switchTo().frame(0);		
		  AddWaiverDialogBoxElements.GetWaiverNameField(driver).sendKeys(WaiverName);
		  AddWaiverDialogBoxElements.GetMemberShipDropDown(driver).click();
		  Thread.sleep(3000);		  
		  AddWaiverDialogBoxElements.SelectFirstOptionFromMembershipPackageDD(driver).click();
		  // switching to child frame.
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  driver.findElement(By.cssSelector("body")).sendKeys("test message");
		  //Switching back to main frame.
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);	
		  if(ConfigRadioButtonOption ==1)
		  {
			  AddWaiverDialogBoxElements.GetReqAllGuestRadioButton(driver).click();  
		  }
		  else if(ConfigRadioButtonOption==2)
		  {
			  AddWaiverDialogBoxElements.GetReqAllGuestOverMinAgeRadioButton(driver).click();
		  }
		  else if (ConfigRadioButtonOption==3)
		  {
			  AddWaiverDialogBoxElements.GetReqOneGuestRadioButton(driver).click();
		  }
		  
		  Thread.sleep(2000);
		  AddWaiverDialogBoxElements.SetMinAge(driver);
		 
		  
		  AddWaiverDialogBoxElements.GetSubmitWaiverButton(driver).click();
		  Thread.sleep(10000);
		 driver.switchTo().defaultContent();
		  System.out.println(driver.getWindowHandle());
		  
		 driver.navigate().refresh();
		 Thread.sleep(10000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(3000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(5000);
		  String actualResult = WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).getText();
		  assertEquals(actualResult, WaiverName);
	}
	public static void AddWaiver_NewFlow(WebDriver driver, String WaiverName) throws InterruptedException
	{
		 WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Waiver").click();
		  Thread.sleep(5000);		  
		  driver.switchTo().frame(0);		
		  AddWaiverDialogBoxElements.GetWaiverNameField(driver).sendKeys(WaiverName);
		  AddWaiverDialogBoxElements.GetMemberShipDropDown(driver).click();
		  Thread.sleep(3000);		  
		  AddWaiverDialogBoxElements.SelectFirstOptionFromMembershipPackageDD(driver).click();
		  // switching to child frame.
		  
		  driver.switchTo().frame(0);
		  driver.findElement(By.cssSelector("body")).sendKeys("test message");
		  //Switching back to main frame.
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);	
		  
		  AddWaiverDialogBoxElements.GetSubmitWaiverButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  System.out.println(driver.getWindowHandle());
		  
		  driver.navigate().refresh();
		  Thread.sleep(10000);
		  WaiverManagementPageElements.GetWaiverNameColumnSettingsIcon(driver).click();
		  Thread.sleep(3000);
		  CommonFunctions.filterTable(driver, WaiverName);
		  Thread.sleep(5000);
		  String actualResult = WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).getText();
		  assertEquals(actualResult, WaiverName);
		  /*WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).click();
		  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);		  
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "View Waiver Form").click();
		  Thread.sleep(5000);
		  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  if(driver.getCurrentUrl().contains("Waiver/SignWaiver?"))
		  {
			  assertEquals( SignWaiver2PageElements.GetIAcknowledgeCheckBox(driver).isDisplayed(), true);
			  assertEquals( SignWaiver2PageElements.GetEmailOptOutCheckBox(driver).isDisplayed(), true);  
		  }
		  else if(driver.getCurrentUrl().contains("Waiver/SignWaiver?2"))
		  {
			  
		  }
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
*/	
		  }
}
