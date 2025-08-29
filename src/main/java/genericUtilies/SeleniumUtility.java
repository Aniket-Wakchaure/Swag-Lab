package genericUtilies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtility {
	/*
	 * @author Aniket
	 * this method will click on the req element
	 * By Verifying the Visible Text
	 * For Dynamic Element
	 */
	
	public void findreqElement(WebDriver driver,String reqElementtext) {
		WebElement e = driver.findElement(By.xpath("//div[.='" + reqElementtext + "']"));
		e.click();	
		}
	

	}


