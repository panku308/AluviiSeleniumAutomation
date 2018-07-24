package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GlobalFiles.CommonFunctions;

public class AddProductDialogBoxElements {


private static WebElement element = null;
	
	
	public static WebElement GetProductsTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("General Info"));
		
		return element;
	}
	public static WebElement GetPricingTab(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Pricing"));
		return element;
	}
	public static WebElement GetTicketTab(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Ticket"));
		return element;
	}
	public static WebElement GetInventoryTab(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Inventory"));
		return element;
	}
	public static WebElement GetSalesTaxTab(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Sales Tax"));
		return element;
	}
	public static WebElement GetOtherTab(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Other"));
		return element;
	}
	public static WebElement GetAddButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnSaveProduct"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		
		element =driver.findElement(By.name("EditProduct"));
		return element;
	}
	public static WebElement GetCancelButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("/html/body/div[1]/div/form/fieldset/div/div[2]/input[1]"));
		return element;
	}
	
//===================================General Info Tab Elements============================================
	public static WebElement GetProductName(WebDriver driver)
	{
		
		element =driver.findElement(By.id("ProductName"));
		return element;
	}
	
	public static WebElement GetCategory(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//*[@id=\"popupWindowCategory\"]"));
		return element;
	}
	public static WebElement GetProductDescription(WebDriver driver)
	{
		
		element =driver.findElement(By.id("ProductDescription"));
		return element;
	}
	
//===================================Price Tab Elements============================================
	public static WebElement GetUnitCostField(WebDriver driver)
	{
		
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[2]/fieldset/div/div[1]/div/div[1]/span/span/input[1]"));
		element =driver.findElement(By.xpath("//form[@id='frmProductDetail']//div[1]/span/span/input[1]"));
		return element;
	}
	public static WebElement GetUnitCostIncreaseArrow(WebDriver driver)
	{
		
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[2]/fieldset/div/div[1]/div/div[1]/span/span/span/span[1]/span"));
		element =driver.findElement(By.xpath("//form[@id='frmProductDetail']//div[1]/span/span[1]/span"));
		return element;
	}
	public static WebElement GetUnitCostDecreaseArrow(WebDriver driver)
	{
		
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[2]/fieldset/div/div[1]/div/div[1]/span/span/span/span[2]/span"));
		element =driver.findElement(By.xpath("//form[@id='frmProductDetail']//div[1]/span/span[2]/span"));
		return element;
	}
	public static WebElement GetUnitPriceField(WebDriver driver)
	{
											  

		//element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[-2]/fieldset/div/div[2]/div[2]/div/div/div/span/span/input[1]"));
		element =driver.findElement(By.xpath("//div[@id='divUnitPrice']//span/input[1]"));
		return element;
	}
	public static WebElement GetUnitPriceIncreaseArrow(WebDriver driver)
	{
		
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[2]/fieldset/div/div[2]/div[2]/div/div/div/span/span/span/span[1]/span"));
		//element =driver.findElement(By.xpath("//div[@id='divUnitPrice']//span/span[1]/span"));
		element =driver.findElement(By.xpath("//div[@id='divUnitPrice']//span[@title = 'Increase value']/span"));
		return element;
	}
	public static WebElement GetUnitPriceDecreaseArrow(WebDriver driver)
	{
		
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[2]/fieldset/div/div[2]/div[2]/div/div/div/span/span/span/span[2]/span"));
		element =driver.findElement(By.xpath("//div[@id='divUnitPrice']//span[@title = 'Decrease value']/span"));
		return element;
	}

//===================================Ticket Tab Elements============================================
	public static WebElement GetTicketTab_IsATicketCheckbox(WebDriver driver)
	{		
		element =driver.findElement(By.id("isTicketingItem"));
		return element;
	}
	public static WebElement GetTicketTab_AutomaticallyConsumeTicketCheckbox(WebDriver driver)
	{		
		element =driver.findElement(By.id("autoConsume"));
		return element;
	}
	public static WebElement GetTicketTab_TicketTemplateDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[@aria-owns='SecondaryTicketTemplateId_listbox']/span/span[2]"));
		return element;
	}
	public static WebElement GetTicketTab_TicketTypeDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[@aria-owns='TicketTypeId_listbox']/span/span[2]"));
		return element;
	}
	public static WebElement GetTicketTab_EntitlementToConsumeDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[@aria-owns='CompositionId_listbox']/span/span[2]"));
		return element;
	}
	///html/body/div[1]/div/form/div/div/div[3]/fieldset/div/div[2]/div[1]/div[1]/span/span/span[2]
//===================================Inventory Tab Elements============================================
//===================================Sales Tax Tab Elements============================================
	
	public static WebElement GetSalesTax_FirstRowOfTaxOptionNameColumn(WebDriver driver)
	{		
//		element =driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div/div[5]/div/div/div[3]/table/tbody/tr[1]/td[2]"));
		element =driver.findElement(By.xpath("//div[@id='TaxOptionGrid']//div[@class ='k-grid-content']/table/tbody/tr[1]/td[2]"));
		return element;
	}
	public static WebElement GetSalesTax_LocationNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//th[@data-title='Location Name']/a[@title='Column Settings']"));
		return element;
	}
	
	
//===================================Other Info Tab Elements============================================
	
	//========================================================================
	
	public static void SelectDynamicTaxOptionFromDD(WebDriver driver,String TaxOption)
	  {
		  driver.findElement(By.xpath("//*[@id='TaxOptionName_listbox']//li[text()='"+TaxOption+"']")).click();
	  }
	 public static void SelectfirstOptionFromTaxOptionDropdown(WebDriver driver)
	  {
		  driver.findElement(By.xpath("//*[@id='TaxOptionName_listbox']//li[1]")).click();
	  }
	 public static void SetUnitPrice(WebDriver driver, int UnitPrice)
	 {
		 for (int i=0;i<CommonFunctions.CreateProduct_unitPrice;i++)
		  {
			  AddProductDialogBoxElements.GetUnitPriceIncreaseArrow(driver).click();
		  }
	 }
}
