import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericDynamicDropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	WebElement clickDown = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
    clickDown.click();
	WebElement selVal1 = driver.findElement(By.xpath("//a[contains(text(), 'Jaipur (JAI)')]"));
     selVal1.click();
     // It will take vale from 1str DropDown as its Dynamic in nature, So to over come add 2 in xpath 
     //(By.xpath("//a[contains(text(),'Pune (PNQ)')]"));
     // (By.xpath("(//a[contains(text(),'Pune (PNQ)')])[2]"));
     WebElement selVal2 = driver.findElement(By.xpath("(//a[contains(text(),'Pune (PNQ)')])[2]"));
     selVal2.click();
     
	}
	
	
	

}
