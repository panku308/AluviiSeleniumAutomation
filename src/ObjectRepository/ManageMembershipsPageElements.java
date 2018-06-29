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
	
	public static WebElement GetAccountGuestAddMembership(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//div[contains(@id, 'accountgrid_')]//table/tbody/tr["+(row)+"]/td[4]/div[1]/button"));
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
}	
