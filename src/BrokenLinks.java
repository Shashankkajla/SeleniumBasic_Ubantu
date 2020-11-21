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

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://classic.freecrm.com/index.html?e=2");
		/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shashankk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]")).click();
		
		driver.switchTo().frame("mainpanel");
		*/
		// links --> a
		// img --> image
		List<WebElement> linkList= driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		int size = linkList.size();
		System.out.println("Size of all links ---> " +size);
		
		//activeLinks for href tag
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. Iterate linkList == exclude all links a & img which doesn't contains href attribute
		for(int i=0; i<linkList.size(); i++){ 
			// don't use <= it would give IndexoutofBoundException
			// System.out.println(linkList.get(i).getAttribute("href")); // printing this for Js links
			if(linkList.get(i).getAttribute("href") !=null && ( !linkList.get(i).getAttribute("href").
					contains("javascript")) ){
				// if Js have makes true than explecation mark make it false exclude it
				activeLinks.add(linkList.get(i)); // stored in activeLinks 1 by 1 if having tag href	
			}
		}
		// get the size of update links having href
		System.out.println("Size of activeLinks   -->  " +activeLinks.size());
	
		//3. Check the href  Url, with the https connection
		// 200--> ok
		// 404 --> not found
		// 500 --> internal error
		// 400 --> Bad request
		for(int j=0; j<activeLinks.size(); j++)
		{  
			
			/*new URL class is available passing URL(String), that particular URL i am type casting it to
			 *  HttpURLConnection : A URL Connection with support for HTTP- specific feature, So if you 
			 *  try to connect with any http protocol, we know all url associated with http protocol
			 *  So it will open the connection for particular URL, once the connection is open it will store it in 
			 *  connection object & with this we will try to connect it
			 * 			connection.connect();

			 * 
			 * */	
		HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).
					getAttribute("href")).openConnection();
			
			connection.connect();
			String messageIs = connection.getResponseMessage(); // if link is fine it will return ok
			// otherwise it will return error.
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+ "---->"  +messageIs);
			
			// given some link unkwnon protocol javaScript, So do some changes as
			// we don't ned to check these ones 
			
// javascript:void(openWin('https://help.crmpro.com/', 'helpwin', 'width=1024,height=1024,resizable,scrollbars,statusbar'));
// exclude it for today to check for the link we do String manipulation & get the link for it
			
				
			
		}
		
	}

}
