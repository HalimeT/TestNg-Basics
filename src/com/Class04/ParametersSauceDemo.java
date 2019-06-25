package com.Class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class ParametersSauceDemo extends CommonMethods {
//	https://www.saucedemo.com/
//
//		TC 1: Saucedemo Username1(parameters - username and password)
//		Step 1: Open browser and navigate to Saucedemo
//		Step 2: Enter username standard_user and enter password secret_sauce and click login button
//		Step 3: Verify user successfully logged in
//
//		TC 2: Saucedemo Username2(parameters - username and password)
//		Step 1: Open browser and navigate to Saucedemo
//		Step 2: Enter username problem_user and enter password secret_sauce and click login button
//		Step 3: Verify user successfully logged in
//
//
//		Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file with parameters username and password .
//		Collapse
//
//
//
//		8:10 PM

	@Parameters({"url","browser"})
	@BeforeMethod(alwaysRun=true)
	public void setUp(String url, String browser) {
		setUpDriver(browser,url);
	}
	@Parameters({"user1","pass"})
	@Test
	public void UserName1(String user1,String pass) {
		
	   sendText(driver.findElement(By.id("user-name")),user1 );
	   sendText(driver.findElement(By.id("password")), pass);
	   driver.findElement(By.className("btn_action")).click();
	   Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	}
	@Parameters({"user2","pass"})
	@Test
	public void UserName2(String user2, String pass) {
		
		   sendText(driver.findElement(By.id("user-name")), user2);
		   sendText(driver.findElement(By.id("password")),pass );
		   driver.findElement(By.className("btn_action")).click();
		   Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
		}
	@AfterMethod(alwaysRun=true, groups="Smoke")
	public void tearDown() {
		driver.close();
	}
	}


