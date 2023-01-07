package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("test start:" + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test success:" +result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed:" +result.getName());
		try {
			Screenshot.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped:" + result.getName());
	}
	

}
