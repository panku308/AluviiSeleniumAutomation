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
	
	public static WebElement getWorkflowTypeDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='ddlWorkflowTypes_listbox']"));		
		return element;
	}
	public static WebElement GetWorkflowTypeDDOption(WebDriver driver, String Option)
	{
		element =driver.findElement(By.xpath("//ul[@id='ddlWorkflowTypes_listbox']/li[text()='"+Option+"']"));		
		return element;
	}

	public static WebElement getWorkflowOptionDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='ddlWorkflowOptions_listbox']"));		
		return element;
	}
	public static WebElement getWorkflowOptionDDOption(WebDriver driver, String Option)
	{
		element =driver.findElement(By.xpath("//ul[@id='ddlWorkflowOptions_listbox']/li[text()='"+Option+"']"));		
		return element;
	}
	public static WebElement GetWaiverTeamplateDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='WaiverTemplateId_listbox']"));
		return element;
	}
	public static WebElement GetWaiverTeamplateDDOption(WebDriver driver, String Option)
	{
		element =driver.findElement(By.xpath("//ul[@id='WaiverTemplateId_listbox']/li[text()='"+Option+"']"));		
		return element;
	}
	public static WebElement GetReqAllGuestToSignRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverConfigurationId' and @value='0'] "));		
		return element;
	}
	public static WebElement GetReqAllGuestOverMinAgeRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverConfigurationId' and @value='1'] "));		
		return element;
	}
	public static WebElement GetOnlyReqOneGuestRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverConfigurationId' and @value='2'] "));		
		return element;
	}
	public static WebElement GetMinAgeOfSignField(WebDriver driver)
	{
	//	element =driver.findElement(By.xpath("//input[@class='k-formatted-value k-input' and @role='spinbutton'] "));
		element =driver.findElement(By.xpath("//div[@id='dvWorkflow']//table/tbody/tr[3]/td[2]/span/span/input[1]"));
		return element;
	}
	public static WebElement GetDisplayEmailOptOutDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='IsDisplayEmailOptOut_listbox']"));
		return element;
	}
	public static WebElement GetDisplayEmailOptOutDDOption(WebDriver driver, String Option)
	{
		element =driver.findElement(By.xpath("//ul[@id='IsDisplayEmailOptOut_listbox']/li[text()='"+Option+"']"));		
		return element;
	}
	
	public static WebElement GetReqSignerDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@aria-owns='IsRequireAcknowledgement_listbox']"));
		return element;
	}
	public static WebElement GetReqSignerDDOption(WebDriver driver, String Option)
	{
		element =driver.findElement(By.xpath("//ul[@id='IsRequireAcknowledgement_listbox']/li[text()='"+Option+"']"));		
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSave"));		
		return element;
	}
	public static WebElement GetSuccessMessage(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='divMsgProp']/h5"));		
		return element;
	}
	
}
