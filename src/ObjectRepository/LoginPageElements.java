package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetUsernameField(WebDriver driver)
	{
		element =driver.findElement(By.id("UserName"));
		return element;
	}
	
	public static WebElement GetPasswordField(WebDriver driver)
	{
		element =driver.findElement(By.id("Password"));
		return element;
	}
	public static WebElement GetLoginButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSubmit"));
		return element;
	}
		
}
