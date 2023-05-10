import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		
		//1. Give the count of all links in this page
		int linksCountJK = driver.findElements(By.tagName("a")).size();
		System.out.println(linksCountJK);
		Assert.assertEquals(linksCountJK, 27);
		
		//2. Give the count of links in the footer section of this page - my Solution
		List<WebElement> linksFooter = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		System.out.println(linksFooter.size());
		
		
		//2. Create a driver for footer section only - Rahul's solution - Limiting WebDriver's scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println( footerDriver.findElements(By.tagName("a")).size());
		
		
		//3. Give the count of links in the footer section of this page for the first column
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println( columnDriver.findElements(By.tagName("a")).size());
		
		
		
	/*	//4. Click on each link in the column and check if the pages are opening
		//Za svaki link odradi Action sa ctrl+click da se otvori u novom tab, array linkova i array sa svim otvorenim tabovima
		//kroz prvu For petlju iteriram windows tabs, kroz drugu listu sa linkovima i kad se match-uju odradim assert
		//Vazna napomena, ovo radi samo ako lista sa windows tabs ide od nazad (childId04...childId01)
		
		//We need the Actions class
				Actions act = new Actions(driver);
		
		for (int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++)
		{
			//columnDriver.findElements(By.tagName("a")).get(i).click();
			act.moveToElement(columnDriver.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		
		//For switching to another window or tab
		Set<String> windowsAll = driver.getWindowHandles(); // Set<String> for this getWindowHandles()
		Iterator<String> iter = windowsAll.iterator(); //import java.util.Iterator;
		String parentId = iter.next();
		String childId01 = iter.next();
		String childId02 = iter.next();
		String childId03 = iter.next();
		String childId04 = iter.next();
		
		String [] wantedURL = {"https://www.restapitutorial.com/", "https://www.soapui.org/", "https://www.udemy.com/course/mobile-automation-using-appiumselenium-3/?referralCode=C46BF551F5B9EAF08E10", "https://jmeter.apache.org/"};
		
		String[] childWindows = {childId04, childId03, childId02, childId01};
		//List arrayListWantedUrl = Arrays.asList(wantedURL);
		//List arrayListChildren = Arrays.asList(childWindows);
		
		for (int j=0; j<childWindows.length; j++)
		{
			String children = childWindows[j];
			driver.switchTo().window(children);
			
			for(int k=0; k<wantedURL.length; k++)
			{
				
				if (j==k)
				{
					String urls = wantedURL[k];
					String urlCurrent02 = driver.getCurrentUrl();
					Assert.assertEquals(urlCurrent02, urls);
				}
				
				
			}
		}*/
		
		
		
		//4. Click on each link in the column and check if the pages are opening - Rahul's solution
		
		for (int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++)
		{
			//We need the Actions class
			Actions act = new Actions(driver);
			act.moveToElement(columnDriver.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
					
			
		}
		
		Set<String> windowsAll = driver.getWindowHandles(); // Set<String> for this getWindowHandles()
		Iterator<String> iter = windowsAll.iterator(); //import java.util.Iterator;
		
		while(iter.hasNext())
		{
			driver.switchTo().window(iter.next());
			System.out.println(driver.getTitle());
		}
		
		
	}

}
