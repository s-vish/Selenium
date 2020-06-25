package com.selenium.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	
	WebDriver driver;
	
	@Test
	public void mouseHover() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./BrowserDrivers/chromedriver_83_0_4103_39.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		
		driver.get("https://www.naukri.com/");
		
		WebElement textBox= driver.findElement(By.id("qsb-keyword-sugg"));
		textBox.clear();
		textBox.sendKeys("automation");
		//print all suggestions displayed.
		/*
		 * Thread.sleep(2000); List<WebElement>list =
		 * driver.findElements(By.xpath("//div[@id='sugDrp_qsb-keyword-sugg']/ul/li"));
		 * for(int i=0;i<list.size();i++) { System.out.println(i+1
		 * +" : "+list.get(i).getText()); }
		 */
		
		
		Thread.sleep(2000);
		WebElement suggestions = driver.findElement(By.xpath("//div[@id=\"sugDrp_qsb-keyword-sugg\"]/ul/li[2]"));
		act.moveToElement(suggestions).build().perform(); //this will move mouse over the element specified.
		Thread.sleep(2000);
		act.click(suggestions).build().perform(); //this will click the element.
	}
	

}
