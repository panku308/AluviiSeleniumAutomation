package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortal_HelpPageElements {
	
	private static WebElement element = null;
	public static WebElement GetHelpCategoryLink(WebDriver driver, String Category)
	{
		element =driver.findElement(By.linkText(Category));
		return element;
	}
	public static WebElement GetHelpTopicLink(WebDriver driver, String Topic)
	{
		element =driver.findElement(By.xpath("//span[text()='"+Topic+"']"));
		return element;
	}
	
	public static WebElement GetAnswerField(WebDriver driver, String Topic)
	{
		element =driver.findElement(By.xpath("//span [text()='"+Topic+"']//following::div/p"));
		return element;
	}
	

}
