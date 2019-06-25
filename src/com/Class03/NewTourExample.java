package com.Class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import util.CommonMethods;

public class NewTourExample extends CommonMethods {

	@BeforeGroups({"Smoke","Regression"})
	public void setUP() {
		setUpDriver("chrome", "http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}

	@Test(groups ="Smoke")
	public void userInformation() {
		sendText(driver.findElement(By.cssSelector("input#email")),"usertest@gmail.com");
		sendText(driver.findElement(By.cssSelector("input[name='password']")), "passtest");
		sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "passtest");
		driver.findElement(By.cssSelector("input[name='register']")).click();
	}

	@Test(groups ="Regression")
	public void contactInformation() {
		sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "nameTest");	
		sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastnameTest");
		sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTest");
		sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
		driver.findElement(By.xpath("//input[@name='register']")).click();
	}

	@Test(groups ="Regression")
	public void mailingInformation() throws InterruptedException {
		sendText(driver.findElement(By.cssSelector("input[name='address']")), "addressTest");	
		sendText(driver.findElement(By.cssSelector("input[name='city']")), "cityTest");
		sendText(driver.findElement(By.cssSelector("input[name='state']")), "stateTest");
		sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "postalTest");
		driver.findElement(By.xpath("//input[@name='register']")).click();
	}

	@AfterGroups({"Smoke","Regression"})
	public void tearDown() {
		driver.close();
	}

}