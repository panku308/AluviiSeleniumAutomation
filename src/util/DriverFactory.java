package util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	
	private static String chromeExeFilePath;
	private static String ieExeFilePath;
	
	
	
	public static String getChromeExeFilePath() {
		return chromeExeFilePath;
	}



	public static void setChromeExeFilePath(String chromeExeFilePath) {
		DriverFactory.chromeExeFilePath = chromeExeFilePath;
	}



	public static String getIeExeFilePath() {
		return ieExeFilePath;
	}



	public static void setIeExeFilePath(String ieExeFilePath) {
		DriverFactory.ieExeFilePath = ieExeFilePath;
	}



	public static WebDriver createDriverInstance(String browser)
	{
		WebDriver driver= null;
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplecitWait(DriverManager.getDriver(), 20);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeExeFilePath());
			driver= new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplecitWait(DriverManager.getDriver(), 20);
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DriverFactory.getIeExeFilePath());
			driver= new InternetExplorerDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplecitWait(DriverManager.getDriver(), 20);
		}
		else if (browser.equalsIgnoreCase("grid")) {
			
			System.out.println("executing grid");
			String nodeURL = "http://3.16.40.204:4444/wd/hub";//"http://13.59.64.9:4444/wd/hub";
			ChromeOptions options = new ChromeOptions();

			try {
				driver = new RemoteWebDriver(new URL(nodeURL), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			//DriverManager.getDriver().manage().window().setSize(new Dimension(1600,900));
			DriverManager.setImplecitWait(DriverManager.getDriver(), 30);

		}
		return DriverManager.getDriver();
	}
	
	
	public static void destroyDriverInstance(WebDriver driver)
	{
		if(driver!=null)
		{
			
			driver.quit();
			driver=null;
		}
	}

}
