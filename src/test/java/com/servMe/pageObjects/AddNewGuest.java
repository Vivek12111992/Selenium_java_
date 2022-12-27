package com.servMe.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.servMe.testCases.Base;

public class AddNewGuest extends Base {
	WebDriver ldriver;
	Actions action;

	String changingguest = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public AddNewGuest(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.ID, using = "first_name")
	WebElement firstname;

	public String Providefirstname() {
		return firstname.getText();

	}

	public void getFirstName() {
		firstname.sendKeys("New_Guest_");
	}

	@FindBy(how = How.ID, using = "last_name")
	WebElement lastname;

	public String Providelastname() {
		return lastname.getText();

	}
	public void getlastName() {
		lastname.click();
		lastname.sendKeys(changingguest);
	}

	@FindBy(how = How.XPATH, using = "//*[@ng-blur='blur_isd()']")
	WebElement code;

	public void selectcode() throws Exception {
		code.click();
		code.sendKeys(Keys.BACK_SPACE);
		code.sendKeys(Keys.BACK_SPACE);
		code.sendKeys(Keys.BACK_SPACE);
		// sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		code.sendKeys("91");
		Thread.sleep(7000);
		/*
		 * Actions action=new Actions(ldriver);
		 * action.keyDown(code,Keys.ARROW_UP).keyUp(code,Keys.ARROW_UP);
		 * action.keyDown(code,Keys.ARROW_UP).keyUp(code,Keys.ARROW_UP); action.click();
		 */
		code.sendKeys(Keys.ARROW_DOWN);
		code.sendKeys(Keys.ARROW_DOWN);
		code.sendKeys(Keys.ARROW_DOWN);
		code.sendKeys(Keys.ENTER);
	}

	@FindBy(how = How.XPATH, using = "//*[@placeholder='Phone']")
	WebElement phone;

	public void setPhone() throws Exception {
		phone.sendKeys("9"+RandomNumGenerator());
	}

	@FindBy(how = How.ID, using = "email")
	WebElement email;

	public void setEmail() throws Exception {

		email.sendKeys("testauto@gmail.com");
	}

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	WebElement subm;

	public void setSub() throws Exception {

		subm.click();
	}

}
