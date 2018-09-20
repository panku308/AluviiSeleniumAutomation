package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortal_GuestAccountPageElements {
	
	private static WebElement element = null;

	public static WebElement GetAccountInformationLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText(" Account Information"));
		return element;
	}
	public static WebElement GetManageMembersLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Manage Members"));
		return element;
	}
	public static WebElement GetTransactionAndReceiptsLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Transactions and Receipts"));
		return element;
	}
	public static WebElement GetChangePasswordLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Change Password"));
		return element;
	}
	public static WebElement GetManageMembers_AccountMemberDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Member']"));
		return element;
	}
	public static WebElement GetManageMembers_SelectAccountMemberDD(WebDriver driver, String str)
	{
		element =driver.findElement(By.xpath("//ul[@id='MemberDropDownList_listbox']/li[text()='"+str+"']"));
		return element;
	}	
	public static WebElement GetManageMembers_EditImageIcon(WebDriver driver)
	{
		element =driver.findElement(By.id("popupWindowPicMonkeyAPIForAdd"));
		return element;
	}
	public static WebElement GetManageMembers_DisabledEditImageIcon(WebDriver driver)
	{
		element =driver.findElement(By.id("btnPencil"));
		return element;
	}
	public static WebElement GetManageMembers_SelectFilesButton(WebDriver driver)
	{
		element =driver.findElement(By.id("files"));
		return element;
	}	
	public static WebElement GetManageMembers_SaveChangesButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSaveChanges"));
		return element;
	}
	public static WebElement GetManageMembers_SuccessFailureMessage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//dic[@class='divMsgProp']/h5"));
		return element;
	}
	public static WebElement GetManageMembers_NewMemberButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='New Member']"));
		return element;
	}
	public static WebElement GetManageMembers_AddNewMemberDialog_FirstName(WebDriver driver)
	{
		element =driver.findElement(By.id("FirstName"));
		return element;
	}
	public static WebElement GetManageMembers_AddNewMemberDialog_LastName(WebDriver driver)
	{
		element =driver.findElement(By.id("LastName"));
		return element;
	}
	public static WebElement GetManageMembers_AddNewMemberDialog_BirthDate(WebDriver driver)
	{
		element =driver.findElement(By.id("BirthDate"));
		return element;
	}
	public static WebElement GetManageMembers_AddNewMemberDialog_SaveNewMemberButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAddGuest"));
		return element;
	}
}
