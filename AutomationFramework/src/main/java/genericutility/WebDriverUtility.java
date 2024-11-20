package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.reactivex.rxjava3.functions.Action;
/**
 * @author juhis
 */

public class WebDriverUtility {
	//public WebDriver driver;
	public Actions act;
	
	/*public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
		act=new Actions(driver);
	}*/
	
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to capture the size of the window
	 * @param driver
	 * @return
	 */

	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}
	/**
	 * This method is used to switch the driver control to window based on url
	 * @param driver
	 * @param url
	 */
	
	public void switchToWindow(WebDriver driver, String url)
	{
		//Step 1: Capture all the window ids
		Set<String> allWindowIds = driver.getWindowHandles();
		//Step 2: Navigate through all the windows
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(url)) {
				break;
			}
		}
		
		}
	/**
	 * This method is used to perform right click on web page
	 * @param driver
	 */
	
	public void rightClick(WebDriver driver) {
		//Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform click and hold operation on web Element
	 * @param driver
	 */
	
	public void clickAndHold(WebDriver driver, WebElement ele) {
		//Actions act=new Actions(driver);
		act.clickAndHold(ele).perform();
	}
	/**
	 * This method is used to perform mousehover operation on web Element
	 * @param driver
	 * @param element
	 */
	
	public void mouseHover(WebDriver driver, WebElement element) {
	//	Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform mousehover operation on web Element
	 * @param x
	 * @param y
	 */
	
	public void mouseHover(int x,int y) {
		//	Actions act=new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	/**
	 * This method is used to perform drag And drop operation on web Element
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebElement source,WebElement target) {
//		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
		
	}
	/**
	 * This method is used to perform doubleClick operation on web Element
	 * @param element
	 */
	
	public void doubleClick(WebElement element) {
//		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method is used to switch the driver control from window to frame
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the driver control from window to frame
	 * @param nameorId
	 */
	
	public void switchToFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This method is used to switch the driver control from window to frame
	 * @param element
	 */
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch back the driver control to main page
	 */
	
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to switch back the driver control to main page
	 * @param driver
	 */
	public void switchBackToMainPage1(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to select dropdown based on the index
	 * @param element
	 * @param index
	 */
	public void selectDropdownByIndex(WebElement element,int index) {
		Select ref=new Select(element);
		ref.selectByIndex(index);
	}
	/**
	 * This method is used to select dropdown based on the value
	 * @param element
	 * @param value
	 */
	
	public void selectDropdownByValue(WebElement element,String value) {
		Select ref=new Select(element);
		ref.selectByValue(value);
	}
	/**
	 * This method is used to select dropdown based on the visibleText
	 * @param element
	 * @param text
	 */
	
	public void selectDropdownByVisibleText(WebElement element,String text) {
		Select ref=new Select(element);
		ref.selectByVisibleText(text);
	}
	/**
	 * This method is used to switch control to alert popup
	 * @param driver
	 * @return
	 */
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertAndSendkeys(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	
	public void switchToAlertAndGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to perform click operation on webelement using JavascriprExecutor
	 * @param driver
	 * @param element
	 */
	
	public void toPerformClickAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * This method is used to perform scrolling operation using JavascriprExecutor
	 * @param driver
	 * @param x
	 * @param y
	 */
	
	public void toPerformScroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * This method is used to perform scrolling till bottom using JavascriprExecutor
	 * @param driver
	 * @param x
	 * @param y
	 */
	
	public void toPerformScrollTillBottom(WebDriver driver,int x) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(""+x+",document.body.scrollHeight()");
	}
	/**
	 * This method is used to take screenshot of web page
	 * @param driver
	 * @throws IOException
	 */
	
	public void toTakeScreenshot(WebDriver driver) throws IOException {
		String time = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots"+time+".png");
		FileHandler.copy(temp, dest);
	}
	
	
	
}
