import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImpBasic {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/advanced_search");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// To get the any tag attribute value , we use getAttribute()
		String attribute_val = driver.findElement(By.xpath("//input[@id='xX4UFf']")).getAttribute("type");
		System.out.println(attribute_val);
		String attribute_val1 = driver.findElement(By.xpath("//input[@id='xX4UFf']")).getAttribute("class");
		System.out.println(attribute_val1);

    // To get BackGroundColor : getCssValue()
   String color = driver.findElement(By.id("xX4UFf"))
  .getCssValue("background-color"); // used in buttons imgs to know color, rgba(255, 255, 255, 1)
   System.out.println(color);
      // Get the Text 
      driver.findElement(By.id("xX4UFf")).sendKeys("hello");
      String textIs = driver.findElement(By.id("xX4UFf")).getText();
      System.out.println(textIs);
      
      
      // Keyboard Operations :
      driver.findElement(By.id("xX4UFf")).sendKeys(Keys.CONTROL+"a");
      driver.findElement(By.id("xX4UFf")).sendKeys(Keys.CONTROL+"c");
      driver.findElement(By.id("CwYCWc")).sendKeys(Keys.CONTROL+"v");
      driver.findElement(By.id("mSoczb")).sendKeys(Keys.TAB);	
	}

}
