package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReceiptSelectionDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetNoneButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("None"));
		return element;
	}
	public static WebElement GetNameButton(WebDriver driver)
	{
		
		element =driver.findElement(By.name("Email"));
		return element;
	}
	public static WebElement GetPrintButton(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Print"));
		return element;
	}

}
