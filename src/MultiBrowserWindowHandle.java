import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiBrowserWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		System.out.println("parentWindow id " +parentWindow);
		
		String childWindow1 = it.next();
		System.out.println("childWindow1 Id is " +childWindow1);
		
		String childWindow2 = it.next();
		System.out.println("childWindow1 Id is " +childWindow2);
		
		Thread.sleep(4000);
		driver.switchTo().window(childWindow1);
		String childWindow1Title = driver.getTitle();
		System.out.println("childWindow1Title is "  +childWindow1Title);
		driver.close();
		
		Thread.sleep(4000);
		driver.switchTo().window(childWindow2);
		String childWindow2Title = driver.getTitle();
		System.out.println("childWindow2Title is "  +childWindow2Title);
		driver.close();
		
		Thread.sleep(4000);
		driver.switchTo().window(parentWindow);
		String parentWindowTitle = driver.getTitle();
		System.out.println("parentWindowTitle is"  +parentWindowTitle);
		driver.close();
		
		
		driver.quit();
		
		
	}

}
