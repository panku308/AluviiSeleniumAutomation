package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdministrationDashboardPageElements {
private static WebElement element = null;
	
	public static WebElement GetConfigurationTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Configuration"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayProcessorDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='topmargin-10']//span[@aria-owns='GatewayProcessorId_listbox']/span/span[1]"));
                                                    		
		
		return element;
	}
	public static WebElement GetConfigTab_GatewayActionURLField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtActionUrl"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayOnlineKeyField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtOnlineKey"));
		return element;
	}
	public static WebElement GetConfigTab_SaveChangesButton(WebDriver driver)
	{
		element =driver.findElement(By.id("updateApplicationConifguration"));
		return element;
	}
	public static WebElement GetConfigTab_GatewayOnlinePin(WebDriver driver)
	{
		element =driver.findElement(By.id("txtOnlinePin"));
		return element;
	}
	public static WebElement GetConfigTab_USAePaySandboxRadiobutton(WebDriver driver)
	{
		element =driver.findElement(By.id("GatewayMode1"));
		return element;
	}
}
