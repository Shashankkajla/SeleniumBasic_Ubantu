import org.openqa.selenium.Alert; // alert
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClass {

	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	
	driver.findElement(By.xpath("//body/div[@id='easycont']/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
	
  /*import org.openqa.selenium.Alert; // alert
   * Alert is an Interface remember that
  switchTo() is a method from where you wan to switch from 1 window to another window popUp.
  alert.dismiss() for Cancel
  	alert.accept();
  	String str = alert1.getText();
  *
  */

	Alert alert = driver.switchTo().alert();
	alert.accept();
	
  //To get the popUp text, We need to Know are we present there or not after switch.
	
	driver.findElement(By.xpath("//body/div[@id='easycont']/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
	
	Alert alert1 = driver.switchTo().alert();
	String str = alert1.getText();
	System.out.println(str);
	
    if(str.equals("I am an alert box!"))
    {
    	alert1.accept();
        System.out.println("valid Destination");
    }
    else{
    	alert1.dismiss();
    	System.out.println("Not a valid Destination");
    }
	
	
/*  	alert() returns obj of RemoteAlert which implements the Alert interface
*/	
		
	}

}
