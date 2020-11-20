import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html?e=2");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		/*X-path  -->> starts with '//'
		contains() --> ["//tagName[contains(@attribute,'value')"]
		*/
		
		//If x-path is 1/1 in all page use that x-path only
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("shashankk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		
		driver.findElement(By.xpath("//input[@name='username'  or @placeholder='Username']")).clear();
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).clear();
	 
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("shashankk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		
		
		//driver.findElement(By.xpath("//a[text()='Pricing']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Pricing')]")).click();
		
		driver.findElement(By.xpath("//input[@type='submit'  or @value='Login']")).click();
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
		//Preceding X-path Dynamic WebTable 
        // Preceding Sibling --> Brother -Sister & Brother-Brother same tag <td> <td> siblings
		// <tr> <td>  --> D/f Parent
	
	   driver.findElement(By.xpath("//a[text()='Tom Rusk']/parent::td/preceding-sibling::td"
	   		+ "//input[@type='checkbox' and @name='contact_id']")).click();
	
	  driver.findElement(By.xpath("//a[text()='Mohan Sohan']"
	  		+ "/parent::td/preceding-sibling::td"
	  		+ "//input[@type='checkbox']")).click();
	
	  driver.findElement(By.xpath("//a[text()='Rohan Kaja']"
	  		+ "/parent::td/preceding-sibling::td"
	  		+ "//input[@type='checkbox' "
	  		+ "and @name='contact_id']")).click();
	  
	 // To make it more Robust
	  driver.findElement(By.xpath("//a[text()='Tuktuk Sexa']"
	  		+ "/parent::td[@class='datalistrow']" // add @className as well 
	  		+ "/preceding-sibling::td[@class='datalistrow']" // add @className as well
	  		+ "//input[@type='checkbox' and @value='52763943']")).click();
	  
	  // Some time there is no parent So directly wee can also use in this way
//driver.findElement(By.xpath("//a[text()='Tom Rusk']/preceding-sibling::td//input[@type='checkbox']")).click();
	  
	  
	  
	  // if id is dynamic in nature changing on refreshing the page every time
	  // uid_112 -1 then
	  // uid_113 -2
	  
	  /*driver.findElement(By.xpath("//div[contains(starts-with(),'uid_')]")).click();
	  driver.findElement(By.xpath("//div[contains(ends-with(),'_uid')]")).click();
	  */
	  // Note if contains having 3-4 x-path than remove contains and make it in simple way

	  // BootStrap & Google Search Engine & row vala X-path will perform further
	  
	  
	}

}
