package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMembershipDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetAdventureSeasonPassLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'guestMemberships_listview']//div[ text() = 'Adventurer Season Pass']"));
		return element;
	}
	public static WebElement GetJuniorAdventureSeasonPassLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'guestMemberships_listview']//div[text() = 'Junior Adventurer Season Pass']"));
		return element;
	}
	public static WebElement GetSeniorAdventureSeasonPassLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'guestMemberships_listview']//div[text() = 'Senior Adventurer Season Pass']"));
		return element;
	}
	public static WebElement Get10PunchPass(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'guestMemberships_listview']//div[text() = '10 Punch Pass']"));
		return element;
	}
	public static WebElement GetSendToCheckoutButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSendToCheckOut"));
		return element;
	}

}
