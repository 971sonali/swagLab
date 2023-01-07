package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage {
	
	@FindBy(css = "#user-name") private WebElement username;
	@FindBy (css = "#password") private WebElement password;
	@FindBy(css = "#login-button") private WebElement login;
	
	
	public SwagLabLoginPage(WebDriver driver){
		PageFactory.initElements(driver ,this);
	}
	
	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	
	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}
	

}
