package genericUtilies;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepo.LoginPage;
import objectRepo.ProductPage;

public class BaseClass {
	public FileUtility fu=new FileUtility();
	public WebDriver wd;
	@BeforeSuite
	public void dataBaseConnection() {
		System.out.println("==========DB CONNECTED===============");
	}
	
	@BeforeClass
	public void bcConfiguration() throws IOException {
	
		
		String Br = fu.readDataFromPropertyFile("browser");
		String URL= fu.readDataFromPropertyFile("url");

		
		if(Br.equals("chrome")) {
		wd=new ChromeDriver();
		}
		if(Br.equals("Edge")) {
			wd=new EdgeDriver();
			}
		else {
			wd=new EdgeDriver();
		}
		wd.manage().window().maximize();
		wd.manage().timeouts().getImplicitWaitTimeout();
		wd.get(URL);
		System.out.println("===============App Launched=============");
			
	}
	@BeforeMethod
  public void appLogin() throws IOException {
	 String un = fu.readDataFromPropertyFile("username");
	
	 String pass = fu.readDataFromPropertyFile("password");
	 LoginPage ln= new LoginPage(wd);
	 ln.getUserName().sendKeys(un);;
	
	 ln.getPassword().sendKeys(pass);
	 ln.getLoginbtn().click();
	 System.out.println("==============Log In Successfull=========");
  }
	
	@AfterMethod
	public void logOut() {
		ProductPage p=new ProductPage(wd);
		p.getMenueBtn().click();
		p.getLogOutBtn().click();
		System.out.println("===================log out success============");
	}
	
	@AfterClass
	public void closeBr() {
		wd.close();
		System.out.println("=============browser Closed=============");
	}
	@AfterSuite
	public void closeDb() {
		System.out.println("==========DB closed============");
	}
	

}
