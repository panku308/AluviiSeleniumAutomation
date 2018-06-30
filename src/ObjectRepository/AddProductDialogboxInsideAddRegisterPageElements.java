package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductDialogboxInsideAddRegisterPageElements {
private static WebElement element = null;
	
	public static WebElement GetProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select Product']"));
		return element;
	}
	public static WebElement GetAddProductButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}
	public static void SelectValueFromProductDD(WebDriver driver, String productName)
	{
		driver.findElement(By.xpath("//li[text()='"+productName+" (Product)']")).click();
	}
}
