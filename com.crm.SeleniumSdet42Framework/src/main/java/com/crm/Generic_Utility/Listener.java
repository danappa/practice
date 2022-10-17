  package com.crm.Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	public void onTestFailure(ITestResult result) {
   
	String testname=result.getMethod().getMethodName();
	System.out.println(testname+"====execute and i am listener=====");
   
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
	File src=edriver.getScreenshotAs(OutputType.FILE);

try {
	File des=new File("./com.crm.SeleniumSdet42Framework/Screenshot/"+testname+".png");
	FileUtils.copyFile(src, des);
	
}catch(Exception e){
	e.printStackTrace();            // com.crm.SeleniumSdet42Framework
}
	
	
	
	}

}
