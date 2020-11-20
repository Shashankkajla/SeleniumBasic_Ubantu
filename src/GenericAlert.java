import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericAlert {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	
	WebElement clickElement = driver.findElement(By.xpath("//body/div[@id='easycont']/div[1]/div[2]/div[1]/div[2]/button[1]"));
	clickElement.click();
   
	ialert(driver, "I am an alert box!");
	
	}	
// Generic Alert Method
 public static void ialert(WebDriver driver, String text){
	  Alert alert = driver.switchTo().alert();
	   String value_text = alert.getText();
	   if(value_text.equals(text)){
		   alert.accept();
	        System.out.println("valid Destination");
	   }
	   else{
		  alert.dismiss();
	    System.out.println("Not a valid Destination");
	   }
 }
	   

}	 
	 
	 
	 
