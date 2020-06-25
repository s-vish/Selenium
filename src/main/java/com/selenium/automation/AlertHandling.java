package com.selenium.automation;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AlertHandling {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void init() {
		// this code will open the firefox browser and navigate to the site mentioned.
		try {
			System.setProperty("webdriver.gecko.driver", ".\\BrowserDrivers\\geckodriver-v0_26_0.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = "init")
	public void alertHandling() throws InterruptedException {
		/*
		 * This method will... 1. validate pop up is present or not 2. click on okay
		 * and verify same is getting printed. 3. click on cancel and verify same is
		 * getting printed.
		 */
		//Click on button
		Thread.sleep(2000);
		List<WebElement> webE = driver.findElements(By.xpath("//button[contains(text(),\"Click me!\")]"));
		webE.get(1).click();
		
		
		try {//verify alert present or not
			wait = new WebDriverWait(driver, 3);
			if(wait.until(ExpectedConditions.alertIsPresent())==null)
			{
				System.out.println("Alert is not present.");
			}
			else
			{	//accept the alert, read the text message and assert it.
				Alert alert = driver.switchTo().alert();
				alert.accept(); //this will click on OK
//				alert.dismiss(); //This will click on cancel
				driver.switchTo().activeElement();
				String actual = driver.findElement(By.id("confirm-demo")).getText();
				Assert.assertEquals(actual, "You pressed OK!"); // in case click on OK
//				Assert.assertEquals(actual, "You pressed Cancel!"); // in case click on cancel
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		//quit this driver along with every associated window.
		driver.quit();
	}

}
