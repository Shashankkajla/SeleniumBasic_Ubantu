import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForwardBackWardSimulation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");	
        
        
              // Browser Simulations interview Question 
        // get,navigate.to() , : both are used to launch the URL, if you have to navigate to some external site in 
        // that case you have to use navigate.to() 
        
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        
        driver.navigate().back(); // to go back
        System.out.println(driver.getTitle());
        
        driver.navigate().forward(); // to go foeward
        System.out.println(driver.getTitle());
        
        
        driver.navigate().refresh(); // to refresh the page
        
	}

}
