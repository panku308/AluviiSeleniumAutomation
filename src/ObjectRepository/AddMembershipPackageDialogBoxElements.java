package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMembershipPackageDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement getPackageNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("MembershipPackageName"));
		return element;
	}
	public static WebElement getTaxOption(WebDriver driver)
	{	

		element = driver.findElement(By.xpath("//*[text()='Select Tax']"));
		return element;
	}

	public static WebElement setTaxOption(WebDriver driver, String option)
	{			
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='Select Tax']/..//li[contains(text(),'"+option+"')]"));
		return element.get(element.size()-1);
	}
	
	public static WebElement getSalePrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Sale Price')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setSalePrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Sale Price')]/following-sibling::span//input[2]"));
		return element;
	}
	
	public static WebElement getRenewablePrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Renewable Price')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setRenewablePrice(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Renewable Price')]/following-sibling::span//input[2]"));
		return element;
	}
	
	public static WebElement getLengthTypeButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Length Type']/../span/span/span[1]"));
		return element;
	}
	public static WebElement setLengthType(WebDriver driver, String type)
	{
		element =driver.findElement(By.xpath("//*[@id='LengthType_listbox']/li[text()='"+type+"']"));
		return element;
	}
	public static WebElement getMembershipLength(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Membership Length')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setMembershipLength(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Membership Length')]/following-sibling::span//input[2]"));
		return element;
	}
	public static WebElement getScanQty(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Scan Qty')]/following-sibling::span//input[1]"));
		return element;
	}

	public static WebElement setScanQty(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[contains(text(),'Scan Qty')]/following-sibling::span//input[2]"));
		return element;
	}
	public static WebElement getMembershipCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.id("MembershipPackageType"));
		return element;
	}
	public static WebElement getSellabeThroughGuestPortalCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.id("IsSellableByECommerce"));
		return element;
	}
	public static WebElement getSellableCheckbox(WebDriver driver)
	{
		element =driver.findElement(By.id("IsSellable"));
		return element;
	}
	public static WebElement GetNextButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@name='nextButton']"));
		return element;
	}
	public static WebElement getAddEntranceButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddEntrance"));
		return element;
	}
	
	public static WebElement getAddDiscountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddDiscount"));
		return element;
	}
	
	public static WebElement GetSubmitButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@name='saveButton']"));
		return element;
	}

}
