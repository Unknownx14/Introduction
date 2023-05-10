import java.time.Duration;
import java.util.Set;
import java.util.Iterator;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		
		//For switching to another window or tab
		Set<String> windowsAll = driver.getWindowHandles(); // Set<String> for this getWindowHandles()
		Iterator<String> iter = windowsAll.iterator(); //import java.util.Iterator;
		String parentId = iter.next();
		String childId = iter.next();
		
		//Now we switched to another window or tab
		driver.switchTo().window(childId);
		
		/* Moj nacin
		String theEmail = driver.findElement(By.xpath("//a[contains(@href, '@')]")).getText();
		System.out.println(theEmail);*/
		
		//We have found the Email address
		String getEmail = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(getEmail);
		String [] splittedGetEmail01 = getEmail.split("at");
		System.out.println(splittedGetEmail01[1]);
		String [] splittedGetEmail02 = splittedGetEmail01[1].split("with");
		String theEmail = splittedGetEmail02[0].trim();
		System.out.println(theEmail);
		
		Thread.sleep(1000);
		//Now switch back to parent Window
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(theEmail);
		
	}

}
