package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FastLoadMembershipDialogBoxElements {
	private static WebElement element = null;

	//=============================Account Info Variable==========================================
	public static WebElement getSeasonPassButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Season Pass']"));
		return element;
	}
	public static void selectOwner(WebDriver driver)
	{
		Select select=new Select(driver.findElement(By.id("Owner_0")));
		select.selectByIndex(2);
	}
	
	public static WebElement getSendToCheckoutButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSendToCheckOut"));
		return element;
	}
	
		
	

}
