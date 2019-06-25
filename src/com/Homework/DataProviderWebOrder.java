package com.Homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonMethods;

public class DataProviderWebOrder extends CommonMethods{
	@DataProvider()
	public Object[][] setData(){
		Object[][] data =new Object[5][9];
		data[0][0]="FamilyAlbum";  data[0][1]="100";	data[0][2]="John";  data[0][3]="testStreet"; data[0][4]="TestCity";  data[0][5]="TestState"; data[0][6]="34567"; data[0][7]="1234567890987654"; data[0][8]="11/19";
		data[1][0]="MyMoney";      data[1][1]="80";	    data[1][2]="Jack";  data[1][3]="StreetTest"; data[1][4]="CityTest";  data[1][5]="StateTest"; data[1][6]="24567"; data[1][7]="0987654321234567"; data[1][8]="11/20";
		data[2][0]="ScreenSaver";  data[2][1]="167";	data[2][2]="Jane";  data[2][3]="Test";       data[2][4]="testcity";  data[2][5]="testState"; data[2][6]="87654"; data[2][7]="9087657654345678"; data[2][8]="09/19";
		data[3][0]="MyMoney";      data[3][1]="200";	data[3][2]="Tom";   data[3][3]="Street";     data[3][4]="Test";      data[3][5]="Test";      data[3][6]="18767"; data[3][7]="5674654321234567"; data[3][8]="08/21";
		data[4][0]="ScreenSaver";  data[4][1]="300";	data[4][2]="Bob";   data[4][3]="TestSt";     data[4][4]="city";      data[4][5]="State";     data[4][6]="39854"; data[4][7]="7863657654345678"; data[4][8]="01/20";
		return data;
	}
	
	 String url="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx";
	 @BeforeClass(alwaysRun=true)
	  public void navigate() {
		  setUpDriver("chrome", url);
		}
	    
		@Test
		public void Login() {
			sendText(driver.findElement(By.cssSelector("input[id$='_username']")),"Tester");
			sendText(driver.findElement(By.cssSelector("input[id$='_password']")), "test");
			driver.findElement(By.cssSelector("input[id$='_button']")).click();
			Assert.assertEquals(driver.findElement(By.cssSelector("div.login_info")).isDisplayed(),true );
			System.out.println("succesfully login");
		}
		
	@Test(dataProvider="setData",dependsOnMethods="Login")
	public void addOrder(String product,String quantity,String name,String street,String city,String state,String zip,String cardNo,String Expiredate) {
	driver.findElement(By.xpath("//a[text()='Order']")).click();
	selectValueFromDD(driver.findElement(By.cssSelector("select[name*='ddlProduct']")), product);
	sendText(driver.findElement(By.cssSelector("input[id*='Quantity']")),quantity);
	driver.findElement(By.cssSelector("input[value='Calculate']")).click();
	sendText(driver.findElement(By.cssSelector("input[id$='txtName']")),name);
	sendText(driver.findElement(By.cssSelector("input[id$='_TextBox2']")),street);
	sendText(driver.findElement(By.cssSelector("input[id$='_TextBox3']")),city);
	sendText(driver.findElement(By.cssSelector("input[id$='_TextBox4']")),state);
	sendText(driver.findElement(By.cssSelector("input[id$='_TextBox5']")),zip);
	driver.findElement(By.cssSelector("input[id$='cardList_0']")).click();
	sendText(driver.findElement(By.cssSelector("input[id$='_TextBox6']")),cardNo);
	sendText(driver.findElement(By.cssSelector("input[id$='_TextBox1']")),Expiredate);
	driver.findElement(By.xpath("//a[text()='Process']")).click();
	driver.findElement(By.xpath("//a[text()='View all orders']")).click();
	
	}
}
