package com.servMe.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.servMe.pageObjects.AddNewGuest;
import com.servMe.pageObjects.LoginPage;
import com.servMe.utilities.ReadConfig;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	public Logger logger;
	public WebDriverWait wait;
	public static RequestSpecification httpRequest;
	public static Response response;

	@BeforeClass
	public void setUp() throws Exception {
		String browserName = readconfig.getBrowserName();
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("Edge")) {

		} else if (browserName.equals("firefox")) {

		}
		logger = Logger.getLogger("ServMe Automation Staging");
		PropertyConfigurator.configure("log4j.properties");
		

		// return driver;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screeshots\\" + tname + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot captured");
	}
public void loginServMe(WebDriver driver) {
	LoginPage login = new LoginPage(driver);
	driver.get(readconfig.getApplicationURL());
	logger.info("ServMe url is opened");
	login.setUserName(readconfig.getusername());
	logger.info("Entered ServMe username");
	login.setPwd(readconfig.getpassword());
	logger.info("Entered ServMe password");
	login.submit();
	logger.info("Clicked submit button");
	
}

public void addNewGuestFunction(WebDriver driver) throws Exception {
	AddNewGuest cguest = new AddNewGuest(driver);
	cguest.getFirstName();
	logger.info("Added first name");
	Thread.sleep(1000);
	cguest.getlastName();
	logger.info("Added last name");
	Thread.sleep(1000);
	cguest.selectcode();
	logger.info("Added std code");
	Thread.sleep(3000);
	cguest.setPhone();
	logger.info("Added phone number");
	cguest.setEmail();
	logger.info("Added email");
	cguest.setSub();
	logger.info("Clicked Create");
	Thread.sleep(10000);
}

	public WebDriver ExplicitWait(WebElement element) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return driver;
	}
	
	public String RandomStringGenerator() {
		String str=RandomStringUtils.randomAlphabetic(9);
		return str;		
	}
	
	public String RandomNumGenerator() {
		String num=RandomStringUtils.randomNumeric(9);
		return num;		
	}
	
	public String ReturnDate() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		   LocalDateTime now = LocalDateTime.now();
		   return (dtf.format(now));
	}
}
