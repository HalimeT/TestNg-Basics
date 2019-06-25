package com.Homework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
@DataProvider()
public Object[][] setData(){
	Object[][] data=new Object[2][3];
	data[0][0]="jonh";
	data[0][1]="Smith";
	data[0][2]=30;
	data[1][0]="Jane";
	data[1][1]="Smith";
	data[1][2]=27;
	
	return data;
}
@Test(dataProvider="setData")
public void details( String first, String last,int age) {
	System.out.println(age+" "+first+" "+last);
	
	
}

}
