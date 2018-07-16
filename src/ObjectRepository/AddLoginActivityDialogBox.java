package ObjectRepository;

import java.util.List;

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

	public static WebElement getActivityMenu(WebDriver driver) {

		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlEmployeeActivity_listbox']/li[1]"));
		return element.get(element.size()-1);
	}
	
	public static int getActivityMenuSize(WebDriver driver) {
		
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='Select Activity']/..//li"));
		return element.size();
	}
	
	
	public static WebElement getAddActivityButton(WebDriver driver) {

		element=driver.findElement(By.id("btnSaveActivity"));
		return element;
	}
	
	public static WebElement getCancelActivityButton(WebDriver driver) {

		element=driver.findElement(By.xpath("//*[@value='Cancel']"));
		return element;
	}
	
	
	


}
