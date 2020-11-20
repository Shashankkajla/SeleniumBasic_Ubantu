import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBasicAuthenticationPopUp {

	public static void main(String[] args) {
      
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		
		
          /*How to Handle Authentication Pop Up*/
		
		// Unable to inspect this So to handle it, Don't give user name, pwd give pop up to enter
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		// https://username:password@testdomain  -- > internet.herokuapp.com/basic_auth
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		boolean b = driver.findElement(By.xpath("//a[text(),'Elemental Selenium']")).isDisplayed();
		System.out.println(b);
	}

}
