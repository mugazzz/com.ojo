package ojo.com.ojo;


import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import ojo.com.ojo.utilities.configFile;

public class RunFile extends configFile{

private int OutputType;

@BeforeTest
public void Open_Browser(){
	setUp();
}

@Test (priority = 0)
public void Login_Process() {
	 login_Process();
}

@Test (priority = 1)
public void Select_Services() throws InterruptedException {
	select_Services();
}

@Test (priority = 2)
public void Enter_Cus_Details() {
	Fill_Cus_Details();
}

@Test (priority = 3)
public void Order_Process() throws InterruptedException {
	order_Process();
}

//@AfterMethod
//public void tearDown(ITestResult result) {
//	if(ITestResult.FAILURE == result.getStatus())
//	{
//		try
//		{
//			//TakesScreenshot ts = (TakesScreenshot)driver;
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			Files.copy(source, new File("./Screenshot/"+result.getName()+".png"));
//			
//		}
//	}
//}

@AfterTest
public void CloseAll() {
	tearDown();
}
}
