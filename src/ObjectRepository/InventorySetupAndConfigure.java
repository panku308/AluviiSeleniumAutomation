package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventorySetupAndConfigure {
	
	public static WebElement element = null;
	
	public static WebElement getReorderPointsButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[contains(text(),'Re-order Points')]"));
		return element;
	}
	
	public static WebElement searchProductInputField(WebDriver driver)
	{
	
		element =driver.findElement(By.id("//*[@id='reorder-point-product-search']"));
		return element;
	}
	
	public static WebElement selectOptions(WebDriver driver, String option)
	{	
		
		element = driver.findElement(By.xpath("//li[text()='"+option+"']"));
		return element;
	}
	
	public static WebElement getEmailColumn(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='HREmployeesActivityGrid']//a[text()='Email']/preceding-sibling::a"));
		return element;
	}
	
	public static WebElement getEmail(WebDriver driver)
	{
	
		List<WebElement> element;
		element = driver.findElements(By.xpath("//*[@id='HREmployeesActivityGrid']//tbody//td[3]"));
		return element.get(element.size()-1);
	}

}
