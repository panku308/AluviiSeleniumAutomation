package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDiscountRuleDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getDiscountRuleName(WebDriver driver)
	{
		element =driver.findElement(By.id("DiscountRuleName"));
		return element;
	}
	public static WebElement getDiscountProductType(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Product']"));
		return element;
	}
	
	public static WebElement setDiscountProductType(WebDriver driver, String type)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ProductCategoryGroup_listbox']//li[text()='"+type+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getDiscountType(WebDriver driver,String type)
	{
		element =driver.findElement(By.xpath("//input[@id='DiscountType']/..//*[text()='"+type+"']/preceding-sibling::input"));
		return element;
	}
	
	public static WebElement getDiscountField(WebDriver driver, String type)
	{
		if(type.equals("In Percentage"))
		{
		element =driver.findElement(By.xpath("(//*[text()='Discount']/..//input[1])[2]"));
		return element;
		}
		
		element =driver.findElement(By.xpath("(//*[text()='Discount']/..//input[1])[1]"));
		return element;
		
	}
	
	public static WebElement setDiscount(WebDriver driver, String type)
	{
		if(type.equals("In Percentage"))
		{
		element =driver.findElement(By.xpath("(//*[text()='Discount']/..//input[2])[2]"));
		return element;
		}
		
		element =driver.findElement(By.xpath("(//*[text()='Discount']/..//input[2])[1]"));
		return element;
	}
	
	public static WebElement selectDiscountItemButton(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowDiscountItem"));
		return element;
	}
	
	public static WebElement selectProduct(WebDriver driver, String product)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("(//*[text()='Product Name']/../../../../../../..//div[2]//tr)//a[text()='"+product+"']"));
		return  element.get(element.size()-1);
	}
	
	public static WebElement getExternalDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("ExternalDescription"));
		return element;
	}
	
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("AddEditDiscountRule"));
		return element;
	}
	public static WebElement getCategoryNameFilterOption(WebDriver driver)
	{		
				
		element =driver.findElement(By.xpath("//*[@id='innerPopupWindoow']//*[text()='Category Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getCategoryNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='innerPopupWindoow']//td[2]/a"));
		return element.get(element.size()-1);
	}

}
