package Tests.CreateEventManagementTest;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import GlobalFiles.CommonFunctions;
import ObjectRepository.AddPriceRuleDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EventManagementPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreatePriceRuleTest extends TestSetup {

public static String priceRuleName="";
public static String PriceRule_TypeDeposit="";
public static String PriceRule_TypeBasePrice="";
	@Test
	public static void createPriceRule_TypeDeposit()throws Exception
	{
		
			
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Price Rules").click();
			Thread.sleep(2000);
			EventManagementPageElements.getPriceRulesSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getPriceRulesSelectOptionDropdownList(driver, "Add Price Rule").click();
			Thread.sleep(2000);
			
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			PriceRule_TypeDeposit = "Deposit_"+System.currentTimeMillis();
			String displayAndDesc = PriceRule_TypeDeposit;
			
			
			AddPriceRuleDialogBoxElements.getPriceRuleNameField(driver).sendKeys(PriceRule_TypeDeposit);
			AddPriceRuleDialogBoxElements.getDisplayNameField(driver).sendKeys(displayAndDesc);
			AddPriceRuleDialogBoxElements.getRuleTypeButton(driver).click();
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.selectRuleType(driver, "Deposit").click();
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getPercentage(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setPercentage(driver).sendKeys("50");
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getDescriptionField(driver).sendKeys(displayAndDesc);
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getEventPortalCheckbox(driver).click();
			AddPriceRuleDialogBoxElements.getEmployeePortalCheckbox(driver).click();
			AddPriceRuleDialogBoxElements.getSaveButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PriceRuleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, PriceRule_TypeDeposit);
			
			Assert.assertEquals(EventManagementPageElements.getPriceRuleNameFilteredValue(driver).getText(), PriceRule_TypeDeposit);
			
		
			CommonFunctions.map.put("PriceRule_TypeDeposit", PriceRule_TypeDeposit);
	}
	@Test
	public static void createPriceRule_TypeBasePrice()throws Exception
	{
		
			
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			DashboardPageElements.GetEventManagementLink(driver).click();		
			
			EventManagementPageElements.getTab(driver, "Price Rules").click();
			Thread.sleep(2000);
			EventManagementPageElements.getPriceRulesSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			EventManagementPageElements.getPriceRulesSelectOptionDropdownList(driver, "Add Price Rule").click();
			Thread.sleep(2000);
			
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			PriceRule_TypeBasePrice = "BasePrice_"+System.currentTimeMillis();
			String displayAndDesc = PriceRule_TypeBasePrice;
			
			
			AddPriceRuleDialogBoxElements.getPriceRuleNameField(driver).sendKeys(PriceRule_TypeBasePrice);
			AddPriceRuleDialogBoxElements.getDisplayNameField(driver).sendKeys(displayAndDesc);
			AddPriceRuleDialogBoxElements.getRuleTypeButton(driver).click();
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.selectRuleType(driver, "Base Price").click();
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getBaseAmount(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setBaseAmount(driver).sendKeys("375");
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getDescriptionField(driver).sendKeys(displayAndDesc);
			
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getUpperLimit(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setUpperLimit(driver).sendKeys("30");
			Thread.sleep(2000);
			
			AddPriceRuleDialogBoxElements.getAddRuleButton(driver).click();
			Thread.sleep(3000);
			
			AddPriceRuleDialogBoxElements.getLowerLimit2(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setLowerLimit2(driver).sendKeys("31");
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getUpperLimit2(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setUpperLimit2(driver).sendKeys("40");
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getVariableAmount2(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setVariableAmount2(driver).sendKeys("5");
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.getSaveButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			EventManagementPageElements.getColumn_PriceRuleName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, PriceRule_TypeBasePrice);
			
			Assert.assertEquals(EventManagementPageElements.getPriceRuleNameFilteredValue(driver).getText(), PriceRule_TypeBasePrice);
			
		
			CommonFunctions.map.put("PriceRule_TypeBasePrice", PriceRule_TypeBasePrice);
	}

	}
