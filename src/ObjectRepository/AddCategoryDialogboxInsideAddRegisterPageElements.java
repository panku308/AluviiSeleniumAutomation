package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCategoryDialogboxInsideAddRegisterPageElements {
	private static WebElement element = null;
	
	public static WebElement GetCategoryDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='Select Category']"));
		return element;
	}
	public static WebElement GetAddCategoryButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}
	public static void SelectValueFromCategoryDD(WebDriver driver, String category)
	{
		driver.findElement(By.xpath("//li[text()='"+category+"']")).click();
	}

}
