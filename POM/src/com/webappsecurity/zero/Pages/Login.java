package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
//testing 02	
@FindBy(id="user_login")
private WebElement uName;

@FindBy(id="user_password")
private WebElement pass;

@FindBy(name="submit")
private WebElement submitBtn;

@FindBy(css="#login_form > div.alert.alert-error")
private WebElement invalidErrMsg;

public Login(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public void applicationLogin(String userName,String password) {
	uName.sendKeys(userName);
	pass.sendKeys(password);
	submitBtn.click();
}

public String invalidLogin() {
	String errMsg = invalidErrMsg.getText();
	return errMsg;
}
}
