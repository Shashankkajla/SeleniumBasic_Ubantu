import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		
		
	System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("https://testproject.io/?gclid=EAIaIQobChMIvKqDvsGI7QIVwQ5yCh1jwQe2EAAYASAAEgIfWvD_BwE");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	// Mouse Over : Actions	moveToElement​(WebElement target) : return type is Actions class
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]")))
	.build().perform();
	driver.findElement(By.linkText("Remote Execution")).click();
	
	
	
	
		
	}
	
	
}
