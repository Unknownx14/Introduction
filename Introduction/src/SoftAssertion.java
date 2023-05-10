import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//Soft assertion, SoftAssert class
		SoftAssert softAss = new SoftAssert();
		
		
		//Url is not working 404 Not found
		// Java method will call all URLs and get the status code
		
		
		
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
			
			String textOfURL = allURLs.get(i).getText();
			//Assert.assertTrue(responseCodeJK<400, textOfURL + " - This is the text name of the broken link"); //Here is the neat code
			//so we do not need that IF loop
			//Assert.assertTrue() if returns FALSE then the message is displayed
			
			softAss.assertTrue(responseCodeJK<400, textOfURL + " - This is the text name of the broken link and the code is "+responseCodeJK);//But here is the neat code
			//and a SoftASsert is used - the script will not stop, but continue to work once the first broken link has been found
			
			
			/*if(responseCodeJK>400)
			{
				String textOfURL = allURLs.get(i).getText();
				System.out.println("Attention - "+responseCodeJK);
				System.out.println(singleURL+" - This is a broken link");
				System.out.println(textOfURL + " - This is the text name of the broken link");
				Assert.assertTrue(false); //The script will stop at the first broken link, it will not continue to check the remaining links
			}*/
		}
		
		softAss.assertAll();
		
	}

}
