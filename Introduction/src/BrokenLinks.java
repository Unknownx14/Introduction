import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
	
		
		//Url is not working 404 Not found
		// Java method will call all URLs and get the status code
		
		
		//Rahul - just for one URL
		String urlRahul = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href"); //a[href*='brokenlink']
		
		HttpURLConnection conn = (HttpURLConnection) new URL(urlRahul).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect(); //These 3 lines are making some sort of connection
		int responseCodeRahul = conn.getResponseCode(); //using the response
		System.out.println(responseCodeRahul);
		
		
		
		
		//MY TRY
		List<WebElement> allURLs = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		
		for (int i=0; i<allURLs.size(); i++)
		{
			String singleURL =allURLs.get(i).getAttribute("href");
			
			HttpURLConnection connJK = (HttpURLConnection) new URL(singleURL).openConnection();
			connJK.setRequestMethod("HEAD");
			connJK.connect(); //These 3 lines are making some sort of connection
			int responseCodeJK = connJK.getResponseCode(); //using the response
			System.out.println(responseCodeJK+" from my List");
			
			if(responseCodeJK>400)
			{
				String textOfURL = allURLs.get(i).getText();
				System.out.println("Attention - "+responseCodeJK);
				System.out.println(singleURL+" - This is a broken link");
				System.out.println(textOfURL + " - This is the text name of the broken link");
				Assert.assertTrue(false); //The script will stop at the first broken link, it will not continue to check the remaining links
			}
		}
			
		
		
		
	}

}
