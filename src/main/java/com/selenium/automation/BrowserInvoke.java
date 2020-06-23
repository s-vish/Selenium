package com.selenium.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BrowserInvoke {

	WebDriver driver;

	@Test
	public void iE() {
		/*
		 * Make sure in IE, zoom level is set to 100%, otherwise it will throw an error
		 */

		try {
			System.setProperty("webdriver.ie.driver", ".\\BrowserDrivers\\IEDriverServer_Win32_3.8.0.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void chromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers\\chromedriver_83_0_4103_39.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void firefoxBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver", ".\\BrowserDrivers\\geckodriver-v0_26_0.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			driver.get("https://www.google.co.in");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
