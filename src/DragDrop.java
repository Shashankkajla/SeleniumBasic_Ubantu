import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions; // actions import

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
     
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		//import org.openqa.selenium.interactions.Actions; // actions import

		/*Actions​(WebDriver driver)	: Constructor Summary
		 * 
		 * Actions dragAndDrop​(WebElement source, WebElement target) :
		A convenience method that performs click-and-hold at the location of the source element, moves 
		to the location of the target element, then releases the mouse.
		perform(), build() alwz. use with Actions Class
		
		*build() --> Ready to be performed
		*perform() --> performing the action
		*
		*/

		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable")))
		.moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		
		
	}

}
