package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortalManagement_AddHelpTopicDialogboxElements {

	private static WebElement element = null;
	public static WebElement GetHelpCategoryDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Guest Help Category']"));
		return element;
	}
	public static WebElement GetHelpQuestion(WebDriver driver)
	{
		element =driver.findElement(By.id("HelpQuestion"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}
	public static WebElement GetHelpExplanationField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//iframe[@class='k-content']//body"));
		return element;
	}
	public static WebElement GetHelpQuestionColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//th[@data-field']/a[1]"));
		return element;
	}
	public static WebElement GetHelpQuestionFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridHelpTopic']/div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));
		return element;
	}	
	


}
