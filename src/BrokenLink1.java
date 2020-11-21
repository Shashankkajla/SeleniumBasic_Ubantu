import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import sun.net.www.protocol.mailto.MailToURLConnection;

public class BrokenLink1 {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://makemysushi.com/404");
		
		
		List<WebElement> listLink = driver.findElements(By.tagName("a"));
		listLink.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Size of all links are " +listLink.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i=0; i<listLink.size(); i++){
			System.out.println(listLink.get(i).getAttribute("href"));
			if(listLink.get(i).getAttribute("href")!= null && ( ! listLink.get(i).getAttribute("href").
					contains("mailto")));
			
			activeLinks.add(listLink.get(i));
			
		}
		
		System.out.println("Size of all links that have href "  +activeLinks.size());
		
		for(int j=0; j<activeLinks.size(); j++){
			
		HttpURLConnection connection= (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href"))
				.openConnection();
		
		    connection.connect();
			String responseIs = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+  "------>"  +responseIs);
			
			
			/*MailToURLConnection connection1 = (MailToURLConnection)new URL(activeLinks.get(j).
					getAttribute("href")).openConnection();
			connection1.connect();
			connection1.g*/
	
		}
		
	}

}
