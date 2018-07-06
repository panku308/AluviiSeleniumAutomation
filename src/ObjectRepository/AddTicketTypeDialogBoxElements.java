package ObjectRepository;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTicketTypeDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetTicketTypeNameField(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketTypeName"));
		return element;
	}
	public static WebElement GetTicketStartDate(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketStartDate"));
		return element;
	}
	public static WebElement GetTicketEndDate(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketEndDate"));
		return element;
	}
	public static WebElement GetTicketTypeDescription(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketTypeDescription"));
		return element;
	}
	public static WebElement GetTicketNotes(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketNotes"));
		return element;
	}
	public static WebElement GetTicketTemplateDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[.='Select ticket template']"));
		return element;
	}
	public static WebElement GetNextButton(WebDriver driver)
	{		
		element =driver.findElement(By.name("nextButton"));
		return element;
	}
	public static WebElement GetSubmitButton(WebDriver driver)
	{		
		element =driver.findElement(By.name("saveButton"));
		return element;
	}
	public static WebElement GetCompositionOptionsDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[text() ='Composition Options']"));
		
		return element;
	}
	public static WebElement GetNumberOfDaysIncreaseValueIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text() = 'Number Of Days Valid Upon Purchase']//following::span[@title='Increase value']"));
		return element;
	}
	public static WebElement GetNumberOfDaysInputField(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//label[text() = 'Number Of Days Valid Upon Purchase']//following::span/span/input[1]"));
		return element;
	}
	public static void SelectFirstOptionFromCompositionDD(WebDriver driver)
	{
		driver.findElement(By.xpath("//ul[@id='ddlCompostionOptions_listbox']/li[2]")).click();
	}
	public static void setEndDate(WebDriver driver)
	  {
		  int d,m,y;
		  String endDate="";
		  Date date = new Date();
		  d = date.getDate();
		  m = date.getMonth()+1;
		  y = date.getYear()+1900+1;
		  endDate=String.valueOf(m)+"/"+String.valueOf(d)+"/"+String.valueOf(y);
		  GetTicketEndDate(driver).clear();
		  GetTicketEndDate(driver).sendKeys(endDate);
	  }
}
