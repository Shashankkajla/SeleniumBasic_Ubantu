import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GenericDoubleClick {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
   //WebElement doubleCheck = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
	WebElement right_click = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		
		//iDoubleCheck(driver, doubleCheck);
	      irightClick(driver, right_click);
	}	
	// Double Click 
	public static void iDoubleCheck(WebDriver driver, WebElement check)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(check).build().perform();
		
	}
	// RightClick
	public static void irightClick(WebDriver driver, WebElement check_right)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(check_right).build().perform();
	}
}