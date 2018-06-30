package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditEmployeeDialogBox {
	private static WebElement element = null;


	public static WebElement getLoginActivityMenuLink(WebDriver driver) {

		element=driver.findElement(By.xpath("//a[text()='Login Activities']"));
		return element;
	}

	public static WebElement getAddLoginActivityButton(WebDriver driver) {

		element=driver.findElement(By.xpath("//*[@value='Add Login Activity']"));
		return element;
	}
	
	public static WebElement getSetPasswordMenuLink(WebDriver driver) {

		element=driver.findElement(By.xpath("//a[text()='Set Password']"));
		return element;
	}

	
	public static WebElement getNewPasswordInputBox(WebDriver driver) {

		element=driver.findElement(By.id("NewPassword"));
		return element;
	}
	
	
	public static WebElement getConfirmPasswordInputBox(WebDriver driver) {

		element=driver.findElement(By.id("ConfirmPassword"));
		return element;
	}
	public static WebElement getUpdatePasswordButton(WebDriver driver) {

		element=driver.findElement(By.id("password-button"));
		return element;
	}
	
	public static WebElement getPopupCloseButton(WebDriver driver) {

		element=driver.findElement(By.xpath("//a[@aria-label='Close']"));
		return element;
	}


}
