package GlobalFiles;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;

public class Debug {
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String option="Add Employee";
		 System.out.println("//*[@id='ddEmployeeTask_listbox']/li[text()='"+option+"']");

	}
	public static void GetGuestRecordRowsFromAccountTabl(WebDriver driver)
	{
		String TableData []= new String [10];
		WebElement AccountGuestRecordRows = ManageMembershipsPageElements.GetAccountGuestTable(driver);
		
		List<WebElement> TableRows = AccountGuestRecordRows.findElements(By.tagName("tr"));
		
		int rowSize=TableRows.size();
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
	
	}
	public static int GetSearchRecordRowCountOfAccountTable(WebDriver driver, String EmailID)
	{
		 ManageMembershipsPageElements.GetSearchTextField(driver).clear();
		 ManageMembershipsPageElements.GetSearchTextField(driver).sendKeys(EmailID);
		 ManageMembershipsPageElements.GetSearchButtonField(driver).click();	
		 //WebElement AccountRecordRow = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody"));
		 WebElement AccountRecordRow = ManageMembershipsPageElements.GetAccountTableElement(driver);
		 List<WebElement> TableRows = AccountRecordRow.findElements(By.tagName("tr"));
		 System.out.println(TableRows.size());
		 return TableRows.size();		 
	}
	
	
}
