package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkflowBuilderPageElements {
	
private static WebElement element = null;
	
	public static WebElement GetSettings_Integrate_this_session_with(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select']"));		
		return element;
	}
	
	public static WebElement GetSettings_Integrate_this_session_with_Options(WebDriver driver, String option)
	{
		element =driver.findElement(By.xpath("//li[text()='"+option+"']"));		
		return element;
	}
	
	public static WebElement GetCopyWorkflowButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[text()='Copy Workflow']"));		
		return element;
	}
	

	public static WebElement getCopyWorkflowSessions_NameField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtWorkFlowName"));		
		return element;
	}
	

	public static WebElement getCopyWorkflowSessions_SaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSaveCopyWorkFlow"));		
		return element;
	}

}
