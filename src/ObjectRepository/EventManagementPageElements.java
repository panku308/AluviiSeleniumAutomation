package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventManagementPageElements {
private static WebElement element = null;
	
	
	public static WebElement getTab(WebDriver driver, String tabName)
	{
	
		element =driver.findElement(By.xpath("//*[text()='"+tabName+"']"));
		return element;
	}
	
	public static WebElement getSchedulesSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tbsVenMgmt-5']//*[text()='Select Option']"));
		return element;
	}
	
	public static WebElement getPriceRulesSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tbsVenMgmt-3']//*[text()='Select Option']"));
		return element;
	}
	
	public static WebElement getAssignmentsSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tbsVenMgmt-1']//*[text()='Select Option']"));
		return element;
	}
	public static WebElement getOtherSettingsSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tabstrip_otherSettings-1']//*[text()='Select Option']"));
		return element;
	}
	
	public static WebElement getPackageSelectOptionDropdownButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='tbsVenMgmt-2']//*[text()='Select Option']"));
		return element;
	}
	
	public static WebElement getPackageSelectOptionDropdownList(WebDriver driver, String list)
	{
	
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlPackageOpt_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getSchedulesSelectOptionDropdownList(WebDriver driver, String list)
	{
	
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlScheduleOptions_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getPriceRulesSelectOptionDropdownList(WebDriver driver, String list)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlPricingOpt_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getAssignmentsSelectOptionDropdownList(WebDriver driver, String list)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlAssignOpt_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getOtherSettingsSelectOptionDropdownList(WebDriver driver, String list)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlCategoryOptions_listbox']/li[text()='"+list+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getColumn_ScheduleName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='grdEventSchedule']//*[text()='Schedule Name']/..//a[1]"));
		return element;
	}
	public static WebElement getScheduleNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='grdEventSchedule']//td[2]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_CategoryName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='categoryGrid']//*[text()='Category Name']/..//a[1]"));
		return element;
	}
	
	
	
	public static WebElement getCategoryNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='categoryGrid']//td[2]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_PriceRuleName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='grdEventPricing']//*[text()='Price Rule Name']/..//a[1]"));
		return element;
	}
	public static WebElement getPriceRuleNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='grdEventPricing']//td[3]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_AssignmentName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='grdVenAssign']//*[text()='Name']/..//a[1]"));
		return element;
	}
	public static WebElement getAssignmentNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='grdVenAssign']//td[1]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getColumn_PackageName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='grdEventPackage']//*[text()='Package Name']/..//a[1]"));
		return element;
	}
	
	public static WebElement getPackageNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='grdEventPackage']//td[2]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getEditScheduleCloseButton(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[text()='Edit Schedule']/..//a"));
		return element;
	}
	
	

}
