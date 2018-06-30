package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddEmployeeDialogBox {
private static WebElement element = null;
	
	
	public static WebElement getFirstName(WebDriver driver) {

		element=driver.findElement(By.id("FirstName"));
		return element;
	}

	public static WebElement getLastName(WebDriver driver) {

		element=driver.findElement(By.id("LastName"));
		return element;
	}

	public static WebElement getEmployeeEmail(WebDriver driver) {

		element=driver.findElement(By.id("EmployeeEmail"));
		return element;
	}

	public static WebElement getSave(WebDriver driver) {

		element=driver.findElement(By.xpath("//*[@id='employeeEdit']/div[1]/div[12]/div/input"));
		return element;
	}
	
	

}
