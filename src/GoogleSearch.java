import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Ankita Tyagi");
		
		List<WebElement> val = driver.findElements(By.xpath("//ul[@class='erkvQe' and @role='listbox']"
				+ "//li[@role='presentation']//div//div//div[@class='sbl1']//span"));
		
		int size_is = val.size();
		System.out.println(size_is);
		
		for(int i=0; i<=val.size(); i++)
		{
			String textis = val.get(i).getText();
			System.out.println("Value is "  +textis);
			
		  if(textis.equals("ankita tyagi daffodil"))
		  {
			 val.get(i).click();
			  break;
		  }
		}
			
	}

}
