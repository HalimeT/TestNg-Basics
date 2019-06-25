package com.Class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class orangeTitleLogin extends CommonMethods {
	@BeforeMethod
	public void setUP(){
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");	
	}
	@Test(priority=0)
	public void titleVerification(){
	String title=driver.getTitle();	
	
	if(title.equalsIgnoreCase("orangehrm")) {
		System.out.println("this is right title");
	}else {
		System.out.println("this is wrong title");
	}}
    @Test(priority=1)
	public void login(){
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
