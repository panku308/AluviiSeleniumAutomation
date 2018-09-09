package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountGuest_ManuallyResetPasswordDialogboxElements {
private static WebElement element = null;
	 
	
	public static WebElement GetPasswordField(WebDriver driver)
	{
		element =driver.findElement(By.id("NewPassword"));
		return element;
	}
	public static WebElement GetConfirmPasswordField(WebDriver driver)
	{
		element =driver.findElement(By.id("ConfirmPassword"));
		return element;
	}
	public static WebElement GetResetPasswordButton(WebDriver driver)
	{
		element =driver.findElement(By.id("password-button"));
		return element;
	}
	public static WebElement GetCharactersCheckMessage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='8 Characters']"));
		return element;
	}
	public static WebElement Get1CapitalLetterCheckMessage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='1 Capital Letter']"));
		return element;
	}
	public static WebElement Get1NumberCheckMessage(WebDriver driver)
	{
		element =driver.findElement(By.id("numbers"));
		return element;
	}
	public static WebElement Get1SpecialCharacterCheckMessage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='1 Special Character: !@#:;$%-_=+<>*']"));
		return element;
	}
}
