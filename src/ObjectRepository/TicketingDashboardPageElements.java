package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketingDashboardPageElements {
	private static WebElement element = null;
	public static WebElement GetTicketsTab(WebDriver driver)
	{		
		element =driver.findElement(By.linkText("Tickets"));
		return element;
	}
	public static WebElement GetTicketGroupsTab(WebDriver driver)
	{		
		element =driver.findElement(By.linkText("Ticket Groups"));
		return element;
	}
	public static WebElement GetTicketTypesTab(WebDriver driver)
	{		
		element =driver.findElement(By.linkText("Ticket Types"));
		return element;
	}
	public static WebElement GetTicketTemplatesTab(WebDriver driver)
	{		
		element =driver.findElement(By.linkText("Ticket Templates"));
		return element;
	}
	public static WebElement GetTicketTab_SelectOptionDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-1']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetTicketGroupTab_SelectOptionDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-2']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetTicketTypesTab_SelectOptionDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-3']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetTicketTemplatesTab_SelectOptionDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-4']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetTicketTemplatesTab_IDColumn(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='ticketTemplatesGrid']//a[text()='Template ID']"));
		return element;
	}
	public static WebElement GetTicketTemplatesTab_FirstRowTemplateNameColumn(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='ticketTemplatesGrid']//div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));		
		return element;
	}
	public static WebElement GetTicketTypesTab_TypeIDColumn(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='ticketTypesGrid']//a[text()='Type ID']"));
		return element;
	}
	public static WebElement GetTicketTypesTab_FirstRowTypeNameColumn(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='ticketTypesGrid']//div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));		
		return element;
	}
}
