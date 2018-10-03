package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAssignmentsEventManagementDialogBoxElements {
	private static WebElement element = null;


	public static WebElement gettab(WebDriver driver, String tabName)
	{
		element =driver.findElement(By.xpath("//*[text()='"+tabName+"']"));
		return element;
	}
	public static WebElement getUpsellsTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Upsells']"));
		return element;
	}
	public static WebElement getSelectPriceRuleButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select price rule']"));
		return element;
	}
	public static WebElement getUpsellTab_TaxOptionButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='TaxOptionListUpsell_taglist']/..//input"));
		//element =driver.findElement(By.xpath("//*[text()='Tax Option']/../..//*[text()='Select Tax']"));
		return element;
	}
	
	public static WebElement setUpsellTab_TaxOption(WebDriver driver, String option)
	{
		List<WebElement> element;
		//element =driver.findElements(By.xpath("//*[@id='TaxOptionId_listbox']//li[text()='"+option+"']"));
		element =driver.findElements(By.xpath("//*[@id='TaxOptionListUpsell_listbox']//li[text()='"+option+"']"));
		return element.get(element.size()-1);
		
	}
	
	public static WebElement getSelectProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select Product']"));
		return element;
	}
	
	public static void SelectProductOptionFromDD(WebDriver driver,String option)
	{
		driver.findElement(By.xpath("//*[@id='ddlUpsellProducts_listbox']//li[contains(text(),'"+option+"')]")).click();
	}

	public static WebElement getTaxOpionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select Tax']/.."));
		return element;
	}

	public static void SelectTaxOptionFromDD(WebDriver driver,String TaxOption)
	{
		driver.findElement(By.xpath("//*[@id='TaxOptionListUpsell_listbox']//li[text()='"+TaxOption+"']")).click();
	}
	
	public static WebElement getPrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Price')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setPrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Price')]/following-sibling::span//input[2]"));
		return element;
	}
	
	public static WebElement getUpsellTab_ProductDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Product']"));		
		return element;
	}
	public static WebElement getUpsellTab_SelectProduct(WebDriver driver, String product)
	{
		element =driver.findElement(By.xpath("//ul=[@id='ddlUpsellProducts_listbox']/li[contains(text(),'"+product+"')]"));		
		return element;
	}
	public static WebElement getUpsellTab_PriceField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='divUpsPrice']/span/span/input[1]"));		
		return element;
	}
	public static WebElement getUpsellTab_SaveButton(WebDriver driver, String product)
	{
		element =driver.findElement(By.id("btnUpdVenUps"));		
		return element;
	}
	
	public static WebElement setPriceRule(WebDriver driver, String name)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='ddlPriceTiers_listbox']//li[text()='"+name+"']"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getPriceRuleSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddPriceRule"));
		return element;
	}
	
	public static WebElement getSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddPriceRule"));
		return element;
	}
	
	public static WebElement getUpsellSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnUpdVenUps"));
		return element;
	}
	
	public static WebElement getCloseButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='popupWindow_wnd_title']/..//a"));
		return element;
	}

}