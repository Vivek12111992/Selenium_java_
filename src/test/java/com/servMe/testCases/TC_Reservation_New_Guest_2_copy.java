package com.servMe.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.servMe.pageObjects.Add_Reservation;
import com.servMe.pageObjects.DashBoard;

public class TC_Reservation_New_Guest_2_copy extends Base {
	WebDriverWait wait;

	@Test
	public void tc_Reservation_New_Guest_002() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Browser opened and login to servme completed");
		/*
		 * LoginPage login = new LoginPage(driver);
		 * driver.get(readconfig.getApplicationURL());
		 * logger.info("ServMe url is opened");
		 * login.setUserName(readconfig.getusername());
		 * logger.info("Entered ServMe username");
		 * login.setPwd(readconfig.getpassword());
		 * logger.info("Entered ServMe password"); login.submit();
		 * logger.info("Clicked submit button");
		 */
		loginServMe(driver);
		Thread.sleep(20000);
		DashBoard dash = new DashBoard(driver);
		dash.selectvenue();
		dash.Entervenue();
		Thread.sleep(2000);
		dash.clickrsrv();
		logger.info("Reservation window opened");
		/*
		 * String addRsrv_currenturl = driver.getCurrentUrl(); String[]
		 * addRsrv_currenturl_1 = addRsrv_currenturl.split("/"); String
		 * addRsrv_currenturl__2 = addRsrv_currenturl_1[2]; if
		 * (addRsrv_currenturl__2.equals("add_reservation"));
		 */
		Add_Reservation addreserve = new Add_Reservation(driver);
		Thread.sleep(2000);
		addreserve.addnewguest();
		logger.info("Clicked Add new guest");
		Thread.sleep(5000);
		addNewGuestFunction(driver);
		/*
		 * AddNewGuest cguest = new AddNewGuest(driver); cguest.getFirstName();
		 * logger.info("Added first name"); Thread.sleep(1000); cguest.getlastName();
		 * logger.info("Added last name"); Thread.sleep(1000); cguest.selectcode();
		 * logger.info("Added std code"); Thread.sleep(3000); cguest.setPhone();
		 * logger.info("Added phone number"); cguest.setEmail();
		 * logger.info("Added email"); cguest.setSub(); logger.info("Clicked Create");
		 * Thread.sleep(10000);
		 */
		
		// captureScreenshot(driver, "tc_Reservation_New_Guest_002");
		/*
		 * String expected=cguest.Providefirstname()+cguest.Providelastname();
		 * Assert.assertEquals(driver.findElement(By.xpath("//header/span[1]")),
		 * expected);
		 */
		Add_Reservation areseve = new Add_Reservation(driver);

		areseve.setResFullName();
		String ResName = areseve.sendResFullName();
		logger.info("Reservation name added");
		areseve.setNote();
		logger.info("Note value added");
		areseve.clicksrc();
		logger.info("Clicked on source");
		areseve.cselectsrc();
		/*
		 * areseve.selectWaiter(); logger.info("Waiter added to the reservation");
		 * 
		 * Thread.sleep(3000);
		 */
		areseve.selectCurrentDate();
		logger.info("Date of the reservation added");
		Thread.sleep(3000);

		areseve.selectPartySize();
		logger.info("Party size of the reservation added");
		Thread.sleep(5000);
		areseve.selectTime();
		logger.info("Time of the reservation added");
		Thread.sleep(3000);
		areseve.sCharge();
		logger.info("charge of the reservation added disabled");
		areseve.clickrsrv();
		logger.info("Reservation added");
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
		captureScreenshot(driver, "tc_Reservation_New_Guest_002");
		//String abc=dash.getDashBoardReservatioName();
		//Assert.assertTrue(true);
		Assert.assertTrue((dash.getRSRVNotes()).contains("Test_Reservation_"));
		logger.info("Reservation name available on dashboard");

	}
}
