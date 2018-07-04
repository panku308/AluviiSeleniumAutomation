package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CashierRegisterPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetCategoryElement(WebDriver driver, String CategoryName)
	{
		
		element =driver.findElement(By.xpath("//div[@id='categoryList']//div[text()='"+CategoryName+"']"));
		return element;
	}
	public static WebElement GetCategoryProductElement(WebDriver driver, String ProductName)
	{
		try
		{
			element =driver.findElement(By.xpath("//div[@id='productContainer']//span[.='"+ProductName+"']"));	
		}
		catch(Exception e)
		{
			element =driver.findElement(By.xpath("//div[@id='productContainer']//div[text() ='"+ProductName+"']"));
		}
		
		return element;
	}
	
	public static WebElement GetPayButton(WebDriver driver)
	{		
		element =driver.findElement(By.id("btnPayment"));
		return element;
	}
	public static WebElement GetSellArcadeCardLink(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//a[@title='Sell Arcade Card']"));
		return element;
	}
	public static WebElement GetSellGiftCardLink(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//a[@title='Sell Gift Card']"));
		return element;
	}
	public static WebElement GetModifierFieldInShopingCardSection(WebDriver driver, String ProductName, String ModifierName)
	{		
		element =driver.findElement(By.xpath("//div[text() = '"+ProductName+"']//span[text()=' - "+ModifierName+" ']"));
		return element;
	}
	
}
