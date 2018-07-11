package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardKnoxDialogBox_OpenWebsite_Elements {
	private static WebElement element = null;
	public static String GetTransactionID(WebDriver driver)
	{
		String TransactionID = driver.findElement(By.id("popupWindow_wnd_title")).getText();
		TransactionID =TransactionID.substring(TransactionID.indexOf("#")+1, TransactionID.length());
		return TransactionID;
	}

}
