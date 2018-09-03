package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDiscountDialogBoxElements {
	private static WebElement element = null;
	public static WebElement getDiscountCodeInputField(WebDriver driver)
	{		
				
		element =driver.findElement(By.id("txtDiscountCode"));
		
		return element;
	}
	public static WebElement getApplyButton(WebDriver driver)
	{		
				
		element =driver.findElement(By.id("btnApplyDiscountCode"));
		
		return element;
	}
	
	
	public static WebElement getCloseButton(WebDriver driver)
	{		
				
		element =driver.findElement(By.id("btnCloseDiscountCode"));
		
		return element;
	}
	
	public static WebElement getAppliedDiscount(WebDriver driver)
	{		
				
		element =driver.findElement(By.id("spnTotalDiscountApplied"));
		
		return element;
	}
	
}
