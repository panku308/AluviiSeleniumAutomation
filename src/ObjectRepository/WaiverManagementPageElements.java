package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaiverManagementPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetWaiverTab(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/ul/li[1]/a"));
		element =driver.findElement(By.linkText("Waivers"));
		return element;
	}
	public static WebElement GetSignedWaiverTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Signed Waiver"));
		return element;
	}
	public static WebElement GetSelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetWaiverNameColumnSettingsIcon(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/table/thead/tr/th[1]/a[2]"));
		element =driver.findElement(By.xpath("//th[@data-field='WaiverName']/a"));
		return element;
	}
	public static WebElement GetIDColumn(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/table/thead/tr/th[1]/a[2]"));
		element =driver.findElement(By.linkText("ID"));
		return element;
	}
	public static WebElement GetWaiverNameOfFirstRow(WebDriver driver)
	{
		
		//element =driver.findElement(By.xpath("//div[@id='waivergrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));
		element =driver.findElement(By.xpath("//div[@id='waivergrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[3]"));
		return element;
	}
	public static WebElement SelectOptionFromSelectOptionDD(WebDriver driver, String OptName)
	{
		element =driver.findElement(By.xpath("//li[text() = '"+OptName+"']"));
		return element;
	}
	public static void OpenWaiverManagementPage(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();",DashboardPageElements.GetWaiverManagementLink(driver));
		  //DashboardPageElements.clickOnWaiverManagementlink(driver);
		  DashboardPageElements.GetWaiverManagementLink(driver).click();
		  Thread.sleep(5000);
	}

}
