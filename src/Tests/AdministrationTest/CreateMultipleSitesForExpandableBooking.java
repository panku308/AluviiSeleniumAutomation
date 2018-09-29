package Tests.AdministrationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddSiteDialogBoxElements;
import ObjectRepository.AdministrationDashboardPageElements;
import ObjectRepository.DashboardPageElements;
import util.DriverManager;

public class CreateMultipleSitesForExpandableBooking {
	public static String MultipleSites[]=new String [3];
	public static int Capacity[] = new int[3];
	
	@Test
	public static void CreateMultipleSites() throws InterruptedException
	{
		
		for(int i=0;i<3;i++)
		{

			if(i<2)
			{
				Capacity[i]=25;
				
			}
			else
			{
				Capacity[i]=50;
				
			}
			MultipleSites[i] = "ExpandableSite_"+(i+1)+System.currentTimeMillis();
			WebDriver driver=DriverManager.getDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			DashboardPageElements.GetAdminstrationLink(driver).click();		  
			Thread.sleep(2000);
			AdministrationDashboardPageElements.getLocationTab(driver).click();
			Thread.sleep(4000);
			AdministrationDashboardPageElements.getLocation_subSiteTab(driver).click();
			Thread.sleep(2000);
			AdministrationDashboardPageElements.getSiteSelectOptionDropdownButton(driver).click();
			Thread.sleep(2000);
			AdministrationDashboardPageElements.getSiteSelectOptionDropdownList(driver, "Add Site").click();
			
			Thread.sleep(5000);
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.className("k-content-frame")));
			Thread.sleep(2000);
			
			
			String Description=MultipleSites[i];
			

			AddSiteDialogBoxElements.GetSiteNameField(driver).sendKeys(MultipleSites[i]);
			Thread.sleep(2000);
			AddSiteDialogBoxElements.getCapacity(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			
			AddSiteDialogBoxElements.setCapacity(driver).sendKeys(String.valueOf(Capacity[i]));
			Thread.sleep(2000);
			AddSiteDialogBoxElements.selectLocation(driver).click();
			Thread.sleep(2000);
			AddSiteDialogBoxElements.selectLocationOption(driver, CreateLocationDepartmentSiteTest.Location).click();
			Thread.sleep(2000);
			AddSiteDialogBoxElements.selectDepartment(driver).click();
			Thread.sleep(2000);
			AddSiteDialogBoxElements.selectDepartmentOption(driver, CreateLocationDepartmentSiteTest.Department).click();
			Thread.sleep(2000);
			AddSiteDialogBoxElements.GetDescriptionField(driver).sendKeys(Description);
			Thread.sleep(2000);
			AddSiteDialogBoxElements.GetSaveButton(driver).click();
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			AdministrationDashboardPageElements.getColumn_SiteName(driver).click();
			Thread.sleep(2000);
			CommonFunctions.filterTable(driver, MultipleSites[i]);			
			Assert.assertEquals(AdministrationDashboardPageElements.getSiteNameFilteredValue(driver).getText(), MultipleSites[i]);
		
		}
	}
	
}
