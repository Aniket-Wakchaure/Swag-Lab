package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class LoginPage {
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userName;
	@FindBy(xpath = "//input[@name='password']") private WebElement password;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement login;
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return login;
	}

	

}
