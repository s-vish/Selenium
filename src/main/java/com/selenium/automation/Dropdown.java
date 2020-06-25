package com.selenium.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		day.selectByIndex(10); // will select the value present at the index 10
		
		month.selectByValue("12"); // will select the value present at the value 12
		
		year.selectByVisibleText("1990"); //will look for the text provided and select it
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
//			System.out.println(e);
		}
		
		
		//print all the dropdown values from days dropdown
		List<WebElement> lst = day.getOptions();
		for (WebElement webElement : lst) {
			System.out.println(webElement.getText());
		}
	}
	@AfterTest
	public void teadDown()
	{
		driver.quit();
	}

}
