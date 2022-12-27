package com.servMe.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	WebDriver ldriver;

public DashBoard(WebDriver rdriver){
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(how = How.XPATH, using = "//span[contains(@normalize-space(),'Test_reservation_)]")
public WebElement DashBoardReservatioName;

/*
 * @FindBy(xpath="//*[@class='inline_top ng-scope'][2]") WebElement rsrv;
 */

public String getDashBoardReservatioName() {
	//return getDashBoardReservatioName.getAttribute("value");
	return DashBoardReservatioName.getAttribute("value");
}

@FindBy(how = How.XPATH, using = "//a[normalize-space()='+RSRV']")
WebElement rsrv;

/*
 * @FindBy(xpath="//*[@class='inline_top ng-scope'][2]") WebElement rsrv;
 */

public void clickrsrv() {
	rsrv.click();
}

//(//div[@class='column notes-col note editable_table_field text-center'])[1]
		@FindBy(how = How.XPATH, using = "(//div[@class='column notes-col note editable_table_field text-center'][1])")
		WebElement rsrvNotes;

		/*
		 * @FindBy(xpath="//*[@class='inline_top ng-scope'][2]") WebElement rsrv;
		 */

		public String getRSRVNotes() {
			return rsrvNotes.getAttribute("value");
		}
@FindBy(how = How.XPATH, using = "//*[@class='select2-selection__rendered']")
WebElement venue;

public void selectvenue() {
	venue.click();
}

@FindBy(how = How.XPATH, using = "//*[@class='select2-search__field']")
WebElement entervenue;

public void Entervenue() {
	entervenue.sendKeys("ABC RestoLounge");
	entervenue.sendKeys(Keys.ENTER);
}

}


