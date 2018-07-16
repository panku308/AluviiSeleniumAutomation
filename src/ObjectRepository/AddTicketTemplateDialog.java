package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTicketTemplateDialog {
	private static WebElement element = null;
	public static WebElement GetTicketTemplateNameField(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketTemplateName"));
		return element;
	}
	public static WebElement GetPrintFormatDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//span[@aria-owns='TicketFormat_listbox']//span[text()='PDF']"));
		return element;
	}
	public static WebElement GetNextButton(WebDriver driver)
	{		
		element =driver.findElement(By.id("nextButton"));
		return element;
	}
	public static WebElement GetDataPlaceHolderDD(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='ticketTemplateBody1']//span[@aria-owns='ticketPlaceHolder_listbox']//span/span[1]"));		
		return element;
	}
	public static WebElement GetPDFTicketBodyField(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("//div[@id='ticketTemplateBody1']//iframe"));
		return element;
	}
	public static WebElement GetBOCATicketBodyField(WebDriver driver)
	{		
		element =driver.findElement(By.id("TicketBody"));
		return element;
	}
	public static WebElement GetViewPDFButton(WebDriver driver)
	{		
		element =driver.findElement(By.id("btnViewPdf"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{		
		element =driver.findElement(By.id("saveButton"));
		return element;
	}
	
}
