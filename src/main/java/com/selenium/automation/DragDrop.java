package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {
WebDriver driver;	
	
	@Test
	public void dragAndDrop() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers\\chromedriver_83_0_4103_39.exe");
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement drag, drop;
		drag = driver.findElement(By.xpath("//*[@id='credit2']/a"));
		drop = driver.findElement(By.xpath("//*[@id='bank']/li"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(drop, drag).build().perform();
		Thread.sleep(2000);
	
		//code is right but it is not working,could be a problem with Selenium or browser drivers.
	}
}
