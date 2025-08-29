package genericUtilies;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public void sendKeys(WebDriver driver, WebElement element, String text) {
		new Actions(driver).sendKeys(text).perform();
	}

	/**
	 * This method will click and send the string value to input or textfield
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 */

	public void clickAndSendKeys(WebDriver driver, WebElement element, String text) {
		new Actions(driver).click(element).sendKeys(text).perform();
	}

	/**
	 * This method will move the cursor to particular element
	 * 
	 * @param driver
	 * @param element
	 */

	public void moveToElementAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element);
	}

	/**
	 * This method will move the cursor by offset
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */

	public void moveByOffset(WebDriver driver, WebElement element, int x, int y) {
		new Actions(driver).moveByOffset(x, y);
	}

	/**
	 * This method will scroll cursor to particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver, WebElement element) {
		new Actions(driver).scrollToElement(element);
	}

	/**
	 * This method will scroll the cursor by given amount(int x, int y)
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */

	public void scrollByAmount(WebDriver driver, WebElement element, int x, int y) {
		new Actions(driver).scrollByAmount(x, y);
	}

	/**
	 * This method will move cursor to frame based on index
	 * 
	 * @param driver
	 * @param index
	 */

	public void moveToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will move cursor to frame based on string value i.e window Handle
	 * 
	 * @param driver
	 * @param value
	 */

	public void moveToFrame(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}

	/**
	 * This method will move cursor to frame based on WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will move cursor to parent frame
	 * 
	 * @param driver
	 */

	public void moveTopParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will move cursor to top frame
	 * 
	 * @param driver
	 */

	public void moveToTopFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will accept the alert
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will dismiss the alert
	 * 
	 * @param driver
	 */

	public void declineAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will send keys alert
	 * 
	 * @param driver
	 * @param value
	 */

	public void sendKeysToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * This method will get text from the alert
	 * 
	 * @param driver
	 * @param value
	 */

	public void getTextFromAlert(WebDriver driver, String value) {
		driver.switchTo().alert().getText();
	}

	/**
	 * This method will be used to switch from one window to second window
	 * 
	 * @param driver
	 */

	public void switchWindow(WebDriver driver) {
		String winId = driver.getWindowHandle();
		Set<String> winIds = driver.getWindowHandles();
		for (String winHandle : winIds) {
			if (!(winId.equals(winHandle))) {
				driver.switchTo().window(winHandle);
				break;
			}
		}
	}

	/**
	 * This method will be used to switch from one window to differ window
	 * 
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindow(WebDriver driver, String expectedTitle) {
		Set<String> winIds = driver.getWindowHandles();
		for (String winId : winIds) {
			driver.switchTo().window(winId);
			String actualTitle = driver.getTitle();
			if (actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
				break;
			}
		}
	}
	public String captureScreenShort(WebDriver driver ,String ScreenShort) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dist = new File(".\\TakeSS\\"+ScreenShort+".png");
		org.openqa.selenium.io.FileHandler.copy(src, dist);
			 
		return dist.getAbsolutePath();// for extend Reports
	}
	}


