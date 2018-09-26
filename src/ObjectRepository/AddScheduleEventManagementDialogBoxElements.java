package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddScheduleEventManagementDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getScheduleNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtSchedName"));
		return element;
	}
	public static WebElement getSelectTimeZoneButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select Time Zone']"));
		return element;
	}
	public static WebElement setSelectTimeZone(WebDriver driver, String timeZone)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='Select Time Zone']/..//*[contains(text(),'"+timeZone+"')]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getNormalDurationTime(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Normal Duration')]/../..//input[1]"));
		return element;
	}
	
	public static WebElement setNormalDurationTime(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Normal Duration')]/../..//input[2]"));
		return element;
	}
	
	public static WebElement getMinutesBetweenField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Minutes Between')]/../..//input[1]"));
		return element;
	}
	
	public static WebElement setMinutesBetweenField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Minutes Between')]/../..//input[2]"));
		return element;
	}
	
	
	
	public static WebElement gettab(WebDriver driver, String tabName)
	{
		element =driver.findElement(By.xpath("//*[text()='"+tabName+"']"));
		return element;
	}
	
	public static WebElement getAddSubScheduleButton(WebDriver driver)
	{
		element =driver.findElement(By.id("addSubSch"));
		return element;
	}
	
	public static WebElement getSubScheduleNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtRecName0"));
		return element;
	}
	
	public static WebElement getStartTime(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Start']/..//*[@class='k-icon k-i-clock']"));
		return element;
	}
	
	public static WebElement setStartTime(WebDriver driver, String time)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='dtpRecStart0_timeview']//*[text()='"+time+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getEndTime(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='End']/..//*[@class='k-icon k-i-clock']"));
		return element;
	}
	
	public static WebElement setEEndTime(WebDriver driver, String time)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='tpRecEnd0_timeview']//*[text()='"+time+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement GetEnableSession_YES_RadioButton(WebDriver driver)
	{
		element =driver.findElement(By.id("opYes"));
		return element;
	}
	
	public static WebElement GetAddButton(WebDriver driver)
	{
		element =driver.findElement(By.name("Add"));
		return element;
	}

}
