package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductDialogboxInsideAddRegisterPageElements {
private static WebElement element = null;
	
	public static WebElement GetProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select Product']"));
		return element;
	}
	public static WebElement GetAddProductButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}
	public static WebElement GetCancelButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@value='Cancel']"));
		return element;
	}
	public static void SelectValueFromProductDD(WebDriver driver, String OptionName, String ProductType)
	{
		if(ProductType.trim().toLowerCase().equals("product"))
		{
			OptionName = OptionName+" (Product)";
		}		
		else if(ProductType.trim().toLowerCase().equals("group"))
		{
			OptionName = OptionName+" (Group)";
		}
		driver.findElement(By.xpath("//li[text()='"+OptionName+"']")).click();
	}
}
