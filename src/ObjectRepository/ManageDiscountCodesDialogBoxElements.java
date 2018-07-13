package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageDiscountCodesDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getAddCodeButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddCode"));
		return element;
	}
	
	public static WebElement getDiscountCodeField(WebDriver driver)
	{
		element =driver.findElement(By.id("DiscountCode"));
		return element;
	}
	
	public static WebElement getPopupCloseButton(WebDriver driver) {

		element=driver.findElement(By.xpath("//*[@id='windowPopup_discount_wnd_title']/..//a"));
		return element;
	}
	

}
