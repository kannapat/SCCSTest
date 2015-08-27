package com.membertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestLogin1 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) throws Exception {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:/Tester/chromedriver.exe");
				driver = new ChromeDriver();
			
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"D:/Tester/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

	    driver.manage().window().maximize();
	    baseUrl = "http://alpha.fsct.local/";
	  	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	  }

	  @Test
	  public void login_test() throws Exception {
	    driver.get(baseUrl + "/router/login/loginPrivate.jsp?");
	    driver.findElement(By.id("loginName")).clear();
	    driver.findElement(By.id("loginName")).sendKeys("kannapat");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.id("btnLogin")).click();
	    assertEquals("งานทะเบียนสมาชิก", driver.findElement(By.cssSelector("div.application-title")).getText());
	    assertEquals("| ใบสมัครสมาชิก | Progress Rollbase", driver.getTitle());
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	  

}
