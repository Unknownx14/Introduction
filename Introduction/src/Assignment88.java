import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		//Click on a link Multiple Windows
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		//For switching to another window or tab
				Set<String> windowsAll = driver.getWindowHandles(); // Set<String> for this getWindowHandles()
				Iterator<String> iter = windowsAll.iterator(); //import java.util.Iterator;
				String parentId = iter.next();
				String childId = iter.next();
				
		driver.switchTo().window(childId);
		String childText = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(childText);
		
		driver.switchTo().window(parentId);
		String parentText = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(parentText);
		
		
		
		
		
	}

}
