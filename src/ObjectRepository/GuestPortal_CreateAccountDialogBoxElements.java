package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortal_CreateAccountDialogBoxElements {
	private static WebElement element = null;

	public static WebElement GetCreateAccountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCreate"));
		return element;
	}
	public static WebElement GetLoginPageText(WebDriver driver, String text)
	{
		element =driver.findElement(By.xpath("//span[text()='"+text+"']"));
		return element;
	}
}
