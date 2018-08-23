package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CashControlPageElements {
	private static WebElement element = null;


	public static WebElement GetDashboardLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Dashboard"));		
		return element;
	}


	public static WebElement getOpenTillTab(WebDriver driver)
	{

		element =driver.findElement(By.xpath("//*[@id='tabstrip']/ul/li//a[text()='Open Tills']"));
		return element;
	}

	public static WebElement openSelectOptions(WebDriver driver)
	{

		element =driver.findElement(By.xpath("//*[@id='tabstrip-1']//*[text()='Select Option']"));
		return element;
	}

	public static WebElement selectOptions(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//li[text()='"+option+"']"));
		return element;
	}

	public static WebElement selectLocation(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']"));
		return element;
	}

	public static WebElement selectLocationOption(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']/..//li[contains(text(),'"+option+"')]"));
		return element;
	}

	public static WebElement selectDepartment(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Department']"));
		return element;
	}

	public static WebElement selectDepartmentOption(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Department']/..//li[contains(text(),'"+option+"')]"));
		return element;
	}

	public static WebElement selectSite(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Site']"));
		return element;
	}

	public static WebElement selectSiteOption(WebDriver driver, String option)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Site']/..//li[contains(text(),'"+option+"')]"));
		return element;
	}

	public static WebElement employeeAssigned(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[@id='employeeDisplay']//input"));
		return element;
	}

	public static WebElement employeeAssignedList(WebDriver driver, String option)
	{	

		List<WebElement> element;
		element = driver.findElements(By.xpath("//*[@id='EmployeeIdNameList_listbox']//li[text()='"+option+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getInitialValue(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Initial Value')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setInitialValue(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Initial Value')]/following-sibling::span//input[2]"));
		return element;
	}

	/*public static WebElement setInitialValue(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[1]/div[3]/span/span/input[1]"));
		return element;
	}*/

	public static WebElement saveCreateTill(WebDriver driver)
	{	

		element = driver.findElement(By.id("btnSaveCreateTill"));
		return element;
	}

	public static WebElement getAssigendToColumn(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[@id='tillgrid']//a[text()='Assigned To']/preceding-sibling::a"));
		return element;
	}
	
	public static WebElement getFilteredRow(WebDriver driver)
	{	

		List<WebElement> element;
		element = driver.findElements(By.xpath("//*[@id='tillgrid']//tbody//td[3]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getCloseTillButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCloseTill"));		
		return element;
	}
	
	public static WebElement getConfirmCloseTillButton(WebDriver driver)
	{
		element =driver.findElement(By.id("yes"));		
		return element;
	}
	
	
}
