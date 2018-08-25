package GlobalFiles;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import ObjectRepository.LoginPageElements;
import util.DriverManager;

public class CommonFunctions {
	//--------------------------------------------Global Variables-------------------------------------------------------
	public static String domainName="https://stagingqa";
	public static String url=domainName+".aluvii.com/employee/";
	public static String UserName="pankaj@aluvii.com";
	public static String Password="Admin@123";
	public static String chromeDriverPath="C:\\chromedriver_win32\\chromedriver.exe";


	public static int CreateProduct_unitPrice=5, CreateProductGroup_UnitPrice=5;
	public static int AddWaiver_MinAge=15;
	public static int ProductsCountForProductGroup=2;
	public static int ECommereceProductQuantity=20;
	//-------------------------------------------------------------------------------------------------------------------
	public static WebDriver driver = DriverManager.getDriver();

	public static Map<String, String> map = new HashMap<String, String>();


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
	public static void SelectOptionFromDropdownByValue(WebElement element, String OptName) throws Exception
	{
		element.click();
		Thread.sleep(2000);
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
	
	public static void Login(WebDriver driver, String username, String password) throws InterruptedException
	{
	
		clearLoginFields();
		
		LoginPageElements.GetUsernameField(driver).sendKeys(username);
		LoginPageElements.GetPasswordField(driver).sendKeys(password);
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
	public static void MoveControToFrame(WebDriver driver)
	{
		 List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
	}
	public static void SwitchToContentFrame(WebDriver driver)
	{
		driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
	}
	
	public static void filterTable(WebDriver driver,String input) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Filter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@title='Operator']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Is equal to']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@title='Operator']/../following-sibling::input")).sendKeys(input);		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Filter']")).click();
		Thread.sleep(2000);

	}
	public static void SelectOptionFromDropdownList(WebDriver driver, String optionName)
	{
		System.out.println("optiono = " + optionName);
		driver.findElement(By.xpath("//li[text()='"+optionName+"']")).click();
	}
	public static void ActionBuilder_EnterValueInTextbox(WebDriver driver, WebElement element, String str)
	{
		Actions actions = new Actions(driver);
		 actions.moveToElement(element);
		 actions.click();
		 actions.sendKeys(str);
		 actions.build().perform();
	}
	public static void ActionBuilder_PerformClickEventOnElement(WebDriver driver, WebElement element) throws InterruptedException
	{
		
		Actions actions = new Actions(driver);
		 actions.moveToElement(element);
		 actions.click();
		 
		 actions.build().perform();		 
		 
	
	}
	public static void ActionBuilder_PerformDoubleClickEventOnElement(WebDriver driver, WebElement element) throws InterruptedException
	{
		
		Actions actions = new Actions(driver);
		 actions.moveToElement(element);
		 actions.doubleClick();
		 
		 actions.build().perform();		 
		 
	
	}
	public static void ActionBuilder_PerformMouseHoverEventOnElement(WebDriver driver, WebElement element) throws InterruptedException
	{
		
		Actions actions = new Actions(driver);
		 actions.moveToElement(element);		 
		 actions.build().perform();		 
		 
	}
	public static void UploadFile(String FilePath) throws Exception
	{
		 //put path to your image in a clipboard

    	StringSelection ss = new StringSelection(FilePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    	
	}
	public static String GetCurrentDatte()
	{
		Date date = new Date();
		String d=String.valueOf(date.getDate());
		d = String.format("%02d", d);
		return d ;
	}
	public static String GetCurrentMonth()
	{
				
		Date date = new Date();
		String m=String.valueOf(date.getMonth()+1);
		m = String.format("%02d", m);
		return m ;
	}
	public static String GetCurrentYear()
	{
		Date date = new Date();
		String y=String.valueOf(date.getYear()+1900);
		return y ;
	}
	public static String getCurrentDateInMMddyyyyFormat()
	{
		String date= LocalDate.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy"));		
		return date;
	}
	public static String getPresentDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		Date date = new Date();  
		return formatter.format(date);  
	}
	
	public static void minimizeChatWindow(WebDriver driver)
	{
		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@data-test-id='ChatWidgetWindow-iframe']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'Chat with') and @class='jx_ui_Widget']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='overlay jx_ui_Widget']")).click();
		Thread.sleep(3000);
		
		}catch(Exception e)
		{
			
		}
		driver.switchTo().defaultContent();
	}
	public static int GetDayOfWeekIntFornat()
	{
		Date dt = new Date();
		return dt.getDay();		
	}
	public static String GetDayOfWeekStringFormat_FirstThreeLetters()
	{
		int DayofWeek = GetDayOfWeekIntFornat();
		String Day="";
		if(DayofWeek==0)
		{
			Day="sun";
		}
		else if(DayofWeek==0)
		{
			Day="mon";
		}
		else if(DayofWeek==0)
		{
			Day="tue";
		}else if(DayofWeek==0)
		{
			Day="wed";
		}else if(DayofWeek==0)
		{
			Day="thu";
		}else if(DayofWeek==0)
		{
			Day="fri";
		}else if(DayofWeek==0)
		{
			Day="sat";
		}
		return Day;
	}

}
