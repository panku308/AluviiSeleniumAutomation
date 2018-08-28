package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPaymentPlan {
	
	private static WebElement element = null;
	
	public static WebElement getIncrementalPaymentPlan(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Incremental Payment Plan']/input"));
		return element;
	}
	
	public static WebElement getAutoRenewalPaymentPlan(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Auto-Renewal Payment Plan']/input"));
		return element;
	}
	
	public static WebElement getPaymentPlanNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("PayPlanName"));
		return element;
	}
	
	public static WebElement getBillingFrequencySelectOptions(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='dvIncremental']//*[text()='Select Option']"));
		return element;
	}
	
	public static WebElement selectBillingFrequencyOptions(WebDriver driver, String list)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='BillingFrequency_listbox']//li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getNumberOfPeriodsField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Number of Periods']/..//input[1]"));
		return element;
	}

	public static WebElement setNumberOfPeriodsField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Number of Periods']/..//input[2]"));
		return element;
	}
	
	public static WebElement getDayOfMonthToBillField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Day of Month to Bill']/..//input[1]"));
		return element;
	}

	public static WebElement setDayOfMonthToBillField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Day of Month to Bill']/..//input[2]"));
		return element;
	}
	
	public static WebElement getSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}

}
