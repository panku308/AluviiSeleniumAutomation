package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterManagementDashboardPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetProductsTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Products"));
		return element;
	}
	public static WebElement GetRegistersTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip']//a[.='Registers']"));
		return element;
	}
	public static WebElement GetDiscountTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Discount"));
		return element;
	}
	public static WebElement GetDiscount_subTab_DiscountRules(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Discount Rules"));
		return element;
	}
	public static WebElement GetDiscount_subTab_DiscountPackage(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Discount Package"));
		return element;
	}
	public static WebElement GetRegistersTab_subtab_Registers(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip-1']//a[.='Registers']"));
		return element;
	}
	public static WebElement GetProductsTab_subtab_Products(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product']//li/a[.='Products']"));
		return element;
	}
	public static WebElement GetProductsTab_subtab_ProductGroups(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product']//li/a[.='Product Groups']"));
		return element;
	}
	public static WebElement GetProductsTab_subtab_Modifiers(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product']//li/a[.='Modifiers']"));
		return element;
	}
	public static WebElement GetProductsTab_subtab_Categories(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product']//li/a[.='Categories']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Products_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product-1']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Categories_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product-2']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//div[@id='tabstrip_product-4']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetDiscountsTab_SubTab_DiscountRule_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_discount-2']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetDiscountsTab_SubTab_DiscountPackage_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_discount-1']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetRegistersTab_SubTab_Registers_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_registers-1']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_Modifiers_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product-4']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//div[@id='tabstrip_product-3']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement GetProductsTab_SubTab_ProductGroups_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_product-3']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//div[@id='tabstrip_product-2']//span[.='Select Option']"));
		//element =driver.findElement(By.xpath("//span[.='Select Option']"));
		return element;
	}
	public static WebElement SelectOptionFromSelectOptionDD(WebDriver driver, String OptName)
	{
		element =driver.findElement(By.xpath("//li[text() = '"+OptName+"']"));
		return element;
	}
	
	public static WebElement Get_ProductTable_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='productsgrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement Get_ProductTable_FirstRowProductNameCloumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='productsgrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	public static WebElement Get_ProductTab_SubTab_Categories_CategoryTable_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='categoryGrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement Get_ProductTab_SubTab_Categories_CategoryTable_FirstRowProductNameCloumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='categoryGrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	
	public static WebElement GetRegistersTab_SubTab_Registers_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='RegisterGrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement GetRegistersTab_SubTab_Registers_FirstRowRegisterNameCloumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='RegisterGrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}

	public static WebElement GetProductsTab_SubTab_Modifier_ModifierNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='gridModifier']//th[@data-title = 'Modifier Name']/a[1]"));
		return element;
	}
	public static WebElement Get_ModifierTable_FirstRowModifierNameCloumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridModifier']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	public static WebElement Get_ModifierTableElement(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridModifier']//div[@class='k-grid-content']/table/tbody"));		
		return element;
	}
	public static int GetSearchRecordRowCountOfModifierTable(WebDriver driver)
	{
		WebElement ModifierRecordRow = Get_ModifierTableElement(driver);
		 List<WebElement> TableRows = ModifierRecordRow.findElements(By.tagName("tr"));
		 System.out.println("GetSearchRecordRowCountOfModifierTable = " +TableRows.size());
		 return TableRows.size();
	}
	public static WebElement GetProductsTab_SubTab_Products_ProductNameColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='productsgrid']//th[@data-title = 'Product Name']/a[1]"));
		return element;
	}
	public static WebElement Get_ProductGroupTable_IDColumn(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='productGroupGrid']//a[ .= 'ID']"));
		return element;
	}
	public static WebElement Get_ProductGroupTable_FirstRowProductGroupNameCloumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='productGroupGrid']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}
	public static WebElement getColumn_DiscountRuleName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='gridDiscountsRule']//*[text()='Discount Rule Name']/..//a[1]"));
		return element;
	}
	public static WebElement getDiscountRuleNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='gridDiscountsRule']//td[2]"));
		return element.get(element.size()-1);
	}
	public static WebElement getColumn_DiscountPackageName(WebDriver driver)
	{
	
		element =driver.findElement(By.xpath("//*[@id='discountGrid']//*[text()='Discount Package Name']/..//a[1]"));
		return element;
	}
	public static WebElement getDiscountPackageNameFilteredValue(WebDriver driver)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='discountGrid']//td[2]"));
		return element.get(element.size()-1);
	}
}
