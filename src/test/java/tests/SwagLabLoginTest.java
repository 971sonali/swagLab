package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.parametrization;

@Listeners(utility.Listeners.class)

public class SwagLabLoginTest extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports = Reports.getReports();
	}
	
	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.openBrowser();
	}
	
	@Test
	public void SwagLoginTest() throws EncryptedDocumentException, IOException {
		test = reports.createTest("SwagLabloginTest"); //wihtout calling this create() we cnt login status.
		SwagLabLoginPage login = new SwagLabLoginPage(driver);
		String user = parametrization.getExcelData("Sheet1" , 0 , 1);
		String pass = parametrization.getExcelData("Sheet1", 1, 1);
		login.enterUsername(user);
		login.enterpassword(pass);
		login.clickLogin();
		String expecTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		
		//Assert.assertNotEquals(actualTitle , expecTitle);
	}
	
	@AfterMethod
	public void publishResult(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL , result.getName());
		}
		
		else {
			test.log(Status.SKIP, result.getName());
		}
		
	}
	
	@AfterTest
	public void flushReport() {
		reports.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
