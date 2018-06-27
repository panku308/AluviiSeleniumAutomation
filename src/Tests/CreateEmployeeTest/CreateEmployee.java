package Tests.CreateEmployeeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddEmployeeDialogBox;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;

public class CreateEmployee {
	
	public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String CategoryName="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  
	  @Test
	  public static void createEmployee()throws Exception
	  {
		  try {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  CategoryName="category_" + System.currentTimeMillis();
		  DashboardPageElements.GetHRManagementLink(driver).click();
		  
		  HRManagementPageElements.getManageEmployeeTab(driver).click();
		  HRManagementPageElements.openSelectOptions(driver).click();
		  HRManagementPageElements.selectOptions(driver, "Add Employee").click();

		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  driver.switchTo().frame(0);
		  
		  String emailToBeRegistered="TestEmail"+CommonFunctions.generateRandomIndex()+"@aluvii.com";
		  System.out.println(emailToBeRegistered);
		  
		  AddEmployeeDialogBox.getEmployeeEmail(driver).sendKeys(emailToBeRegistered);
		  AddEmployeeDialogBox.getFirstName(driver).sendKeys("TestFirstName");
		  AddEmployeeDialogBox.getLastName(driver).sendKeys("TestLastName");
		  AddEmployeeDialogBox.getSave(driver).click();
		  
		  driver.switchTo().defaultContent();
		  Thread.sleep(2000);
		  
		  HRManagementPageElements.getEmailColumn(driver).click();
		  CommonFunctions.filterTable(emailToBeRegistered);
		  String isRegisteredEmail=HRManagementPageElements.getEmail(driver).getText();
		  
		  Assert.assertEquals(isRegisteredEmail, emailToBeRegistered);
		  
		  }catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
			  
	  }
}
