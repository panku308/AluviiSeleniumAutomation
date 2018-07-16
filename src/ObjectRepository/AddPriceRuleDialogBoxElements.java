package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPriceRuleDialogBoxElements {
	private static WebElement element = null;


	public static WebElement getPriceRuleNameField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Price Rule Name']/..//input"));
		return element;
	}

	public static WebElement getDisplayNameField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Display Name']/..//input"));
		return element;
	}

	public static WebElement getRuleTypeButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Base Price']/.."));
		return element;
	}

	public static WebElement selectRuleType(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='"+name+"']"));
		return element.get(element.size()-1);

	}

	

	public static WebElement getPercentage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Percentage')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setPercentage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Percentage')]/following-sibling::span//input[2]"));
		return element;
	}

	public static WebElement getDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Description']/..//input"));
		return element;
	}

	public static WebElement getEmployeePortalCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Employee Portal']/..//input"));
		return element;
	}

	public static WebElement getEventPortalCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Event Portal']/..//input"));
		return element;
	}

	public static WebElement getSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@value='Save']"));
		return element;
	}


}
