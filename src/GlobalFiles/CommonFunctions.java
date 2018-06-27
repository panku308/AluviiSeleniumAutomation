package GlobalFiles;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import ObjectRepository.DashboardPageElements;
import ObjectRepository.LoginPageElements;

public class CommonFunctions {
	//--------------------------------------------Global Variables-------------------------------------------------------
	public static String domainName="https://sessionqa";
	public static String url=domainName+".aluvii.com/employee/";
	public static String UserName="ceo@aluvii.com";
	public static String Password="Admin@123";
	public static String chromeDriverPath="C:\\chromedriver_win32\\chromedriver.exe";
	
	
	public static int CreateProduct_unitPrice=5;
	public static int AddWaiver_MinAge=15;
	//-------------------------------------------------------------------------------------------------------------------
	public static WebDriver driver = null;
	
	
	public static WebDriver SetupEnvironment(String url, String Browser)
	{
		if (Browser.toLowerCase().equals("chrome"))			
		{
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	public static void SelectOptionFromDropdownByValue(WebElement element, String OptName)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByValue(OptName);
	}
	public static void SelectOptionFromDropdownByIndex(WebElement element, int indexID)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByIndex(indexID);
	}
	
	public static void SelectOptionFromDropdownByVisibleText(WebElement element, String OptName)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByVisibleText(OptName);
	}
	
	public static void Login(WebDriver driver) throws InterruptedException
	{
	
		clearLoginFields();
		
		LoginPageElements.GetUsernameField(driver).sendKeys(UserName);
		LoginPageElements.GetPasswordField(driver).sendKeys(Password);
		LoginPageElements.GetLoginButton(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void clearLoginFields()
	{
		LoginPageElements.GetUsernameField(driver).clear();
		LoginPageElements.GetPasswordField(driver).clear();
	}
	public static void printString(String str)
	{
		System.out.println(str);
	}
	public static boolean CompareSingleDimensionStringArray(String act[], String exp[])
	{
		boolean compareResult=false;
		
		for(int i=0; i < act.length;i++)
		{
			System.out.println("Actual string["+i+"] = " +act[i]+ " , Expected String["+i+"] = " +exp[i] );
			if(act[i].toLowerCase().trim().equals(exp[i].toLowerCase().trim()))
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
				break;
			}
		}
		return compareResult;
	}
	public static void WaitForElementToVisible(WebDriver driver, WebElement element, int WaitingTimeInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, WaitingTimeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void ScrollUptoElement(WebDriver driver, WebElement element) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		Thread.sleep(10000);
	}
	public static void TakeScreenShot(String testName)throws Exception
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\AutomationScriptTest\\"+testName+"\\"+(testName+System.currentTimeMillis())+".png");

        FileUtils.copyFile(scrFile, desFile);
        
             
        String filePath = desFile.toString();
        
        String path = "<a href="+ filePath + "> Testcase_"+testName+"_Result Screenshot </a>";
        Reporter.log(path);
	}
	
}
