package com.servMe.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.servMe.testCases.Base;

public class Add_Reservation extends Base{
	WebDriver ldriver;
	String changingguest = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public Add_Reservation(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@class='image_sprite_24 image_sprite_24_guest_icon hidden-print']")
	WebElement addnewuserbutton;
	
	public void addnewguest() {
		ExplicitWait(addnewuserbutton);
		addnewuserbutton.click();
	}
	
	@FindBy(xpath="//div[@class='full_name_parent']//input[@name='reservation_full_name']")
	public static WebElement resFullName;
	////input[@name='reservation_full_name']
	public void setResFullName() {
		resFullName.click();
		resFullName.sendKeys("Test_Reservation_"+changingguest);
	}
	
	public String sendResFullName() {
		return resFullName.getAttribute("value");
	}
	
	@FindBy(xpath="//*[@placeholder='Add your notes']")
	WebElement setNote;
	
	public void setNote() {
		setNote.click();
		setNote.sendKeys("Test_Note_"+changingguest);
	}
	
	/*@FindBy(xpath="//div[@ng-if='enable_waiter_field == 1']/div[1]")
	WebElement waiterDropdown;
	
	public void clickWaiterDropdown() {
		waiterDropdown.click();
	}
	
	@FindBy(xpath="//*[@ng-repeat='waiter in waiters.array'][2]")
	WebElement waiter;
	
	public void selectWaiter() {
		waiter.sendKeys(Keys.ENTER);
	}
	*/
	
	
	@FindBy(xpath="//*[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")
	WebElement currentDate;
	
	public void selectCurrentDate() {
		currentDate.click();
	}
	
	@FindBy(xpath="//div[@class='guest_count_container col-md-3 pull-left']/label[2]")
	WebElement partySize;
	
	public void selectPartySize() {
		partySize.click();
	}
	

	  @FindBy(xpath="(//label[normalize-space()='20:45'])[1]") 
	  WebElement time_Tc_2;
	
	 //input[contains(@value,'20:30:00 GMT+0400 (Gulf Standard Time)')]
	
	public void selectTime() {
		
		/*
		 * Date dt = new Date(); SimpleDateFormat dateFormat = new
		 * SimpleDateFormat("kk:mm:ss"); String
		 * time=(dateFormat.format(dt).split(":"))[0]; int i=Integer.parseInt(time);
		 * return (i+1);
		 */
		ExplicitWait(time_Tc_2);
		time_Tc_2.click();
		
	}
	
	@FindBy(xpath="//*[@class='slider round']")
	WebElement charge;
	
	public void sCharge() {
		charge.click();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@value='+ RSRV']")
	WebElement rsrv;

	public void clickrsrv() {
		rsrv.click();
	}
	
	@FindBy(how = How.XPATH, using = "//div[text()='Select a source']")
	WebElement src;

	public void clicksrc() {
		src.click();
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Citibank']")
	WebElement selectsrc;

	public void cselectsrc() {
		ExplicitWait(selectsrc);
		selectsrc.click();
	}
	
	
}
