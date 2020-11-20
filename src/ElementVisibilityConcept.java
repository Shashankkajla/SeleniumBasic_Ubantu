import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	 /*For Validating & UI Testing 
	 isDisplayed() --> Check the presence of all kind of WebElement is available or not in Web Page.
	 return type --> boolean  */ 
		
     boolean bVal = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']")).isDisplayed();		
	 System.out.println(bVal);
	
	 /*isEnabled() : used to verify WebElement is enabled or disabled on WebPage, primary used with buttons.
	 Terms&Condition , checkBox etc.*/
	 
	 boolean bVal1 = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
	 System.out.println(bVal1);
	
	 /*isSelected() --> is check wheather the element is selected or not , used with, 
	 radio btn, checkbox, select dropdown*/
	 
	 //driver.findElement(By.xpath("//button[@type='submit']")).click();
	 boolean bVal3 = driver.findElement(By.xpath("//button[@type='submit']")).isSelected();
     System.out.println(bVal3);
	 
	 
	}

}
