import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select; // Select

public class FElements {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("u_0_2")).click();
        Thread.sleep(2000);
        
        /*selectByIndex​(int index)	
    	Select the option at the given index.
    	void	selectByValue​(java.lang.String value)	
    	Select all options that have a value matching the argument.
    	void	selectByVisibleText​(java.lang.String text)	
    	Select all options that display text matching the argument.
        De-select same
        
        import org.openqa.selenium.support.ui.Select; // Select
        
        */
        Select sel = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        sel.selectByValue("20");  
    	
        Select sel1 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        sel1.selectByVisibleText("Jun");
        Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        sel2.selectByValue("1995");
		
		driver.quit();
        
        
        
	}
	
	
	
}
