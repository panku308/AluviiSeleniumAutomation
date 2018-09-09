package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortal_LoginPageElements {
private static WebElement element = null;

	public static WebElement GetUserNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtUsername"));
		return element;
	}
	
	public static WebElement GetPasswordField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtPassword"));
		return element;
	}
	public static WebElement GetLoginButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSubmit"));
		return element;
	}
	public static WebElement GetClickHere(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCreate"));
		return element;
	}
	
}
