package com.Homework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import util.CommonMethods;

public class Task extends CommonMethods{

//	3: Edit user one  and update user one’s State,
//	assert the new updated State is displayed and save the changes. 
//	Step 4: Verify that user two name appears within the table  
//	Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save the changes.
//	TC 3: WebOrder verifying Users( )        
//	Step 1 : Assert Both User one and User Two are displayed
//	Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application. 
	//The creation of users two should depend on the creation of users one.
	//The validation both users should depend on the creation of both users.
	//Create xml file and share a screenshot of the test.
 

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
	
	@Test(dependsOnMethods="Login")
	public void WebOrder() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Order']")).click();
		selectValueFromDD(driver.findElement(By.cssSelector("select[name*='ddlProduct']")), "FamilyAlbum");
		sendText(driver.findElement(By.cssSelector("input[id*='Quantity']")),"100");
		driver.findElement(By.cssSelector("input[value='Calculate']")).click();
		sendText(driver.findElement(By.cssSelector("input[id$='txtName']")),"John");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox2']")),"testStreet");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox3']")),"testCity");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox4']")),"testState");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox5']")),"74256");
		driver.findElement(By.cssSelector("input[id$='cardList_0']")).click();
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox6']")),"7425600001234567");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox1']")),"11/19");
		driver.findElement(By.xpath("//a[text()='Process']")).click();
		
		selectValueFromDD(driver.findElement(By.cssSelector("select[name*='ddlProduct']")),"ScreenSaver" );
		sendText(driver.findElement(By.cssSelector("input[id*='Quantity']")),"90");
		driver.findElement(By.cssSelector("input[value='Calculate']")).click();
		sendText(driver.findElement(By.cssSelector("input[id$='txtName']")),"Jane");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox2']")),"test1Street");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox3']")),"test1City");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox4']")),"test1State");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox5']")),"75000");
		driver.findElement(By.cssSelector("input[id$='cardList_1']")).click();
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox6']")),"7425600007654321");
		sendText(driver.findElement(By.cssSelector("input[id$='_TextBox1']")),"09/19");
		driver.findElement(By.xpath("//a[text()='Process']")).click();
		driver.findElement(By.xpath("//a[text()='View all orders']")).click();
		List<WebElement>names=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
		
		for(WebElement name:names) {
			String actual=name.getText();
		     if(actual.equals("John")) {
		    	 System.out.println("userone's name appears within the table");
		    	 break;
		     }
			}
		
	}
	
	
}
