import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello world");
		
	  List<WebElement> val = driver.findElements(By.xpath("//ul[@role='listbox']"
	  		+ "//li//div//div//div[@class='sbl1']//span"));
	    // Don't use contains
	  
	    int sizeIs = val.size();
	    System.out.println(sizeIs);
	    
	    for(int i=0; i<=val.size(); i++)
	    {
	    	String text = val.get(i).getText();
	    	System.out.println(text);
	    	
	    	if(text.contains("hello world in python"))
	    	{
	    		val.get(i).click();
	    	      break;
	    	      // use break either found stale element exception if not comes out from for loop.
	    	}
	    	
	    }
	    
	    
	
	}

}
