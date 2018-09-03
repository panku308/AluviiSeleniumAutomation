package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetStaticCategoryName(WebDriver driver)
	{		
				
		element =driver.findElement(By.xpath("//div[@id='windowInnerPopup']//table/tbody/tr[1]/td[2]/a"));
		
		return element;
	}
	public static WebElement GetDynamicCategoryName(WebDriver driver, String CategoryName)
	{		
				
		element =driver.findElement(By.xpath("//div[@id='windowInnerPopup']//a[text() = '"+CategoryName+"']"));
		return element;
	}
	
	public static WebElement getCategoryNameFilterOption(WebDriver driver)
	{		
				
		element =driver.findElement(By.xpath("//*[@id='windowInnerPopup']//*[text()='Category Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getCategoryNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='windowInnerPopup']//td[2]/a"));
		return element.get(element.size()-1);
	}
	
	public static WebElement GetLastPageButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='windowInnerPopup']//a[@title='Go to the last page']"));
		return element;
	}
}
