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

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsCoinfirmation;
import com.webappsecurity.zero.Pages.TransferFundsVerify;

public class VerifyFundTransferTest {
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
public void verifyFundTransfer() {
	Login lp = new Login(driver);
	AccountSummary as = new AccountSummary(driver);
	TransferFunds tf = new TransferFunds(driver);
	TransferFundsVerify tfv = new TransferFundsVerify(driver);
	TransferFundsCoinfirmation tfc = new TransferFundsCoinfirmation(driver);
	
	lp.applicationLogin("username", "password");
	as.clickTransferFunds();
	tf.transferFunds("300", "First due");
	tfv.clickSubmit();
	String actualText = tfc.getConfText();
	String expectedText = "You successfully submitted your transaction.";
	Assert.assertEquals(actualText, expectedText);
}

@AfterTest
public void closeApplication() {
	driver.close();
}

}
