import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericFindElements {
 public static void main(String[] args) throws InterruptedException {
	
	
	System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	 
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.facebook.com/");
	 
   //Able to select value also from select using findElements()
    driver.findElement(By.id("u_0_2")).click();
    Thread.sleep(2000);
    iElements(driver);
   
 }
 
  public static void iElements(WebDriver driver)
  {
	 List<WebElement> dayElement = driver.findElements(By.xpath("//select[@id='day']//option"));
	 //option write coz. under option tag there are values of days 
     int sizetotal = dayElement.size();
     System.out.println(sizetotal);
     for(int i=1; i<=dayElement.size(); i++)
     {
    	 String text = dayElement.get(i).getText();
    	 System.out.println(text);
    	 if(text.equals("10"))
    	 {
    		 dayElement.get(i).click();
    		 break;
    	 }
    	 
     }
	 
	 
  }
 
 
 
  }
