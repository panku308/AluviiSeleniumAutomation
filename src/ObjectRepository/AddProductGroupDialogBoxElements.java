package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GlobalFiles.CommonFunctions;

public class AddProductGroupDialogBoxElements {
private static WebElement element = null;
	
	public static WebElement GetProductGroupNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("ProductGroupModel_ProductGroupName"));
		return element;
	}
	public static WebElement GetDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("ProductGroupModel_ProductGroupDescription"));
		return element;
	}
	public static WebElement GetUnitPerIssueIncreaseValueIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text() = 'Unit Per Issue']//following::span[@title='Increase value']"));
		return element;
	}
	public static WebElement GetUnitPriceForGroupIncreaseValueIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id = 'divProductGroupCost']//span[@title='Increase value']"));
		return element;
	}
	public static WebElement GetUniversalPriceCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.id("ProductGroupModel_UniversalPricing"));
		return element;
	}
	public static WebElement GetPopupCategoryWindowIcon	(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowCategory"));
		return element;
	}
	public static WebElement GetAddProductButton	(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowAddProduct"));
		return element;
	}
	public static void SelectfirstOptionFromTaxOptionDropdown(WebDriver driver)
	{
		  driver.findElement(By.xpath("//*[@id='TaxOptionName_listbox']//li[1]")).click();
	}
	public static WebElement GetSalesTax_FirstRowOfTaxOptionNameColumn(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='TaxOptionGrid']//div[@class ='k-grid-content']/table/tbody/tr[1]/td[2]"));
		return element;
	}
	public static WebElement GetSalesTax_LocationNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='TaxOptionGrid']//th[@data-title='Location Name']/a[1]"));
		return element;
	}
	public static void SelectDynamicTaxOptionFromDD(WebDriver driver,String TaxOption)
	{
		  driver.findElement(By.xpath("//*[@id='TaxOptions_listbox']//li[text()='"+TaxOption+"']")).click();
	}
	public static WebElement GetAddButton(WebDriver driver)
	{		
		element =driver.findElement(By.name("Add"));
		return element;
	}
	public static void SetUnitPriceForGroup(WebDriver driver, int UnitPrice)
	 {
		 for (int i=0;i<CommonFunctions.CreateProductGroup_UnitPrice;i++)
		  {
			  GetUnitPriceForGroupIncreaseValueIcon(driver).click();
		  }
	 }
	
	
	

}
