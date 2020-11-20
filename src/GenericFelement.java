import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericFelement {

public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");
	WebDriver driver = new ChromeDriver();
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("u_0_2")).click();
    Thread.sleep(2000);  
    
    //Storing values of WebElement 
    WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
    WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
    WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
    
    iselect(dayElement, "20"); //day
    iselect1(monthElement , "Jun"); // month
    iselect1(yearElement, "1995");  // year
 
    //driver.quit();    
}
 //Generic Select Method for value 
 public static void iselect(WebElement element, String value)
 {
	 Select select = new Select(element);
	 select.selectByValue(value);
  }
  // For visible Text
 public static void iselect1(WebElement element1, String value1)
 {
	 Select select1 = new Select(element1);
	 select1.selectByVisibleText(value1);
  }
 
	
 }
