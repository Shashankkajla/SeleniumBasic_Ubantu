import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
//import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraSpecialLocators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//By All, ByChained, ByIdorName inside By class 
		//callByAll class Object --->>
		/*Please find either of then m for the single field, If By.id is not available check By.name, if nameis
		also not available check By.xpath(xpathExpression)*/
		driver.findElement(new ByAll(By.id("email"), By.name("email"), 
				By.xpath("//input[@name='email']"))).sendKeys("Hello");
		
		// Not use implicit wait here coz 5 sec give time for each locator
		
		driver.findElement(new ByIdOrName("pass")).sendKeys("World");
		// either you pass id or name for the attribute value
		
		//driver.findElement(new ByChained())
		// Its a class where we have pass parent to child relationships using locators & attributes 
		
	}

}
