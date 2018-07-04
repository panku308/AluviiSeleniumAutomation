package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductModifierInsideCashierRegisterElements {
	private static WebElement element = null;
	public static WebElement GetModifierButton(WebDriver driver, String ModifierValue)
	{
		element =driver.findElement(By.xpath("//button[text()='"+ModifierValue+"']"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAdd"));
		return element;
	}

}
