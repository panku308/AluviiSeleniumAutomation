package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortalManagementPageElements {
	private static WebElement element = null;

	public static WebElement GetBannersTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Banners"));
		return element;
	}
	public static WebElement GetVouchersTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Vouchers"));
		return element;
	}
	public static WebElement GetHelpManagementTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Help Management"));
		return element;
	}
	public static WebElement GetConfigureTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Configure"));
		return element;
	}
	public static WebElement GetBannerTab_SelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Option']"));
		return element;
	}
	
	public static WebElement GetBannerTab_BannerNameCoumnSettingIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//th[@data-field='BannerName']/a[1]"));
		return element;
	}
	public static WebElement GetBannerTab_BannerNameFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='bannersGrid']/div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));
		return element;
	}
	
	
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpTopic(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_help_management']//a[.='Guest Help Topic']"));
		return element;
	}
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpTopic_SelectOptionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_help_management-1']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpTopic_HelpQuestionColumnSettingIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridHelpTopic']//th[@data-field='HelpQuestion']/a[1]"));
		return element;
	}
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpTopic_HelpQuestionFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridHelpTopic']/div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));
		return element;
	}
	
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpCategory(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_help_management']//a[.='Guest Help Category']"));
		return element;
	}
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpCategory_SelectOptionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_help_management-2']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpCategory_CategoryNameColumnSettingIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridHelpCategory']//th[@data-field='CategoryName']/a[@title='Column Settings']"));
		return element;
	}
	public static WebElement GetHelpManagementTab_SubTab_GuestHelpCategory_CategoryNameFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridHelpCategory']/div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));
		return element;
	}
	
	public static WebElement GetConfigureTab_SubTabConfigure(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_confige']//a[.='Configure']"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabBranding(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tabstrip_confige']//a[.='Branding']"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_SaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSaveConfigure"));
		return element;
	}
	
	public static WebElement GetConfigureTab_SubTabConfigure_ForceUpload(WebDriver driver)
	{
		element =driver.findElement(By.id("ForceUpload"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_ShowAddOns(WebDriver driver)
	{
		element =driver.findElement(By.id("ShowAddOns"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_IsDisableCreateAccount(WebDriver driver)
	{
		element =driver.findElement(By.id("IsDisableCreateAccount"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_IsSimplePassword(WebDriver driver)
	{
		element =driver.findElement(By.id("IsSimplePassword"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_IsModifyImageRestricted(WebDriver driver)
	{
		element =driver.findElement(By.id("IsModifyImageRestricted"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_IsModifyGuestRestricted(WebDriver driver)
	{
		element =driver.findElement(By.id("IsModifyGuestRestricted"));
		return element;
	}
	public static WebElement GetConfigureTab_SubTabConfigure_UpdateImageEveryDaytextBox(WebDriver driver)
	{
		element =driver.findElement(By.id("txtDays"));
		return element;
	}
	
}
