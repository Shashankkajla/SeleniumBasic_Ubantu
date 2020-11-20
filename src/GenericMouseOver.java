import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GenericMouseOver {

public static void main(String[] args) throws InterruptedException {
	
	
	System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");
	WebDriver driver = new ChromeDriver();
    driver.get("https://abstracta.us/solutions/");	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
    driver.findElement(By.xpath("//a[contains(text(),'Got it!')]")).click(); // got it
    
    WebElement moveThere = driver.findElement(By.xpath("//nav[@id='navbar']/div[1]/ul[1]/div[4]/button[1]/a[1]"));
    WebElement selectIt = driver.findElement(By.linkText("Podcast"));
    
    iMouseOver(driver, moveThere, selectIt);
}

public static void iMouseOver(WebDriver driver, WebElement move_To, WebElement element_name)
{
    Actions ac = new Actions(driver);
    ac.moveToElement(move_To).build().perform();
    element_name.click();
 }

}
