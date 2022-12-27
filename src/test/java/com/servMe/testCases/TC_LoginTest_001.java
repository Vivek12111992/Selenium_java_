package com.servMe.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.servMe.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base {
	@Test
	public void loginTest() throws IOException {
		logger.info("Browser opened");
		LoginPage login = new LoginPage(driver);
		driver.get(readconfig.getApplicationURL());
		logger.info("ServMe url is opened");
		login.setUserName(readconfig.getusername());
		logger.info("Entered ServMe username");
		login.setPwd(readconfig.getpassword());
		logger.info("Entered ServMe password");
		login.submit();
		logger.info("Clicked submit button");
		if(driver.getTitle().equals("serVme Web App")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
		}

	}

}
