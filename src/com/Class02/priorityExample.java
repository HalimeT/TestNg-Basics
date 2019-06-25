package com.Class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class priorityExample extends CommonMethods {
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
		boolean swagLabs = driver.findElement(By.xpath("//title[text()='Swag Labs']")).isDisplayed();
		if(swagLabs==true) {
			System.out.println("this is right title");
		}else {
			System.out.println("this is wrong title");
		}}
	
	
	@Test(priority=0)
		public void test() {
			sendText(driver.findElement(By.id("user-name")),"standard_user");
			sendText(driver.findElement(By.id("password")),"secret_sauce");
			driver.findElement(By.cssSelector(".btn_action")).click();
		}
	
	@Test(priority=1)
		public void mainpage() {
			String word=driver.findElement(By.cssSelector(".product_label")).getText();
			
			if(word.equals("Products")) {
				System.out.println("The word "+word+" is verified");
				}else {
					System.out.println("No verification is done");
				}
		}
	@AfterClass
	public void closePage(){
		
		driver.close();
	}
	
	
	
	}


