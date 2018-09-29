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
	
	public static WebElement getSubScheduleNameField(WebDriver driver,int count)
	{
		element =driver.findElement(By.id("txtRecName"+count));
		return element;
	}
	
	public static WebElement getStartTime(WebDriver driver, int count)
	{
		//element =driver.findElement(By.xpath("//*[text()='Start']/..//*[@class='k-icon k-i-clock']"));
		element =driver.findElement(By.xpath("//*[text()='Start']/..//*[@class='k-icon k-i-clock' and @aria-controls = 'dtpRecStart"+count+"_timeview']"));
		return element;
	}
	
	public static WebElement setStartTime(WebDriver driver, String time,int count)
	{
	/*	List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='dtpRecStart0_timeview']//*[text()='"+time+"']"));
		return element.get(element.size()-1);
		*/
		
		element =driver.findElement(By.xpath("//*[@id='dtpRecStart"+count+"_timeview']//*[text()='"+time+"']"));
		return element;
	}
	
	public static WebElement getEndTime(WebDriver driver,int count)
	{
		//element =driver.findElement(By.xpath("//*[text()='End']/..//*[@class='k-icon k-i-clock']"));
		element =driver.findElement(By.xpath("//*[text()='End']/..//span[@aria-controls='tpRecEnd"+count+"_timeview']/span[@class='k-icon k-i-clock']"));
		return element;
	}
	
	public static WebElement setEEndTime(WebDriver driver, String time,int count)
	{
		/*List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='tpRecEnd0_timeview']//*[text()='"+time+"']"));
		return element.get(element.size()-1);*/
		element =driver.findElement(By.xpath("//*[@id='tpRecEnd"+count+"_timeview']//*[text()='"+time+"']"));
		return element;
		
	}
	public static WebElement GetScheduleEditButton(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.id("edtSubSch"+count));
		return element;
	}
	public static WebElement GetWeeklyRadioButton(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.id("freqWk"+count));
		return element;
	}
	public static WebElement GetSundayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy0 su"));
		return element;
	}
	public static WebElement GetMondayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy"+count+" mo"));
		return element;
	}
	public static WebElement GetTuesdayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy"+count+" tu"));
		return element;
	}
	public static WebElement GetWednesdayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy"+count+" we"));
		return element;
	}
	public static WebElement GetThrudsdayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy"+count+" th"));
		return element;
	}
	public static WebElement GetFridayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy"+count+" fr"));
		return element;
	}
	public static WebElement GetSaturdayCheckbox(WebDriver driver, int count)
	{
	
		element =driver.findElement(By.className("recWkDy recWkDy"+count+" sa"));
		return element;
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
