package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPackageDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getPackageNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("PackageName"));
		return element;
	}
	public static WebElement GetIsWaterfallPackageRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='IsWaterfallPackage' and @value='True']"));
		return element;
	}
	public static WebElement getDisplayPrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Display Price *')]/following-sibling::span//input[1]"));
		return element;
	}
	
	public static WebElement setDisplayPrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Display Price *')]/following-sibling::span//input[2]"));
		return element;
	}
	
	public static WebElement selectLocation(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']"));
		return element;
	}

	public static WebElement selectLocationOption(WebDriver driver, String Location)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Location']/..//li[text()='"+Location+"']"));
		return element;
	}
	
	
	public static WebElement getSelectAssignmentButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='PackageAssignmentList_taglist']/..//input"));
		return element;
	}
	
	public static WebElement setAssignmentFromList(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='PackageAssignmentList_listbox']//li[contains(text(),'"+name+"')]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getPriceRuleButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='PackagePriceTierList_taglist']/..//input"));
		return element;
	}
	
	public static WebElement setPriceRuleFromList(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='PackagePriceTierList_listbox']//li[contains(text(),'"+name+"')]"));
		return element.get(element.size()-1);
	}

	
	public static WebElement getShortDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Short Package Description *']/..//input"));
		return element;
	}
	
	public static WebElement getFullDescriptionField(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("//*[text()='Full Length Description *']/..//*[@id='Description']"));
		element=driver.switchTo().activeElement();
		return element;
	}
	
	
	public static WebElement getSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Submit"));
		return element;
	}
	public static WebElement getWaterFallSetupTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Waterfall Setup"));
		return element;
	}
	
	
	
	
	
	public static WebElement getWaterFallSetupTab_Group0DD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='group0_listbox']//span[text()='Select...']"));
		return element;
	}
	public static WebElement getWaterFallSetupTab_Group1DD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='group1_listbox']//span[text()='Select...']"));
		return element;
	}
	public static WebElement SelectWaterFallSetupTab_Group0(WebDriver driver,String str)
	{
		element =driver.findElement(By.xpath("//ul[@id= 'group0_listbox']/li[text()='"+str+"']"));
		return element;
	}
	public static WebElement SelectWaterFallSetupTab_Group1(WebDriver driver,String str)
	{
		element =driver.findElement(By.xpath("//ul[@id= 'group1_listbox']/li[text()='"+str+"']"));
		return element;
	}
	public static WebElement GetWaterFallSetupTab_ManuallyAddPackageButton(WebDriver driver)
	{
		element =driver.findElement(By.id("addPackagesBtn"));
		return element;
	}
	public static WebElement GetWaterFallSetupTab_EventTemplateGroup0(WebDriver driver,String product)
	{
		element =driver.findElement(By.xpath("//div[text()='"+product+"']"));
		return element;
	}
	public static WebElement GetWaterFallSetupTab_EventTimeGroup0(WebDriver driver,String product)
	{
		element =driver.findElement(By.xpath("//div[contains(@title,'"+product+"')]"));
		return element;
	}
	public static WebElement GetWaterFallSetupTab_EventTemplateGroup1(WebDriver driver,String Assignment)
	{
		element =driver.findElement(By.xpath("//div[@title='(3:00 AM - 3:45 AM): "+Assignment+"']"));
		return element;
	}
	public static WebElement GetCloseIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("@class='k-icon k-i-close'"));
		return element;
	}
	
	
	public static WebElement GetWaterFallSetupTab_GroupDetailRow(WebDriver driver,String product)
	{
		element =driver.findElement(By.xpath("//div[contains(@title,'"+product+"']"));
		return element;
	}
	
	public static WebElement GetWaterFallSetupTab_SaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("savePackagesBtn"));
		return element;
	}
	public static WebElement GetWaterFallSetupTab_RecurringButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[text()='Recurring']"));
		return element;
	}
	public static WebElement GetWaterFallSetupTab_SingleDayButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[text()='Single day']"));
		return element;
	}
	
	public static WebElement GetWaterFallSetupTab_NextDayForwardIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='Single day']//ul/li[3]/a/span"));
		return element;
	}
	
	public static WebElement GetWaterFallSetupTab_AddedPackage(WebDriver driver, String Package)
	{
		element =driver.findElement(By.xpath("//dic[text()='"+Package+"']"));
		return element;
	}
	
	
	
	
	
	
	public static WebElement getSelectProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Product']"));
		return element;
	}
	public static WebElement SelectProduct(WebDriver driver, String ProductName)
	{
		element =driver.findElement(By.xpath("//ul[@id='ddlUpsellProducts_listbox']/li[contains(text(),'"+ProductName+"')]"));
		return element;
	}
	public static WebElement getTaxOption(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//ul[@id='TaxOptionList_taglist']/following::input"));
		return element;
	}
	public static WebElement SelectTaxOption(WebDriver driver, String TaxName)
	{
		element =driver.findElement(By.xpath("//ul[@id='TaxOptionList_listbox']/li[text()='"+TaxName+"']"));
		return element;
	}
	public static WebElement getPriceField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='divUpsPrice']/span/span/input[1]"));
		return element;
	}
	public static WebElement GetUpsellProductSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnUpdpkgUps"));
		return element;
	}

}
