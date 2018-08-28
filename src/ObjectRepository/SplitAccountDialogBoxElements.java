package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SplitAccountDialogBoxElements {
	
	private static WebElement element = null;
	
	public static WebElement getGuestAccount(WebDriver driver)
	{			
	
		element =driver.findElement(By.xpath("//*[@id='oldGuests_listview']/div[2]"));
		return element;
	}	
	
	public static WebElement getNewAccountArea(WebDriver driver)
	{			
	
		element =driver.findElement(By.xpath("//*[@id='newGuests_listview']"));
		return element;
	}
	
	public static WebElement GetPrimayEmailField(WebDriver driver)
	{
		element =driver.findElement(By.id("PrimaryEmail"));
		return element;
	}
	
	public static WebElement GetNextButton_ManageGuestsonNewAccountWindow(WebDriver driver)
	{
		element =driver.findElement(By.id("nextButtonAssignGuest"));
		return element;
	}
	
	public static WebElement GetNextButton_SelectAccountOwnerWindow(WebDriver driver)
	{
		element =driver.findElement(By.name("NextAccountOwner"));
		return element;
	}
	
	public static WebElement GetSubmitButton_NewAccountInfoWindow(WebDriver driver)
	{
		element =driver.findElement(By.name("NextNewAccountInformation"));
		return element;
	}

}
