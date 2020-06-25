package com.selenium.automation;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class DefalutFirefoxProfile {

	WebDriver driver;
	@Test
	public void defaultFirefoxProfile()
	{
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver-v0_26_0.exe");
		 // Create object of ProfilesIni class
		ProfilesIni profileIni = new ProfilesIni();
		
		// Get the default session 
        FirefoxProfile profile = profileIni.getProfile("default");
        
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        
     // Pass the session/profile to FirefoxDriver 
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
		
	}
}
