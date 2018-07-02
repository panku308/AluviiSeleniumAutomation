package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GlobalFiles.CommonFunctions;

public class CardKnoxDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetCardNumberField(WebDriver driver)
	{
		element =driver.findElement(By.id("acardmount"));
		return element;
	}
	public static WebElement GetMonthDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//select[@data-cip = 'exp-month']"));
		return element;
	}
	public static WebElement GetYearDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//select[@data-cip = 'exp-year']"));
		return element;
	}
	public static WebElement GetCVVField(WebDriver driver)
	{
		element =driver.findElement(By.id("cvv-number"));
		return element;
	}
	public static WebElement GetNameOnCardField(WebDriver driver)
	{
		element =driver.findElement(By.id("billingname"));
		return element;
	}
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnsubmit"));
		return element;
	}
	
}
