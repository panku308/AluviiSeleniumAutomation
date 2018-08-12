package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAssignmentsEventManagementDialogBoxElements {
	private static WebElement element = null;


	public static WebElement gettab(WebDriver driver, String tabName)
	{
		element =driver.findElement(By.xpath("//*[text()='"+tabName+"']"));
		return element;
	}
	
	public static WebElement getSelectPriceRuleButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select price rule']"));
		return element;
	}
	
	public static WebElement setPriceRule(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlPriceTiers_listbox']//li[text()='"+name+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddPriceRule"));
		return element;
	}
	
	public static WebElement getCloseButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='popupWindow_wnd_title']/..//a"));
		return element;
	}

}
