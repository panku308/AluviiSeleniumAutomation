package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDepartmentDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetDepartmentNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("DepartmentName"));
		return element;
	}
	public static WebElement GetDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("Description"));
		return element;
	}
	
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("AddEditDepartment"));
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

}
