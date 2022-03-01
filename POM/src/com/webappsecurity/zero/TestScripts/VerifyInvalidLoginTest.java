package com.webappsecurity.zero.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.Login;

public class VerifyInvalidLoginTest {
	WebDriver driver;	
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

		driver = new ChromeDriver(capability);
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyInvalidLogin() {
		Login lp = new Login(driver);
		
		lp.applicationLogin("user111", "pass111");
		String actualMsg = lp.invalidLogin();
		String expectedMsg = "Login and/or password are wrong.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}
		
	@AfterTest
	public void closeApplication() {
			driver.close();
	}

}
