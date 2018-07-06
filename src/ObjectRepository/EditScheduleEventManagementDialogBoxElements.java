package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditScheduleEventManagementDialogBoxElements {
	private static WebElement element = null;


	public static WebElement gettab(WebDriver driver, String tabName)
	{
		element =driver.findElement(By.xpath("//*[text()='"+tabName+"']"));
		return element;
	}

	public static boolean checkSubScheduleName(WebDriver driver, String name) throws InterruptedException
	{
		element =driver.findElement(By.xpath("//*[text()='"+name+"']"));
		
		Thread.sleep(2000);
		
		if(element.isDisplayed())
			return true;
		else
			return false;
	}

}
