package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GlobalFiles.CommonFunctions;

public class EditProductDialogBoxElements {


	private static WebElement element = null;


	public static WebElement GetOtherTab(WebDriver driver)
	{

		element =driver.findElement(By.linkText("Other"));
		return element;
	}
	
	public static WebElement GetEditButton(WebDriver driver)
	{

		element =driver.findElement(By.id("btnEditGroup"));
		return element;
	}
	
	public static WebElement GetCreateNewGroupButton(WebDriver driver)
	{

		element =driver.findElement(By.id("btnCreateSessionGroup"));
		return element;
	}
	
	public static WebElement GetSelectGroupDropdown(WebDriver driver)
	{

		element =driver.findElement(By.xpath("//span[text()='Select Group']"));
		return element;
	}
	public static WebElement GetSelectGroupDropdownOption(WebDriver driver)
	{

		element =driver.findElement(By.xpath("//*[@id='SessionGroupList_listbox']/li[last()]"));
		return element;
	}
	
	public static WebElement getQualifiedProducts(WebDriver driver, String product)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='"+product+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement GetAddButton(WebDriver driver)
	{

		element =driver.findElement(By.id("addGroupItem"));
		return element;
	}
	
	public static WebElement GetSaveGroupButton(WebDriver driver)
	{

		element =driver.findElement(By.id("btnSaveGroupItem"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{

		element =driver.findElement(By.xpath("//input[@value='Save']"));
		return element;
	}
}
