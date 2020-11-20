import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/tarique/workspace/Basics/Browser/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
				
/*Imp Question :How will you get to know how many links available on Page or give me the text for every link
Get the to total Count of links on Page & Text for those links
Deal with no of elements So findElements*/
	
		// As links start with tag name [a], So used tagName locator
		// with findElements(), We don't use .click() & .sendKeys()
		// How many links are there --> used tagName --> a
		// How many input fields are there --> tagName --> input
		// How many buttons are there ---> tagName --> button	
		
		// For total Links available on page 
	List<WebElement> linkElement = driver.findElements(By.tagName("a")); 
	
	System.out.println(linkElement.size());
	for(int i=0; i<=linkElement.size(); i++)
	{ 
		String textfield = linkElement.get(i).getText();
		System.out.println(textfield);
		/*// More
		if(textfield.equals("Places"))
		{
			linkElement.get(i).click();
			break;
		}
		
	}*/
	
	}
		
	 // For total input fields 
	
	/*
	 * List<WebElement> inputFields = driver.findElements(By.tagName("input"));
	 int size = inputFields.size(); // as its Dynamic if change in Future So taking this instead of 6
	 System.out.println(size);
	 
	 for(int i =1; i<=inputFields.size(); i++)
	 {
		 String text = inputFields.get(i).getText();
		 System.out.println(text);
	 }
		
	}*/

	}
}
