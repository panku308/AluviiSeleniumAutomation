package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTicketGroupDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetTicketGroupName(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketGroupName"));
		return element;
	}
	public static WebElement GetInternalDescription(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//label[text()='Internal Description']/following::table//iframe"));
		return element;
	}
	public static WebElement GetExternalDescription(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//label[text()='External Description']/following::table//iframe"));
		return element;
	}
	public static WebElement GetTicketTypeDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[@aria-owns='TicketTypeId_listbox']"));
		return element;	
	}
	public static void SelectStaticTicketType(WebDriver driver)
	{		
		driver.findElement(By.xpath("//ul[@id='TicketTypeId_listbox']/li[1]")).click();		
	}
	public static void SelectDynamicTicketType(WebDriver driver,String TicketType)
	{		
		driver.findElement(By.xpath("//ul[@id='TicketTypeId_listbox']/li[text()='"+TicketType+"']")).click();		
	}
	public static WebElement GetNumberOfTickets(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//label[text()='Number of Tickets to Create']//following::span/span/input[1]"));		
		return element;
	}
	public static WebElement GetNumberOfTicketsIncreaseArrow(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//label[text()='Number of Tickets to Create']//following::span[@title='Increase value']"));		
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{		
		element =driver.findElement(By.id("Save"));		
		return element;
	}
	
}
