package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Dropdown {
	
	WebDriver driver;
	@Test
	public void dropDownHandling() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".//BrowserDrivers//chromedriver_83_0_4103_39.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//set values in dropdown 10 Dec 1990
		Select day, month, year;
		day= new Select(driver.findElement(By.name("birthday_day")));
		month=new Select(driver.findElement(By.id("month")));
		year=new Select(driver.findElement(By.xpath("//select[@title='Year' and @name='birthday_year']")));
		
		try {
		day.selectByValue("10");
		
		month.selectByIndex(12);
		
		year.selectByValue("1990");
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
//			System.out.println(e);
		}
	}
	@AfterTest
	public void teadDown()
	{
		driver.quit();
	}

}
