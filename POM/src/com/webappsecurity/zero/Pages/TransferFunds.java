package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {
@FindBy(id="tf_fromAccountId")
private WebElement fromAccDD;

@FindBy(id="tf_toAccountId")
private WebElement toAccDD;

@FindBy(id="tf_amount")
private WebElement transferAmt;

@FindBy(id="tf_description")
private WebElement transferDesc;

@FindBy(id="btn_submit")
private WebElement submitBtn;

public TransferFunds(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void transferFunds(String Amount, String Description) {
	Select dd1 = new Select(fromAccDD);
	dd1.selectByIndex(2);
	
	Select dd2 = new Select(toAccDD);
	dd2.selectByIndex(3);
	
	transferAmt.sendKeys(Amount);
	
	transferDesc.sendKeys(Description);
	
	submitBtn.click();
}

}
