package com.servMe.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

public LoginPage(WebDriver rdriver){
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(id="form_input_email")
WebElement userName;

@FindBy(id="form_input_password")
WebElement password;

@FindBy(id="login_btn")
WebElement loginBtn;

public void setUserName(String uName) {
	userName.sendKeys(uName);
}

public void setPwd(String pwd) {
	password.sendKeys(pwd);
}

public void submit() {
	loginBtn.click();
}




}
