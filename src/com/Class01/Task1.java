package com.Class01;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Task1 extends CommonMethods{

//	TC 1: Swag Lab Title and Login Verification
//	@BeforeMethod should contain navigation to the URL and title verification
//	https://www.saucedemo.com/
//	@Test should contain steps to login and “Product” word verification
//	@AfterMethod should logOut from the application and close the browser
	
	@BeforeMethod
	public void setUp() {
		String url="https://www.saucedemo.com/";
		setUpDriver("chrome",url);
	}
	@Test
	public void test() {
		sendText(driver.findElement(By.id("user-name")),"standard_user");
		sendText(driver.findElement(By.id("password")),"secret_sauce");
		driver.findElement(By.cssSelector(".btn_action")).click();
		String word=driver.findElement(By.cssSelector(".product_label")).getText();
		
		if(word.equalsIgnoreCase("Products")) {
			System.out.println("The word "+word+" is verified");
			}else {
				System.out.println("No verification is done");
			}
	}
	@AfterMethod
	public void logOut() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
		
	}
	
	
	

}
