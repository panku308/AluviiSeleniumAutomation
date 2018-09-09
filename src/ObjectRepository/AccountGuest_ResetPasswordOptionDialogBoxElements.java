package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountGuest_ResetPasswordOptionDialogBoxElements {

private static WebElement element = null;
	 
	
	public static WebElement GetSentResetLinkButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSendResetLink"));
		return element;
	}
	public static WebElement GetManuallySetPasswordLink(WebDriver driver)
	{
		element =driver.findElement(By.id("btnManuallyResetLink"));
		return element;
	}
}
