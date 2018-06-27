package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRManagementPageElements {
private static WebElement element = null;
	
	
	public static WebElement getManageEmployeeTab(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip']/ul/li//a[text()='Manage Employees']"));
		return element;
	}
	
	public static WebElement openSelectOptions(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip-1']//*[text()='Select Option']"));
		return element;
	}
	
	public static WebElement selectOptions(WebDriver driver, String option)
	{
	
		List<WebElement> element;
		element = driver.findElements(By.xpath("//*[@id='ddEmployeeTask_listbox']/li"));
		
		for(int i=0;i<element.size();i++)
		{
			if(element.get(i).getText().equals(option))
				return element.get(i);
		}
		
		return null;
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
