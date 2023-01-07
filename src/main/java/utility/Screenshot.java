package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot extends BaseClass{
	
	public static void getScreenshot(String name) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\eclipse workspace\\Swag_Lab_Trail\\Screenshot\\+name+.png");
		
		FileHandler.copy(source, destination);
		
	}

}
