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
	
	public static WebElement getDiscountField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Discount']/..//input[1]"));
		return element;
	}

	public static WebElement getDiscountType_InPercentageRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='DiscountType']/following::label[text()='In Percentage']"));
		return element;
	}
	public static WebElement setDiscount(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Discount']/..//input[2]"));
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
	

}
