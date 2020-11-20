import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

 public static void main(String[] args) throws InterruptedException {
		
	 System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html?e=2");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shashankk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]")).click();
		Thread.sleep(3000);
		
		/*Frame, this Frame on right click, view Frame Source or This Frame, Frame available thats why driver 
		driver throws error unable to find elements
		Open page Source to check frame --> ctrl+f iframe check or frame
		driver.switchTo().frame(int args) int value 0, 1
		Accept either integer or String.
		*/
		
		//Unable to locate element, no such element
		iswitch(driver, "mainpanel");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
	}
	
 //Generic frame method
 public static void iswitch(WebDriver driver, String text){
	 
	 driver.switchTo().frame(text);
 }
 
 
/* Either x-path wrong or there is a Frame in app for --> No such element found execption or timeOut
*/ 
}
