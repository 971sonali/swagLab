package pom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabProductsPage {
	
	@FindBy(css = "#user-name") private WebElement username;
	@FindBy (css = "#password") private WebElement password;
	@FindBy(css = "#login-button") private WebElement login;
	@FindBy(xpath = "//button[text() = 'Add to cart']") private List<WebElement> addToCart;
	@FindBy(xpath = "//a[@class = 'shopping_cart_link']") private WebElement cartTrolly;

	@FindBy(xpath = "//a[text() = 'Twitter']") private WebElement twitter;
	@FindBy(xpath = "//a[text() = 'Facebook']") private WebElement facebook;
	@FindBy(xpath = "//a[text() = '//a[text() = 'LinkedIn']']") private WebElement LinkedIn;

	public SwagLabProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
	
	
	public void clickAddToCart() {
		int len = addToCart.size();
		for(int i=len-1;i>=0;i--) {
			addToCart.get(i).click();
		}
	}
	
	public void clickOnTrolly() {
		cartTrolly.click();
	}
	
	public void clickOnTwitter() {
		twitter.click();
	}
	
	public void switchChildBrowser(WebDriver driver) {
		Set <String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		while(i.hasNext()) {
			String handle = i.next();
			driver.switchTo().window(handle);
			String exTitle = "Sauce Labs (@saucelabs) / Twitter";
			String acTitle = driver.getTitle();
			if(exTitle.equals(acTitle)) {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
