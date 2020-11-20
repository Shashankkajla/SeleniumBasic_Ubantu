import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html?e=2");
	
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shashankk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		Thread.sleep(3000);
		
		// 1 Way : Using customize X-path,
		driver.findElement(By.xpath("//a[contains(text(),'Tuktuk Sexa')]"
				+ "/parent::td[@class='datalistrow']"
				+ "/preceding-sibling::td"
				+ "//input[@value='52763943']")).click();
		
		
		/*String textName= driver.findElement(By.xpath("//a[contains(text(),'Tuktuk Sexa')]"
				+ "/parent::td[@class='datalistrow']"
				+ "/preceding-sibling::td"
				+ "//input[@value='52763943']")).getText();
		System.out.println(textName);*/
		
		
		/*2 Way : 
		# Identify X-path, make before x-path & after x-path
		# Iterate it using for loop, as per given values concatenate i with it after & before and get the text
		# Use if condition to click check box
		*/
		
		//*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		
		
		String before_xpath= "//*[@id='vContactsForm']/table/tbody/tr[";
		String after_xpath= "]/td[2]/a";
		
		for(int i=4; i<=20; i++)
		{ // Note : if not append with i throws error IllegalXpathExpressiion, unable to locate
		      String textVal = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();	
		      System.out.println("Table values are "  +textVal);
		    
		  if(textVal.contains("Tuktuk Sexa"))
		  { //Check Box X-path -->> //*[@id="vContactsForm"]/table/tbody/tr[4]/td[1]/input

			  driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
		  }
		
		}
		
	}

}
