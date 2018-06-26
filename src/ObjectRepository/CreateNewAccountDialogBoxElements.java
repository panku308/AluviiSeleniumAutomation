package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewAccountDialogBoxElements {
private static WebElement element = null;
	
//=============================Account Info Variable==========================================
	public static WebElement GetAccountNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("GuestAccountName"));
		return element;
	}
	public static WebElement GetPrimayEmailField(WebDriver driver)
	{
		element =driver.findElement(By.id("PrimaryEmail"));
		return element;
	}
	public static WebElement GetPhoneNumberField(WebDriver driver)
	{
		element =driver.findElement(By.id("PrimaryPhone"));
		return element;
	}
	public static WebElement Get_Add_StreetField(WebDriver driver)
	{
		element =driver.findElement(By.id("StreetAddress1"));
		return element;
	}
	public static WebElement Get_Add_ZipCodeField(WebDriver driver)
	{
		element =driver.findElement(By.id("ZipCode"));
		return element;
	}
	public static WebElement Get_Add_CityField(WebDriver driver)
	{
		element =driver.findElement(By.id("City"));
		return element;
	}
	public static WebElement Get_Add_StateField(WebDriver driver)
	{
		element =driver.findElement(By.id("State"));
		return element;
	}
	public static WebElement Get_Add_CountryField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[.='United States']"));
		return element;
	}
	public static WebElement Get_Add_NextButton(WebDriver driver)
	{
		element =driver.findElement(By.name("nextButton"));
		return element;
	}
	
	//=============================Account owner Variable==========================================
	public static WebElement GetFirstnameField(WebDriver driver)
	{
		element =driver.findElement(By.id("FirstName"));
		return element;
	}
	public static WebElement GetLastname(WebDriver driver)
	{
		element =driver.findElement(By.id("LastName"));
		return element;
	}
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));
		return element;
	}
	//=============================Finalize Variable==========================================
	public static WebElement GetClosetButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCancel"));
		return element;
	}
	
}
