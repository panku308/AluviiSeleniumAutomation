package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MergeAccountsDialogBoxElements {
	
	private static WebElement element = null;
	
	public static WebElement getAccount2Data(WebDriver driver, String attribute)
	{			
	
		element =driver.findElement(By.xpath("//*[text()='"+attribute+"']/../../td[last()]/input"));
		return element;
	}	
	
	public static WebElement GetMergeAccountsButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnMergeGuestAccount"));
		return element;
	}

}
