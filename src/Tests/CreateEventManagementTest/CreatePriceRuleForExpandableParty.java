package Tests.CreateEventManagementTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddPriceRuleDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.EventManagementPageElements;
import util.DriverManager;

public class CreatePriceRuleForExpandableParty {

	public static String ExpandableBasePriceRuleName[]=new String[3];
	public static String priceRuleName="";
	public static String PriceRule_TypeDeposit="";
	public static String PriceRule_TypeBasePrice="";
	public static int BasePriceRule_LowerLimit1[] = new int[3];
	public static int BasePriceRule_LowerLimit2[] = new int[3];
	public static int BasePriceRule_UpperLimit1[] = new int[3];
	public static int BasePriceRule_UpperLimit2[] = new int[3];
	public static int BasePriceRule_VariablePay2[] = new int[3];
	public static int BasePriceRule_BaseAmount[] = new int[3];
	
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
			AddPriceRuleDialogBoxElements.GetMinDepositField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			AddPriceRuleDialogBoxElements.setMinDepositField(driver).sendKeys("100");
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
				
	}
	@Test
	public static void createPriceRule_TypeBasePrice()throws Exception
	{
		
			
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			for(int i=0;i<3;i++)
			{
				if(i<2)
				{
					BasePriceRule_LowerLimit1[i]=1;
					BasePriceRule_UpperLimit1[i]=15;
					BasePriceRule_LowerLimit2[i]=16;
					BasePriceRule_UpperLimit2[i]=25;
					BasePriceRule_VariablePay2[i]=8;
					BasePriceRule_BaseAmount[i]=250;
				}
				else
				{
					BasePriceRule_LowerLimit1[i]=1;
					BasePriceRule_UpperLimit1[i]=25;
					BasePriceRule_LowerLimit2[i]=26;
					BasePriceRule_UpperLimit2[i]=50;
					BasePriceRule_VariablePay2[i]=8;
					BasePriceRule_BaseAmount[i]=500;
				}
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
				
				ExpandableBasePriceRuleName[i] = "ExpandableBasePriceRoom_"+i+"_"+System.currentTimeMillis();
				String displayAndDesc = ExpandableBasePriceRuleName[i];
				
				
				AddPriceRuleDialogBoxElements.getPriceRuleNameField(driver).sendKeys(ExpandableBasePriceRuleName[i]);
				AddPriceRuleDialogBoxElements.getDisplayNameField(driver).sendKeys(displayAndDesc);
				AddPriceRuleDialogBoxElements.getRuleTypeButton(driver).click();
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.selectRuleType(driver, "Base Price").click();
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.getBaseAmount(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.setBaseAmount(driver).sendKeys(String.valueOf(BasePriceRule_BaseAmount[i]));
				
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.getDescriptionField(driver).sendKeys(displayAndDesc);
				
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.getUpperLimit(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.setUpperLimit(driver).sendKeys(String.valueOf(BasePriceRule_UpperLimit1[i]));
				Thread.sleep(2000);
				
				AddPriceRuleDialogBoxElements.getAddRuleButton(driver).click();
				Thread.sleep(3000);
				
				AddPriceRuleDialogBoxElements.getLowerLimit2(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.setLowerLimit2(driver).sendKeys(String.valueOf(BasePriceRule_LowerLimit2[i]));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.getUpperLimit2(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.setUpperLimit2(driver).sendKeys(String.valueOf(BasePriceRule_UpperLimit2[i]));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.getVariableAmount2(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.setVariableAmount2(driver).sendKeys(String.valueOf(BasePriceRule_VariablePay2[i]));
				Thread.sleep(2000);
				AddPriceRuleDialogBoxElements.getSaveButton(driver).click();
				
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				EventManagementPageElements.getColumn_PriceRuleName(driver).click();
				Thread.sleep(2000);
				CommonFunctions.filterTable(driver, PriceRule_TypeBasePrice);
				
				Assert.assertEquals(EventManagementPageElements.getPriceRuleNameFilteredValue(driver).getText(), PriceRule_TypeBasePrice);
								
			}
			
	}

	
	
}
