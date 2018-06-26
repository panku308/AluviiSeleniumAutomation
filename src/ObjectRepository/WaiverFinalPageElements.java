package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaiverFinalPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetSigningSuccessMsg(WebDriver driver)
	{
		//Success!   Thank you for signing! Your waiver(s) have been submitted.
	//	element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div[2]/div"));
		element =driver.findElement(By.xpath("//div[@class='row col-md-12 greenBox clsRow divMsg']/div"));
		return element;
	}
	public static WebElement GetMsgSendSuccessMsg(WebDriver driver)
	{
		//Successfully Sent!   A copy of your signed waiver(s) have been sent to your inbox.
		//element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div[4]/div"));
		element =driver.findElement(By.xpath("//div[@class='row col-md-12 blueBox clsRow divMsg']/div"));
		return element;
	}
}
