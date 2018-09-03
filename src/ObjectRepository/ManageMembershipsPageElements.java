package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageMembershipsPageElements {
	private static WebElement element = null;


	public static WebElement GetSearchTextField(WebDriver driver)
	{
		element =driver.findElement(By.id("searchbox"));
		return element;
	}
	public static WebElement GetSearchButtonField(WebDriver driver)
	{
		element =driver.findElement(By.id("buttonSearchbox"));
		return element;
	}
	public static WebElement GetAccountOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.id("accountoptionsmenu"));
		return element;
	}
	public static WebElement GetCreateNewAccountLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Create New Account"));
		return element;
	}

	public static WebElement GetAccountsTableFirstRowEmailColum(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[8]"));
		element =driver.findElement(By.xpath("//div[@class='k-grid-content']//table[@class='gridrow k-selectable']/tbody/tr/td[8]"));
		return element;
	}
	public static WebElement GetExpandArrowElement(WebDriver driver)
	{
		//element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"));
		element =driver.findElement(By.xpath("//div[@class='k-grid-content']//table[@class='gridrow k-selectable']/tbody/tr[1]/td[1]/a"));		
		return element;
	}
	public static WebElement GetAccountTableElement(WebDriver driver)
	{
		//element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody"));
		element =driver.findElement(By.xpath("//div[@class='k-grid-content']//table[@class='gridrow k-selectable']/tbody"));
		return element;
	}
	public static WebElement GetAccountGuestTable(WebDriver driver)
	{
		//element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div/div[1]/div[2]/table/tbody"));
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody"));
		return element;
	}
	public static WebElement GetAccountGuestFnameLname(WebDriver driver, int row)
	{

		//element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div/div[1]/div[2]/table/tbody/tr["+(row)+"]/td[3]/div/ul/li[1]/h3"));

		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[3]/div/ul/li[1]/h3"));
		return element;
	}
	public static WebElement GetAddGuestButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[text()='Add Guest']"));
		return element;
	}

	public static String[] GetGuestRecordRowsFromAccountTable(WebDriver driver)
	{

		WebElement AccountGuestRecordRows = ManageMembershipsPageElements.GetAccountGuestTable(driver);

		List<WebElement> TableRows = AccountGuestRecordRows.findElements(By.tagName("tr"));

		int rowSize=TableRows.size();
		String TableData []= new String[rowSize];
		System.out.println(rowSize);
		int RowCount=0;
		for(WebElement Row : TableRows)
		{
			int ColCount=0;
			System.out.println("RowCount = " + RowCount );
			List <WebElement> RowColumns = Row.findElements(By.tagName("td"));
			System.out.println("Row Columns = " + RowColumns.size());
			if(RowColumns.size()>0)
			{

				for (WebElement Columns : RowColumns)
				{
					System.out.print("Column["+ColCount+"] = "+Columns.getText().trim()+" | ");
					if(ColCount==2)
					{
						WebElement fNamelName = ManageMembershipsPageElements.GetAccountGuestFnameLname(driver,RowCount+1);
						TableData[RowCount]= fNamelName.getText(); 		
					}
					ColCount++;

				}

			}

			System.out.println("------------------------------");
			RowCount++;
		}
		System.out.println("------------------------------");
		return TableData;
	}
	public static int GetSearchRecordRowCountOfAccountTable(WebDriver driver, String EmailID) throws InterruptedException
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);
		ManageMembershipsPageElements.GetSearchTextField(driver).clear();
		ManageMembershipsPageElements.GetSearchTextField(driver).sendKeys(EmailID);
		ManageMembershipsPageElements.GetSearchButtonField(driver).click();	
		Thread.sleep(5000); 
		WebElement AccountRecordRow = ManageMembershipsPageElements.GetAccountTableElement(driver);
		List<WebElement> TableRows = AccountRecordRow.findElements(By.tagName("tr"));
		System.out.println("GetSearchRecordRowCountOfAccountTable" +TableRows.size());
		return TableRows.size();		 
	}
	public static void ExpandMemberRow(WebDriver driver, String EmailID) throws InterruptedException
	{
		DashboardPageElements.GetManageMemberShipLink(driver).click();
		Thread.sleep(5000);
		ManageMembershipsPageElements.GetSearchTextField(driver).clear();
		ManageMembershipsPageElements.GetSearchTextField(driver).sendKeys(EmailID);
		ManageMembershipsPageElements.GetSearchButtonField(driver).click();	
		Thread.sleep(5000);
		ManageMembershipsPageElements.GetExpandArrowElement(driver).click();

	}
	public static WebElement GetAccountGuestAddMembership(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]/div[1]/button"));
		return element;
	}
	public static WebElement GetAccountGuest_StoredValueLink(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Stored Value"));
		return element;
	}

	public static WebElement GetAccountGuest_BarcodesLink(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Barcodes"));
		return element;
	}
	public static WebElement GetAccountGuest_BarcodeField(WebDriver driver)
	{
		//element = driver.findElement(By.xpath("//div[@class='guestBarcode k-barcode']//svg/g/g[1]/text"));

		WebElement BarcodeDiv = driver.findElement(By.xpath("//div[contains(@id,'barcode_') and @data-role='barcode']"));
		WebElement svg = BarcodeDiv.findElement(By.tagName("svg"));
		List<WebElement> Parent_g_Tag = svg.findElements(By.tagName("g"));
		List<WebElement> Child_g_Tag = Parent_g_Tag.get(0).findElements(By.tagName("g"));
		element = Child_g_Tag.get(0).findElement(By.tagName("text"));


		return element;
	}
	public static WebElement GetCheckoutTab_PaymentButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[text() = 'Payment']"));
		return element;
	}
	public static WebElement GetCheckoutTab_OpenCashDrawerButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[text() = 'Open Cash Drawer']"));
		return element;
	}
	public static WebElement GetCheckoutTab_ClearCheckoutButton(WebDriver driver)
	{
		element = driver.findElement(By.id("btnClearItems"));
		return element;
	}
	public static WebElement GetCheckoutTab_CompAllButton(WebDriver driver)
	{
		element = driver.findElement(By.id("btnCompAll"));
		return element;
	}
	public static WebElement GetStoredValue_AddAmountField(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='form-row displayBlock']//input[@class='k-formatted-value k-input']"));
		return element;
	}
	public static WebElement GetStoredValue_AddToCartButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//span[ contains(@id, 'btnAddToCart_')]"));
		return element;
	}
	public static WebElement GetMembershipPackageName(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]//div[2]/div[1]/div/div[1]"));																													
		return element;
	}
	public static WebElement GetMembershipPackageExp(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]//div[2]/div[1]/div/div[2]"));

		return element;
	}
	public static WebElement GetActionButton(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]//button[contains(text(),'ACTION')]/following::button"));

		return element;
	}
	public static WebElement GetActionModifyOption(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]//li/a[contains(text(),'Modify')]"));
		return element;
	}
	public static WebElement GetActionValidatOrScanOption(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]//li/a[contains(text(),'Validate/Scan')]"));
		return element;
	}
	public static WebElement GetActionHistoryOption(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]//li/a[contains(text(),'History')]"));
		return element;
	}

	public static int getDesiredColumnIndex(WebDriver driver, String columnName)
	{
		List<WebElement> elements;
		elements =driver.findElements(By.xpath("//*[@id='accountgrid']//th"));


		for(int i=0;i<elements.size();i++)			
		{	
			try {
				if(elements.get(i).getAttribute("data-title").equals(columnName))			
					return i+1;

			}
			catch(Exception e)
			{

			}
		}

		return 1000000001;
	}

	public static WebElement getDesiredAccountColumn(WebDriver driver, int columnIndex)
	{			

		element =driver.findElement(By.xpath("//*[@id='accountgrid']//th["+columnIndex+"]//a[1]"));
		return element;
	}
	public static WebElement getFilteredColumn(WebDriver driver, int columnIndex)
	{
		List<WebElement> element;
		element = driver.findElements(By.xpath("//*[@id='accountgrid']//td["+columnIndex+"]"));
		return element.get(element.size()-1);
	}

	public static WebElement getFilteredColumns(WebDriver driver, int columnIndex, int dataIndex)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='accountgrid']//td["+columnIndex+"]"));
		return element.get(dataIndex);
	}

	public static WebElement getClearFilterButton(WebDriver driver)
	{			

		element =driver.findElement(By.xpath("//button[text()='Clear All Filters']"));
		return element;
	}

	public static WebElement getAddGuestButton(WebDriver driver)
	{			

		element =driver.findElement(By.xpath("//button[text()='Add Guest']"));
		return element;
	}

	public static WebElement getSplitAccountButton(WebDriver driver)
	{			

		element =driver.findElement(By.xpath("//button[text()='Split Account']"));
		return element;
	}

	public static WebElement getMergeGuestsButton(WebDriver driver)
	{			

		element =driver.findElement(By.xpath("//button[text()='Merge Guests']"));
		return element;
	}

	public static WebElement getFastLoadMembershipButton(WebDriver driver)
	{			

		element =driver.findElement(By.xpath("//button[text()='Fast Load Membership']"));
		return element;
	}


	public static boolean isPresent(WebDriver driver, String string)
	{			

		List<WebElement> elements =driver.findElements(By.xpath("//*[contains(text(),'"+string+"')]"));

		if(elements.get(0).isDisplayed() && elements.get(1).isDisplayed())
			return true;
		else
			return false;
	}

	public static boolean isMergedAccountPresent(WebDriver driver, String string)
	{			

		List<WebElement> elements =driver.findElements(By.xpath("//*[contains(text(),'"+string+"')]"));

		if(elements.get(0).isDisplayed() && elements.get(1).isDisplayed() && elements.get(2).isDisplayed())
			return true;
		else
			return false;
	}
	public static WebElement GetMergeAccountsLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Merge Accounts"));
		return element;
	}
	public static WebElement GetEditAccountLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Edit Account"));
		return element;
	}



	public static boolean IsSeasonPassAvailable(WebDriver driver)
	{
		element =driver.findElement(By.xpath("(//*[text()='Season Pass'])[1]"));
		if(element.isDisplayed())
			return true;
		
		return false;
	}		

}	
