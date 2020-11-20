import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='HTML, CSS']")).click();
		
		List<WebElement> val = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']"
				+ "//li//a//label"));
		
		int size = val.size();
		System.out.println(size);
		
		for(int i=0; i<=val.size(); i++)
		{
			String textis = val.get(i).getText();
			System.out.println(textis);
			
			if(textis.equals("Java"))
			{
				val.get(i).click();
				break;
			}
			
			
		}
		
	}

}
