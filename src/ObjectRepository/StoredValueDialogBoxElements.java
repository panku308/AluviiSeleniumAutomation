package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoredValueDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetSearchUserAccountField(WebDriver driver)
	{		
		element =driver.findElement(By.id("search-user-accounts"));
		return element;
	}
	
	public static WebElement GetSearchIconField(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[@id='user-account-search']/i"));
		return element;
	}
	public static WebElement GetSearchRecordElement(WebDriver driver)
	{		
		element =driver.findElement(By.id("gstId0"));
		return element;
	}
	public static WebElement GetUseValueButton(WebDriver driver)
	{		
		element =driver.findElement(By.id("btnUsedValue"));
		return element;
	}
	
	
	
}
