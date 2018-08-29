package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardManagementPageElements {
private static WebElement element = null;
	
	public static WebElement getGiftCardsTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Gift Cards"));
		return element;
	}
	public static WebElement getGiftCardsTypeTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Gift Card Types"));
		return element;
	}
	public static WebElement getGiftCardBarCodeColumnSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//th[@data-field='GiftCardBarcode']/a[@title='Column Settings']"));
		return element;
	}
	public static WebElement getBarcodeFieldFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='GiftCardGrid']//table/tbody/tr[1]/td[3]"));
		return element;
	}
	public static WebElement getCurrentBalanceFieldFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='GiftCardGrid']//table/tbody/tr[1]/td[5]"));
		return element;
	}
	public static WebElement getOriginalBalanceFieldFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='GiftCardGrid']//table/tbody/tr[1]/td[6]"));
		return element;
	}
}
