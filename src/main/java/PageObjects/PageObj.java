package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pack123.BaseClass;

public class PageObj extends BaseClass {
	 
	By username=By.id("email");
	By passwrod=By.id("pass");
	By login=By.cssSelector("button._42ft._4jy0._6lth._4jy6._4jy1.selected._51sy");
	WebDriver driver;
	
	public PageObj(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement email() {
		return driver.findElement(username);
	}
	public WebElement PassWord() {
		return driver.findElement(passwrod);
	}
	public void clickLogin() {
		WebElement LogIn=driver.findElement(login);
		LogIn.click();
	}
	

}
