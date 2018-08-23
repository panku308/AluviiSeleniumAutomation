package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignWaiver2PageElements {
	private static WebElement element = null;
	public static String GuestFnameLname []=null;
	public static String SignWaiverEmailID="";
		
		public static WebElement GetEmailIDField(WebDriver driver)
		{
			element =driver.findElement(By.id("EmailAddress"));
			return element;
		}
		public static WebElement GetAdultFirstNameField(WebDriver driver)
		{
			element =driver.findElement(By.id("FirstName"));
			return element;
		}
		public static WebElement GetAdultLastNameField(WebDriver driver)
		{
			element =driver.findElement(By.id("LastName"));
			return element;
		}
		public static WebElement GetAdultBirthYearField(WebDriver driver)
		{
			element =driver.findElement(By.id("guestBirthYear"));
			return element;
		}
		public static WebElement GetAdultBirthMonthField(WebDriver driver)
		{
			element =driver.findElement(By.id("guestBirthMonth"));
			return element;
		}
		public static WebElement GetAdultBirthDateField(WebDriver driver)
		{
			element =driver.findElement(By.id("guestBirthDate"));
			return element;
		}
		public static WebElement GetStreetAddressField(WebDriver driver)
		{
			element =driver.findElement(By.id("StreetAddress"));
			return element;
		}
		public static WebElement GetCityField(WebDriver driver)
		{
			element =driver.findElement(By.id("City"));
			return element;
		}
		public static WebElement GetStateField(WebDriver driver)
		{
			element =driver.findElement(By.id("State"));
			return element;
		}
		public static WebElement GetZipCodeField(WebDriver driver)
		{
			element =driver.findElement(By.id("ZipCode"));
			return element;
		}
		public static WebElement GetAddMinorButton(WebDriver driver)
		{
			element =driver.findElement(By.id("btnAddMinor"));
			return element;
		}
		public static WebElement GetContinueButton(WebDriver driver)
		{
			element =driver.findElement(By.id("btnContinueStepTwo"));
			return element;
		}
		public static WebElement GetMinorFirstNameField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("FirstName"+Guestcount));
			return element;
		}
		public static WebElement GetMinorLastNameField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("LastName"+Guestcount));
			return element;
		}
		public static WebElement GetMinorBirthYearField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("guestBirthYear"+Guestcount));
			return element;
		}
		public static WebElement GetMinorBirthMonthField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("guestBirthMonth"+Guestcount));
			return element;
		}
		public static WebElement GetMinorBirthDateField(WebDriver driver, String Guestcount)
		{
			element =driver.findElement(By.id("guestBirthDate"+Guestcount));
			return element;
		}		
		
		public static WebElement GetIAcknowledgeCheckBox(WebDriver driver)
		{
			element =driver.findElement(By.id("IsSignerAcknowledge"));
			return element;
		}
		public static WebElement GetEmailOptOutCheckBox(WebDriver driver)
		{
			element =driver.findElement(By.id("IsEmailForMarketing"));
			return element;
		}
		public static WebElement GetMyseldAndChildrenButton(WebDriver driver)
		{
			element =driver.findElement(By.id("btnImFinished"));
			return element;
		}
		
}
