import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandler {
 
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*windowHandler api is present in selenium lib. to handle windows popUps
		 * To switch to child window from parent to perform some actions we need window id
		 * to get window id of parent & child we have window handler.
		 * Set<String> : to iterate the value from it we have iterator<I>, So to get the value from Set<obj>
		 * we have to use iterator to calll iterator<I>, we have iterator() in it.
		 * */
		
		driver.findElement(By.xpath("//a[contains(text(),'  Follow On Twitter')]")).click();
		
		Set<String> handler= driver.getWindowHandles();
		// will give you 1 set obj.obj name is handler
		Iterator<String> it = handler.iterator();
		// now iterator is pointing on above the set objSo we use next , now it comes to parent window id.
		String parentWindow = it.next();
		System.out.println("Parent Window Id " +parentWindow);
		// again use next now it comes to the child window id
		String childWindow = it.next();
		System.out.println("childWindow Id" +childWindow);
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		String titleIs = driver.getTitle();
		System.out.println(titleIs);
		
		
		/*It is used to close specific browser popUp, if you use quit it will close all windows 
		 * both parent & child, quit() means quit the instance of Web Browser 
		 * */	
		driver.close(); // you will close particular pop up which opens
		//now switch the pointer to parent window now selenium control comes to parent
		
		driver.switchTo().window(parentWindow);
		String parentTitle = driver.getTitle();
		System.out.println("pasrentTitle is " +parentTitle);	
		
	}	
}
