package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddLoginActivityDialogBox {
	private static WebElement element = null;


	public static WebElement getSelectActivityMenu(WebDriver driver) {

		element=driver.findElement(By.xpath("//span[text()='Select Activity']"));
		return element;
	}
	
	public static WebElement getDesiredActivityMenu(WebDriver driver, String option) {

		element=driver.findElement(By.xpath("//*[text()='Select Activity']/..//li[text()='"+option+"']"));
		return element;
	}

	
	
	public static WebElement getAddActivityButton(WebDriver driver) {

		element=driver.findElement(By.id("btnSaveActivity"));
		return element;
	}
	
	
	


}
