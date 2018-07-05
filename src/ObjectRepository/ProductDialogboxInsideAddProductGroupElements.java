package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDialogboxInsideAddProductGroupElements {
	private static WebElement element = null;
	public static WebElement GetStaticProductName(WebDriver driver)
	{		
				
		element =driver.findElement(By.xpath("//div[@id='gridProduct']//table/tbody/tr[1]/td[2]/a"));
		
		return element;
	}
	public static WebElement GetDynamicProductName(WebDriver driver, String ProductName)
	{		
				
		element =driver.findElement(By.xpath("//div[@id='gridProduct']//a[text() = '"+ProductName+"']"));
		return element;
	}
	
	public static WebElement GetLastPageButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridProduct']//a[@title='Go to the last page']"));
		return element;
	}
	public static WebElement GetProductNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='gridProduct']//th[@data-title = 'Product Name']/a[1]"));
		return element;
	}
	
}
