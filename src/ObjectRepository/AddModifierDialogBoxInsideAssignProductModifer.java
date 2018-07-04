package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddModifierDialogBoxInsideAssignProductModifer {
private static WebElement element = null;
	
	
		public static WebElement GetDynamicModifierName(WebDriver driver, String ModifierName)
		{		
					
			element =driver.findElement(By.xpath("//div[@id='modifierGrid']//a[text() = '"+ModifierName+"']"));
			return element;
		}
		
		public static WebElement GetLastPageButton(WebDriver driver)
		{
			element =driver.findElement(By.xpath("//div[@id='modifierGrid']//a[@title='Go to the last page']"));
			return element;
		}
}
