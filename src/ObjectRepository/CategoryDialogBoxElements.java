package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetStaticCategoryName(WebDriver driver)
	{		
				
		element =driver.findElement(By.xpath("//div[@id='windowInnerPopup']//table/tbody/tr[1]/td[2]"));
		return element;
	}
	public static WebElement GetDynamicCategoryName(WebDriver driver, String CategoryName)
	{		
				
		element =driver.findElement(By.xpath("//div[@id='windowInnerPopup']//a[text() = '"+CategoryName+"']"));
		return element;
	}
	
	public static WebElement GetLastPageButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='windowInnerPopup']//a[@title='Go to the last page']"));
		return element;
	}
}
