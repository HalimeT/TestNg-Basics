package com.Class05;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonMethods;

public class SauceDemo extends CommonMethods {
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https:/www.saucedemo.com/");
	}
	@DataProvider(name="sauceData")
    public Object [][] setUpData(){
		Object [][] data=new Object[4][2];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		
		data[1][0]="locked_out_user";
		data[1][1]="secret_sauce";
		
		data[2][0]="problem_user";
		data[2][1]="secret_sauce";
		
		data[3][0]="performance_glitch_user";
		data[3][1]="secret_sauce";
		return data;
	}
	@Test(dataProvider="sauceData")
	public void login() {
		
	}

}
